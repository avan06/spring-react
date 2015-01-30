package com.mssoftech.springreact.service;

import static org.seasar.util.beans.util.CopyOptionsUtil.include;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.mssoftech.springreact.dbflute.cbean.UserTableCB;
import com.mssoftech.springreact.dbflute.exbhv.LoginBhv;
import com.mssoftech.springreact.dbflute.exbhv.SessionBhv;
import com.mssoftech.springreact.dbflute.exbhv.UserTableBhv;
import com.mssoftech.springreact.dbflute.exentity.Login;
import com.mssoftech.springreact.dbflute.exentity.Session;
import com.mssoftech.springreact.dbflute.exentity.UserTable;
import com.mssoftech.web.exception.SystemException;
import com.mssoftech.web.util.DBFluteUtil;
import com.mssoftech.web.util.DatabaseConvertUtil;
import com.mssoftech.web.util.LoginUtil;
import com.mssoftech.web.util.ServiceUtil;

@Component
@Transactional
public class UserTableService {
	static protected Logger log = LoggerFactory
			.getLogger(UserTableService.class);
	@Autowired
	public UserTableBhv userTableBhv;
	@Autowired
	public LoginBhv loginBhv;
	@Autowired
	public SessionBhv sessionBhv;
	private int MAX_RECORD = 1000;

	public HashMap execute(HashMap params, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Session session = LoginUtil.getSessionFromRequestCookie(request,
				sessionBhv);
		if (session == null) {
			return DBFluteUtil.setErrorMessage("セッションがありません。再度ログインして下さい。",
					params);
		}
		Login login = LoginUtil.getLoginFromSession(session, loginBhv);
		HashMap res = LoginUtil.checkLogin(session, params);
		if (res != null) {
			return res;
		}
		String op = (String) params.get("operationType");
		if (op.equals("fetch")) {
			return fetchProc(params, request, session, login);
		}
		if (op.equals("update")) {
			return updateProc(params, request, session, login);
		}
		if (op.equals("remove")) {
			return deleteProc(params, request, session, login);
		}
		if (op.equals("add")) {
			return insertProc(params, request, session, login);
		}

		return null;
	}

	private HashMap insertProc(HashMap params, HttpServletRequest request,
			Session session, Login login) throws Exception {
		DBFluteUtil.setUserProcessToAccessContext(login.getLoginId(),
				"userTable:insert");
		@SuppressWarnings("unused")
		String screen = request.getParameter("screen");
		Map newin = preProc(params);
		UserTable newEntity = null;
		try {
			newEntity = BeanUtil.copyMapToNewBean(newin, UserTable.class);
		} catch (Exception e) {
			ServiceUtil.mapToNewBeanExceptionAnalyze(e);
		}
		if (userTableCodeDupCheck(newEntity)) {
			return DBFluteUtil.setErrorMessage("このDataは既に使用されています。", params);
		}

		HashMap res;
		userTableBhv.insert(newEntity);
		Map map = null;
		map = entityToMap(newEntity);
		res = DBFluteUtil.setFetchResult(map, params);
		return res;
	}

	private Map preProc(HashMap params) {
		Map newin = (Map) params.get("data");
		convertToUpper(newin);
		DatabaseConvertUtil
				.convertToStringWhenNull(newin, "key1", "key2", "fy");
		return newin;
	}

	private void convertToUpper(Map newin) {
		DatabaseConvertUtil.convertToUpper(newin, "UserTableCode",
				"exportName", "exportAdd1", "exportAdd2", "exportAdd3",
				"exportAdd4", "exportPostNo", "exportCountryCode",
				"consigneeCode");

	}

	private boolean userTableCodeDupCheck(UserTable newEntity) {

		ListResultBean<UserTable> selectList = userTableBhv.selectList(cb -> {
			cb.enableEmptyStringQuery(() -> {
				cb.query().setKey1_Equal(newEntity.getKey1());
				cb.query().setKey2_Equal(newEntity.getKey2());
			});
			cb.query().setTableName_Equal(newEntity.getTableName());
			cb.query().setDelFlag_Equal(0);
		});
		return (selectList.size() > 0);
	}

	private HashMap deleteProc(HashMap params, HttpServletRequest request,
			Session session, Login login) throws Exception {
		DBFluteUtil.setUserProcessToAccessContext(login.getLoginId(),
				"userTable:delete");
		BigDecimal bid = (BigDecimal) params.get("data");
		Integer id = bid.intValue();
		final OptionalEntity<UserTable> del = userTableBhv.selectByPK(id);
		if (!del.isPresent()) {
			throw new SystemException("id:" + id.toString() + "　が見つかりません");
		}
		UserTable delx = del.get();
		delx.setDelFlag(getDelFlagMaxValue(delx) + 1);
		userTableBhv.update(delx);
		return DBFluteUtil.setFetchResult(entityToMap(delx), params);
	}

	private int getDelFlagMaxValue(final UserTable del) {
		OptionalScalar<Integer> max = userTableBhv.selectScalar(Integer.class)
				.max(cb -> {
					cb.specify().columnDelFlag();
					cb.query().setTableName_Equal(del.getTableName());
					cb.query().setKey1_Equal(del.getKey1());
					cb.query().setKey2_Equal(del.getKey2());
				});
		if (max.isPresent()) {
			return max.get();
		}
		return 1;
	}

	private HashMap updateProc(HashMap params, HttpServletRequest request,
			Session session, Login login) throws Exception {
		DBFluteUtil.setUserProcessToAccessContext(login.getLoginId(),
				"userTable:update");
		@SuppressWarnings("unused")
		String screen = request.getParameter("screen");
		Map updateInput = preProc(params);
		UserTable upd = null;
		try {
			upd = BeanUtil.copyMapToNewBean(updateInput, UserTable.class);
		} catch (Exception e) {
			ServiceUtil.mapToNewBeanExceptionAnalyze(e);
		}
		OptionalEntity<UserTable> old = userTableBhv.selectByPK(upd.getId());
		if (!old.isPresent()) {
			throw new SystemException("id:" + upd.getId().toString()
					+ "　が見つかりません");
		}
		UserTable oldx = old.get();
		if (!(upd.getTableName().equals(oldx.getTableName())
				&& upd.getKey1().equals(oldx.getKey1()) && upd.getKey2()
				.equals(oldx.getKey2())) && userTableCodeDupCheck(upd)) {
			return DBFluteUtil.setErrorMessage("このDataは既に使用されています。", params);
		}
		userTableBhv.update(upd);
		Map map = null;
		map = entityToMap(upd);
		return DBFluteUtil.setFetchResult(map, params);
	}

	private HashMap fetchProc(HashMap params, HttpServletRequest request,
			Session session, Login login) throws Exception {
		DBFluteUtil.setUserProcessToAccessContext(login.getLoginId(),
				"userTable:fetch");
		String screen = request.getParameter("screen");
		ListResultBean<UserTable> res = userTableBhv.selectList(cb -> {
			cb.query().setDelFlag_Equal(0);
			cb.query().addOrderBy_TableName_Asc().addOrderBy_Key1_Asc()
					.addOrderBy_Key2_Asc();
			HashMap data = (HashMap) params.get("data");
			String maxRecord = (String) data.get("maxRecord");
			if (maxRecord != null) {
				cb.paging(Integer.parseInt(maxRecord), 1);
			} else {
				cb.paging(MAX_RECORD, 1);
			}
			setupQueryCriteria(cb, data);
		});
		ArrayList ar = resultToMap(res, screen);

		return DBFluteUtil.setFetchResult(ar, 0, 0, res.size(), params);
	}

	private ArrayList resultToMap(ListResultBean<UserTable> res, String screen) {
		ArrayList ar = new ArrayList();
		for (UserTable entity : res) {
			Map map = entityToMap(entity);
			ar.add(map);
		}
		return ar;
	}

	private Map entityToMap(UserTable newEntity) {
		Map map = BeanUtil.copyBeanToNewMap(
				newEntity,
				include("id", "tableName", "key1", "key2", "s1Data", "s2Data",
						"s3Data", "n1Data", "n2Data", "n3Data", "versionNo"));
		return map;
	}

	private void setupQueryCriteria(UserTableCB cb, HashMap data) {
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
