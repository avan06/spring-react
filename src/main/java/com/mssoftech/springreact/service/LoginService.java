package com.mssoftech.springreact.service;

import static org.seasar.util.beans.util.CopyOptionsUtil.include;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.dbflute.cbean.result.ListResultBean;
import org.dbflute.optional.OptionalEntity;
import org.dbflute.optional.OptionalScalar;
import org.seasar.util.beans.util.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.mssoftech.springreact.dbflute.cbean.LoginCB;
import com.mssoftech.springreact.dbflute.exbhv.LoginBhv;
import com.mssoftech.springreact.dbflute.exbhv.SessionBhv;
import com.mssoftech.springreact.dbflute.exentity.Login;
import com.mssoftech.springreact.dbflute.exentity.Session;
import com.mssoftech.web.exception.SystemException;
import com.mssoftech.web.util.CommonUtil;
import com.mssoftech.web.util.DBFluteUtil;
import com.mssoftech.web.util.LoginUtil;
import com.mssoftech.web.util.ServiceUtil;

@Component
@Transactional
public class LoginService {
	static protected Logger log = LoggerFactory.getLogger(LoginService.class);
	@Autowired
	public LoginBhv loginBhv;
	@Autowired
	public SessionBhv sessionBhv;
	private int MAX_RECORD = 100;

	// @Transactional(propagation = Propagation.REQUIRES_NEW)
	public HashMap loginAuth(HashMap params, HttpServletRequest request,
			HttpServletResponse response) {

		return loginAuthSub(params, request, response, true);
	}

	public HashMap loginAuthRemote(HashMap params, HttpServletRequest request,
			HttpServletResponse response) {
		return loginAuthSub(params, request, response, false);
	}

	public HashMap loginAuthSub(HashMap params, HttpServletRequest request,
			HttpServletResponse response, boolean useCookie) {
		Login login = getLoginFromLoginIｄ(params);
		// not found
		if (login == null) {
			return DBFluteUtil.setErrorMessage("ユーザー IDが見つかりません", params);
		}
		if (!(LoginUtil.createMd5((String) params.get("password")))
				.equals(login.getPassword())) {
			return DBFluteUtil.setErrorMessage("passwordが違います", params);
		}
		DBFluteUtil.setUserProcessToAccessContext(login.getLoginId(),
				"loginAuth");
		Session session = createNewSession(login);
		HashMap loginInfo = createLoginInfo(login, session);
		if (useCookie) {
			addUuidCookie(response, session);
		} else {
			loginInfo.put("uuid", session.getUuid());
		}
		return DBFluteUtil.setFetchResult(loginInfo, params);
	}

	private HashMap createLoginInfo(Login login, Session session) {
		HashMap loginInfo = new HashMap();
		loginInfo.put("uid", login.getId());
		loginInfo.put("name", login.getName());
		return loginInfo;
	}

	private void addUuidCookie(HttpServletResponse response, Session session) {
		Cookie cuuid = new Cookie("uuid", session.getUuid());
		cuuid.setPath("/");
		response.addCookie(cuuid);
	}

	private Session createNewSession(Login login) {
		log.debug("createNewSession");
		String uuid = UUID.randomUUID().toString();
		Session session = new Session();
		session.setUuid(uuid);
		session.setLoginId(login.getId());
		sessionBhv.insert(session);
		return session;
	}

	private Login getLoginFromLoginIｄ(HashMap params) {

		ListResultBean<Login> selectList = loginBhv.selectList(cb -> {
			cb.query().setLoginId_Equal((String) params.get("loginId"));
			cb.query().setDelFlag_Equal(0);
		});
		if (selectList.size() == 1) {
			return selectList.get(0);
		}
		return null;
	}

	public HashMap logout(HashMap params, HttpServletRequest request,
			HttpServletResponse response) {
		Session session = LoginUtil.getSessionFromRequestCookie(request,
				sessionBhv);
		clearUuidCookie(response);
		if (session == null) {
			return DBFluteUtil.setErrorMessage(
					"login not found. Already Logout", params);
		}
		if (session.getDelFlag() > 0) {
			return DBFluteUtil.setErrorMessage("Already Logout", params);
		}
		Login emp = LoginUtil.getLoginFromSession(session, loginBhv);
		DBFluteUtil.setUserProcessToAccessContext(emp.getLoginId(), "logout");
		session.setDelFlag(1);
		sessionBhv.update(session);
		return DBFluteUtil.setFetchResult("OK", 0, 0, 1, params);
	}

	private void clearUuidCookie(HttpServletResponse response) {
		Cookie cuuid = new Cookie("uuid", "");
		cuuid.setPath("/");
		response.addCookie(cuuid);
	}

	public HashMap execute(HashMap params, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Session session = LoginUtil.getSessionFromRequestCookie(request,
				sessionBhv);
		if (session == null) {
			throw new SystemException("セッションがありません。再度ログインして下さい。");
		}
		Login emp = LoginUtil.getLoginFromSession(session, loginBhv);
		HashMap res = LoginUtil.checkLogin(session, params);
		if (res != null) {
			return res;
		}
		ArrayList transactions = (ArrayList) params.get("transactions");
		if (transactions != null) {
			return transaction(transactions, request, session, emp, params);
		}
		String op = (String) params.get("operationType");
		if (op.equals("fetch")) {
			return fetchProc(params, request, session, emp);
		}
		if (op.equals("update")) {
			return updateProc(params, request, session, emp);
		}
		if (op.equals("remove")) {
			return deleteProc(params, request, session, emp);
		}
		if (op.equals("add")) {
			return insertProc(params, request, session, emp);
		}
		if (op.equals("passwordChg")) {
			return passwordChg(params, request, session, emp);
		}
		throw new SystemException("operationType notfound :" + op);
	}

	private HashMap transaction(ArrayList<HashMap> transactions,
			HttpServletRequest request, Session session, Login emp,
			HashMap params) throws Exception {
		ArrayList transactionResult = new ArrayList();
		for (HashMap operation : transactions) {
			HashMap res = executeEachTransaction(operation, request, session,
					emp, params);
			HashMap response = (HashMap) res.get("response");
			response.put("queueStatus", 0);
			Integer status = (Integer) ((HashMap) res.get("response"))
					.get("status");
			if (status < 0) {
				return res;
			}
			transactionResult.add(res);
		}
		// HashMap tran = new HashMap();
		// tran.put("responses", transactionResult);
		// tran.put("startTimeStamp", params.get("startTimeStamp"));
		// tran.put("class", params.get("class"));
		// return tran;
		return DBFluteUtil.setFetchResult(transactionResult, params);
	}

	private HashMap executeEachTransaction(HashMap params,
			HttpServletRequest request, Session session, Login emp,
			HashMap params2) throws Exception {
		params.put("startTimeStamp", params2.get("startTimeStamp"));
		params.put("class", params2.get("class"));
		String op = (String) params.get("operationType");

		if (op.equals("update")) {
			return updateProc(params, request, session, emp);
		}
		if (op.equals("add")) {
			return insertProc(params, request, session, emp);
		}
		return null;
	}

	private HashMap passwordChg(HashMap params, HttpServletRequest request,
			Session session, Login emp) throws Exception {
		String oldPassword = (String) params.get("oldPassword");
		String newPassword1 = (String) params.get("newPassword1");
		String newPassword2 = (String) params.get("newPassword2");
		if (!emp.getPassword().equals(LoginUtil.createMd5(oldPassword))) {
			throw new SystemException("現在のパスワードが一致しません");
		}
		if (!newPassword1.equals(newPassword2)) {
			throw new SystemException("新しいパスワードが一致しません");
		}
		emp.setPassword(LoginUtil.createMd5(newPassword1));
		loginBhv.update(emp);
		return DBFluteUtil.setFetchResult("OK", params);
	}

	private HashMap insertProc(HashMap params, HttpServletRequest request,
			Session session, Login emplogin) throws Exception {
		DBFluteUtil.setUserProcessToAccessContext(emplogin.getLoginId(),
				"emp:insert");
		Map newLogin = (Map) params.get("data");
		Login emp = null;
		try {
			emp = BeanUtil.copyMapToNewBean(newLogin, Login.class);
		} catch (Exception e) {
			ServiceUtil.mapToNewBeanExceptionAnalyze(e);
		}
		if (employeeNoDupCheck(emp)) {
			throw new SystemException("この 社員番号は既に使用されています。");
		}
		HashMap res;
		emp.setPassword(LoginUtil.createMd5(emp.getPassword()));
		loginBhv.insert(emp);
		Map map = entityToMap(emp);
		res = DBFluteUtil.setFetchResult(map, params);
		return res;
	}

	private boolean employeeNoDupCheck(Login emp) {
		ListResultBean<Login> selectList = loginBhv.selectList(cb -> {
			cb.query().setLoginId_Equal(emp.getLoginId());
			cb.query().setDelFlag_Equal(0);
		});
		return (selectList.size() > 0);
	}

	private HashMap deleteProc(HashMap params, HttpServletRequest request,
			Session session, Login emp) throws Exception {
		DBFluteUtil.setUserProcessToAccessContext(emp.getLoginId(),
				"emp:delete");
		BigDecimal bid = (BigDecimal) params.get("data");
		Integer id = bid.intValue();
		final OptionalEntity<Login> del = loginBhv.selectByPK(id);
		if (!del.isPresent()) {
			throw new SystemException("Login id=" + id.toString() + "が有りません");
		}
		Login delx = del.get();
		delx.setDelFlag(getDelFlagMaxValue(delx) + 1);
		loginBhv.update(delx);
		return DBFluteUtil.setFetchResult(entityToMap(delx), params);
	}

	private int getDelFlagMaxValue(final Login del) {
		OptionalScalar<Integer> max = loginBhv.selectScalar(Integer.class).max(
				cb -> {
					cb.specify().columnDelFlag();
					cb.query().setLoginId_Equal(del.getLoginId());
				});
		if (max.isPresent()) {
			return max.get();
		}
		return 1;
	}

	private HashMap updateProc(HashMap params, HttpServletRequest request,
			Session session, Login emp) throws Exception {
		DBFluteUtil.setUserProcessToAccessContext(emp.getLoginId(),
				"emp:update");
		Map updateInput = (Map) params.get("data");
		Login upd = null;
		try {
			upd = BeanUtil.copyMapToNewBean(updateInput, Login.class);
		} catch (Exception e) {
			ServiceUtil.mapToNewBeanExceptionAnalyze(e);
		}
		OptionalEntity<Login> old = loginBhv.selectByPK(upd.getId());
		Login oldx = null;
		if (old.isPresent()) {
			oldx = old.get();
		} else {
			throw new SystemException("Login id=" + upd.getId().toString()
					+ " が見つかりません");
		}
		convertPassword(upd, oldx);
		if (!upd.getLoginId().equals(oldx.getLoginId())
				&& employeeNoDupCheck(upd)) {
			throw new SystemException("この 社員番号は既に使用されています。");
		}
		loginBhv.update(upd);
		Map map = entityToMap(upd);
		return DBFluteUtil.setFetchResult(map, params);
	}

	private void convertPassword(Login upd, Login old) {
		if (upd.getPassword() != null) {
			upd.setPassword(LoginUtil.createMd5(upd.getPassword()));
		} else {
			upd.setPassword(old.getPassword());
		}
	}

	private HashMap fetchProc(HashMap params, HttpServletRequest request,
			Session session, Login emp) throws Exception {
		DBFluteUtil.setUserProcessToAccessContext(emp.getLoginId(),
				"login:fetch");
		ListResultBean<Login> res = null;
		HashMap data = (HashMap) params.get("data");
		res = loginBhv.selectList(cb -> {
			cb.query().setDelFlag_Equal(0);
			cb.query().addOrderBy_LoginId_Asc();
			cb.paging(MAX_RECORD, 1);
			cb.query();
			setupQueryCriteria(cb, data);

		});
		ArrayList ar = resultToMap(res);
		return DBFluteUtil.setFetchResult(ar, 0, 0, res.size(), params);
	}

	private ArrayList resultToMap(ListResultBean<Login> res) {
		ArrayList ar = new ArrayList();
		for (Login emp : res) {
			Map map = entityToMap(emp);
			ar.add(map);
		}
		return ar;
	}

	private Map entityToMap(Login login) {
		Map map = BeanUtil.copyBeanToNewMap(
				login,
				include("id", "loginId", "name", "defCompany", "defFy", "adm",
						"versionNo"));
		return map;
	}

	private void setupQueryCriteria(LoginCB cb, HashMap data) {
		if (data != null) {
			List<Map> criteria = (List) data.get("criteria");
			if (criteria == null) {
				// initial open case no record return
				cb.query().setId_Equal(-99999);
				return;
			}
			for (int i = 0; i < criteria.size(); i++) {
				DBFluteUtil.setCriteria(cb.query(), criteria.get(i));
			}
		}
	}

}
