package com.mssoftech.springreact.service;

import static org.seasar.util.beans.util.CopyOptionsUtil.include;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.seasar.util.beans.util.BeanUtil;
import org.seasar.util.beans.util.CopyOptionsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mssoftech.springreact.domain.Login;
import com.mssoftech.springreact.domain.Session;
import com.mssoftech.web.exception.SystemException;
import com.mssoftech.web.util.DBFluteUtil;
import com.mssoftech.web.util.LoginUtil;
import com.mssoftech.web.util.ServiceUtil;

@Component
@Transactional
public class LoginService {
	static protected Logger log = LoggerFactory.getLogger(LoginService.class);

	@PersistenceContext
	private EntityManager em;
	@Autowired
	private LoginUtil loginUtil;

	private int MAX_RECORD = 100;

	// @Transactional(propagation = Propagation.REQUIRES_NEW)
	public HashMap<String, HashMap<String, Object>> loginAuth(HashMap<String, Object> params,
			HttpServletRequest request, HttpServletResponse response) {

		return loginAuthSub(params, request, response, true);
	}

	public HashMap<String, HashMap<String, Object>> loginAuthRemote(HashMap<String, Object> params,
			HttpServletRequest request, HttpServletResponse response) {
		return loginAuthSub(params, request, response, false);
	}

	public HashMap<String, HashMap<String, Object>> loginAuthSub(HashMap<String, Object> params,
			HttpServletRequest request, HttpServletResponse response, boolean useCookie) {
		Login login = getLoginFromLoginId(params);
		// not found
		if (login == null) {
			return DBFluteUtil.setErrorMessage("ユーザー IDが見つかりません", params);
		}
		if (!(loginUtil.createMd5((String) params.get("password"))).equals(login.getPassword())) {
			return DBFluteUtil.setErrorMessage("passwordが違います", params);
		}
		Session session = createNewSession(login);
		HashMap<String, Object> loginInfo = createLoginInfo(login, session);
		if (useCookie) {
			addUuidCookie(response, session);
		} else {
			loginInfo.put("uuid", session.getUuid());
		}
		return DBFluteUtil.setFetchResult(loginInfo, params);
	}

	private HashMap<String, Object> createLoginInfo(Login login, Session session) {
		HashMap<String, Object> loginInfo = new HashMap<String, Object>();
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
		Date d = new Date();
		String uuid = UUID.randomUUID().toString();
		Session session = new Session();
		session.setUuid(uuid);
		session.setLogin(login);
		session.setRole(login.getRole());

		session.setRegisterDatetime(d); //FIXME
		session.setRegisterUser("SYSTEM");
		session.setRegisterProcess(this.getClass().getSimpleName());
		session.setUpdateDatetime(d);
		session.setUpdateUser("SYSTEM");
		session.setUpdateProcess(this.getClass().getSimpleName());

		em.persist(session);
		return session;
	}

	private Login getLoginFromLoginId(HashMap<String, Object> params) {
		List<Login> loginList = em
				.createQuery("From Login where loginId = :loginId and delFlag = :delFlag", Login.class)
				.setParameter("loginId", params.get("loginId")).setParameter("delFlag", 0).getResultList();

		if (loginList.size() == 1) {
			return loginList.get(0);
		} else if (params.get("loginId") != null && String.valueOf(params.get("loginId")).length() > 0 && params.get("password") != null && String.valueOf(params.get("password")).length() > 0) {
			try { //FIXME test
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
				Date d = formatter.parse(String.valueOf(params.get("startTimeStamp")));

				Login login = new Login();
				login.setLoginId(String.valueOf(params.get("loginId")));
				login.setName(String.valueOf(params.get("loginId")));

				login.setPassword(loginUtil.createMd5((String) params.get("password")));
				login.setVersionNo(1);
				login.setDelFlag(0);
				
				login.setRegisterDatetime(d);
				login.setRegisterUser("SYSTEM");
				login.setRegisterProcess(this.getClass().getSimpleName());
				login.setUpdateDatetime(d);
				login.setUpdateUser("SYSTEM");
				login.setUpdateProcess(this.getClass().getSimpleName());
				
				login.setRole("1");

				em.persist(login);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return getLoginFromLoginId(params);
		}
		return null;
	}

	public HashMap<String, HashMap<String, Object>> logout(HashMap<String, Object> params, HttpServletRequest request,
			HttpServletResponse response) {
		Session session = loginUtil.getSessionFromRequestCookie(request);
		clearUuidCookie(response);
		if (session == null) {
			return DBFluteUtil.setErrorMessage("login not found. Already Logout", params);
		}
		if (session.getDelFlag() > 0) {
			return DBFluteUtil.setErrorMessage("Already Logout", params);
		}
		Login emp = loginUtil.getLoginFromSession(session);
		session.setDelFlag(1);
		em.merge(session);
		return DBFluteUtil.setFetchResult("OK", 0, 0, 1, params);
	}

	private void clearUuidCookie(HttpServletResponse response) {
		Cookie cuuid = new Cookie("uuid", "");
		cuuid.setPath("/");
		response.addCookie(cuuid);
	}

	public HashMap<String, HashMap<String, Object>> execute(HashMap<String, Object> params, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Session session = loginUtil.getSessionFromRequestCookie(request);
		if (session == null) {
			throw new SystemException("セッションがありません。再度ログインして下さい。");
		}
		Login emp = loginUtil.getLoginFromSession(session);
		HashMap<String, HashMap<String, Object>> res = loginUtil.checkLogin(session, params);
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

	private HashMap<String, HashMap<String, Object>> transaction(ArrayList<HashMap<String, Object>> transactions,
			HttpServletRequest request, Session session, Login emp, HashMap<String, Object> params) throws Exception {
		ArrayList<Object> transactionResult = new ArrayList<Object>();
		for (HashMap<String, Object> operation : transactions) {
			HashMap res = executeEachTransaction(operation, request, session, emp, params);
			HashMap<String, Object> response = (HashMap<String, Object>) res.get("response");
			response.put("queueStatus", 0);
			Integer status = (Integer) ((HashMap<String, Object>) res.get("response")).get("status");
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

	private HashMap<String, HashMap<String, Object>> executeEachTransaction(HashMap<String, Object> params,
			HttpServletRequest request, Session session, Login emp, HashMap<String, Object> params2) throws Exception {
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

	private HashMap<String, HashMap<String, Object>> passwordChg(HashMap<String, Object> params,
			HttpServletRequest request, Session session, Login emp) throws Exception {
		String oldPassword = (String) params.get("oldPassword");
		String newPassword1 = (String) params.get("newPassword1");
		String newPassword2 = (String) params.get("newPassword2");
		if (!emp.getPassword().equals(loginUtil.createMd5(oldPassword))) {
			throw new SystemException("現在のパスワードが一致しません");
		}
		if (!newPassword1.equals(newPassword2)) {
			throw new SystemException("新しいパスワードが一致しません");
		}
		emp.setPassword(loginUtil.createMd5(newPassword1));
		em.merge(emp);
		return DBFluteUtil.setFetchResult("OK", params);
	}

	private HashMap<String, HashMap<String, Object>> insertProc(HashMap<String, Object> params,
			HttpServletRequest request, Session session, Login emplogin) throws Exception {
		Map<String, Object> newLogin = (Map<String, Object>) params.get("data");
		Login emp = null;
		try {
			emp = BeanUtil.copyMapToNewBean(newLogin, Login.class);
		} catch (Exception e) {
			ServiceUtil.mapToNewBeanExceptionAnalyze(e);
		}
		if (employeeNoDupCheck(emp)) {
			throw new SystemException("この 社員番号は既に使用されています。");
		}
		HashMap<String, HashMap<String, Object>> res;
		emp.setPassword(loginUtil.createMd5(emp.getPassword()));
		em.persist(emp);
		Map map = entityToMap(emp);
		res = DBFluteUtil.setFetchResult(map, params);
		return res;
	}

	private boolean employeeNoDupCheck(Login emp) {
		List<Login> loginList = em
				.createQuery("From Login where loginId = :loginId and delFlag = :delFlag", Login.class)
				.setParameter("loginId", emp.getLoginId()).setParameter("delFlag", 0).getResultList();

		return (loginList.size() > 0);
	}

	private HashMap<String, HashMap<String, Object>> deleteProc(HashMap<String, Object> params,
			HttpServletRequest request, Session session, Login emp) throws Exception {
		BigDecimal bid = (BigDecimal) params.get("data");
		Integer id = bid.intValue();

		Login delLogin = em.find(Login.class, id);
		if (delLogin == null) {
			throw new SystemException("Login id=" + id.toString() + "が有りません");
		}
		delLogin.setDelFlag(getDelFlagMaxValue(delLogin) + 1);
		em.merge(delLogin);
		return DBFluteUtil.setFetchResult(entityToMap(delLogin), params);
	}

	private int getDelFlagMaxValue(final Login del) {
		Integer delFlagMax = em.createQuery("select max(delFlag) From Login where loginId = :loginId", Integer.class)
				.setParameter("loginId", del.getLoginId()).getSingleResult();

		if (delFlagMax != null) {
			return delFlagMax;
		}
		return 1;
	}

	private HashMap<String, HashMap<String, Object>> updateProc(HashMap<String, Object> params,
			HttpServletRequest request, Session session, Login emp) throws Exception {
		Map<String, Object> updateInput = (Map<String, Object>) params.get("data");
		Login upd = null;
		try {
			upd = BeanUtil.copyMapToNewBean(updateInput, Login.class);
		} catch (Exception e) {
			ServiceUtil.mapToNewBeanExceptionAnalyze(e);
		}

		Login dbLogin = em.find(Login.class, upd.getId());
		if (dbLogin == null) {
			throw new SystemException("Login id=" + upd.getId().toString() + " が見つかりません");
		}
		convertPassword(upd, dbLogin);
		if (!upd.getLoginId().equals(dbLogin.getLoginId()) && employeeNoDupCheck(upd)) {
			throw new SystemException("この 社員番号は既に使用されています。");
		}
		BeanUtil.copyBeanToBean(upd, dbLogin, CopyOptionsUtil.excludeNull().exclude("sessions"));
		em.merge(dbLogin);
		Map<String, Object> map = entityToMap(upd);
		return DBFluteUtil.setFetchResult(map, params);
	}

	private void convertPassword(Login upd, Login old) {
		if (upd.getPassword() != null && !"".equals(upd.getPassword())) {
			upd.setPassword(loginUtil.createMd5(upd.getPassword()));
		} else {
			upd.setPassword(old.getPassword());
		}
		
	}

	private HashMap<String, HashMap<String, Object>> fetchProc(HashMap<String, Object> params,
			HttpServletRequest request, Session session, Login emp) throws Exception {
		

		List<Login> loginList = em
				.createQuery("From Login where delFlag = :delFlag ORDER BY loginId", Login.class)
				.setParameter("delFlag", 0)
				.getResultList();

//		HashMap<String, Object> data = (HashMap<String, Object>) params.get("data");
//		res = loginBhv.selectList(cb -> {
//			cb.query().setDelFlag_Equal(0);
//			cb.query().addOrderBy_LoginId_Asc();
//			cb.paging(MAX_RECORD, 1);
//			cb.query();
//			setupQueryCriteria(cb, data); FIXME
//		});
		ArrayList<Map<String, Object>> ar = resultToMap(loginList);
		return DBFluteUtil.setFetchResult(ar, 0, 0, loginList.size(), params);
	}

	private ArrayList<Map<String, Object>> resultToMap(List<Login> res) {
		ArrayList<Map<String, Object>> ar = new ArrayList<Map<String, Object>>();
		for (Login emp : res) {
			Map<String, Object> map = entityToMap(emp);
			ar.add(map);
		}
		return ar;
	}

	private Map<String, Object> entityToMap(Login login) {
		Map<String, Object> map = BeanUtil.copyBeanToNewMap(login,
				include("id", "loginId", "name", "role", "versionNo"));
		return map;
	}

//FIXME
//	private void setupQueryCriteria(LoginCB cb, HashMap<String, Object> data) {
//		if (data != null) {
//			List<Map<String, Object>> criteria = (List<Map<String, Object>>) data.get("criteria");
//			if (criteria == null) {
//				// initial open case no record return
//				cb.query().setId_Equal(-99999);
//				return;
//			}
//			for (int i = 0; i < criteria.size(); i++) {
//				DBFluteUtil.setCriteria(cb.query(), criteria.get(i));
//			}
//		}
//	}

}