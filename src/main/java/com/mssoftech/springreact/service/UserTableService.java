package com.mssoftech.springreact.service;

import static org.seasar.util.beans.util.CopyOptionsUtil.include;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
import com.mssoftech.springreact.domain.UserTable;
import com.mssoftech.web.exception.SystemException;
import com.mssoftech.web.util.DBFluteUtil;
import com.mssoftech.web.util.DatabaseConvertUtil;
import com.mssoftech.web.util.LoginUtil;
import com.mssoftech.web.util.ServiceUtil;

@Component
@Transactional
public class UserTableService {
	static protected Logger log = LoggerFactory.getLogger(UserTableService.class);

	@PersistenceContext
	private EntityManager em;
	@Autowired
	private LoginUtil loginUtil;

	private int MAX_RECORD = 1000;

	public HashMap<String, HashMap<String, Object>> execute(HashMap<String, Object> params, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Session session = loginUtil.getSessionFromRequestCookie(request);
		if (session == null) {
			return DBFluteUtil.setErrorMessage("セッションがありません。再度ログインして下さい。", params);
		}
		Login login = loginUtil.getLoginFromSession(session);
		HashMap<String, HashMap<String, Object>> res = loginUtil.checkLogin(session, params);
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

	private HashMap<String, HashMap<String, Object>> insertProc(HashMap<String, Object> params,
			HttpServletRequest request, Session session, Login login) throws Exception {
		@SuppressWarnings("unused")
		String screen = request.getParameter("screen");
		Map<String, Object> newin = preProc(params);
		UserTable newEntity = null;
		try {
			newEntity = BeanUtil.copyMapToNewBean(newin, UserTable.class);
		} catch (Exception e) {
			ServiceUtil.mapToNewBeanExceptionAnalyze(e);
		}
		if (userTableCodeDupCheck(newEntity)) {
			return DBFluteUtil.setErrorMessage("このDataは既に使用されています。", params);
		}

		HashMap<String, HashMap<String, Object>> res;
		em.persist(newEntity);
		Map<String, Object> map = null;
		map = entityToMap(newEntity);
		res = DBFluteUtil.setFetchResult(map, params);
		return res;
	}

	private Map<String, Object> preProc(HashMap<String, Object> params) {
		Map<String, Object> newin = (Map<String, Object>) params.get("data");
		convertToUpper(newin);
		DatabaseConvertUtil.convertToStringWhenNull(newin, "key1", "key2", "fy");
		return newin;
	}

	private void convertToUpper(Map<String, Object> newin) {
		DatabaseConvertUtil.convertToUpper(newin, "UserTableCode", "exportName", "exportAdd1", "exportAdd2",
				"exportAdd3", "exportAdd4", "exportPostNo", "exportCountryCode", "consigneeCode");

	}

	private boolean userTableCodeDupCheck(UserTable newEntity) {

		List<UserTable> sysTableList = em
				.createQuery("From UserTable where key1 = :key1 and key2 = :key2 and tableName = :tableName and delFlag = :delFlag", UserTable.class)
				.setParameter("key1", newEntity.getKey1()) //enableEmptyStringQuery FIXME
				.setParameter("key2", newEntity.getKey2()) //enableEmptyStringQuery
				.setParameter("tableName", newEntity.getTableName())
				.setParameter("delFlag", 0)
				.getResultList();

		return (sysTableList.size() > 0);
	}

	private HashMap<String, HashMap<String, Object>> deleteProc(HashMap<String, Object> params,
			HttpServletRequest request, Session session, Login login) throws Exception {
		BigDecimal bid = (BigDecimal) params.get("data");
		Integer id = bid.intValue();
		UserTable delUserTable = em.find(UserTable.class, id);
		if (delUserTable == null) {
			throw new SystemException("id:" + id.toString() + "　が見つかりません");
		}
		delUserTable.setDelFlag(getDelFlagMaxValue(delUserTable) + 1);
		em.merge(delUserTable);
		return DBFluteUtil.setFetchResult(entityToMap(delUserTable), params);
	}

	private int getDelFlagMaxValue(final UserTable del) {
		Integer delFlagMax = em.createQuery("select max(delFlag) From UserTable where tableName = :tableName and key1 = :key1 and key2 = :key2", Integer.class)
				.setParameter("tableName", del.getTableName())
				.setParameter("key1", del.getKey1())
				.setParameter("key2", del.getKey2())
				.getSingleResult();

		if (delFlagMax != null) {
			return delFlagMax;
		}
		return 1;
	}

	private HashMap<String, HashMap<String, Object>> updateProc(HashMap<String, Object> params,
			HttpServletRequest request, Session session, Login login) throws Exception {
		@SuppressWarnings("unused")
		String screen = request.getParameter("screen");
		Map<String, Object> updateInput = preProc(params);
		UserTable upd = null;
		try {
			upd = BeanUtil.copyMapToNewBean(updateInput, UserTable.class);
		} catch (Exception e) {
			ServiceUtil.mapToNewBeanExceptionAnalyze(e);
		}
		UserTable dbUserTable = em.find(UserTable.class, upd.getId());
		if (dbUserTable == null) {
			throw new SystemException("id:" + upd.getId().toString() + "　が見つかりません");
		}
		if (!(upd.getTableName().equals(dbUserTable.getTableName()) && upd.getKey1().equals(dbUserTable.getKey1())
				&& upd.getKey2().equals(dbUserTable.getKey2())) && userTableCodeDupCheck(upd)) {
			return DBFluteUtil.setErrorMessage("このDataは既に使用されています。", params);
		}
		BeanUtil.copyBeanToBean(upd, dbUserTable, CopyOptionsUtil.excludeNull());
		em.merge(dbUserTable);
		Map<String, Object> map = null;
		map = entityToMap(upd);
		return DBFluteUtil.setFetchResult(map, params);
	}

	private HashMap<String, HashMap<String, Object>> fetchProc(HashMap<String, Object> params,
			HttpServletRequest request, Session session, Login login) throws Exception {
		String screen = request.getParameter("screen");
		
		List<UserTable> userTableList = em
				.createQuery("From UserTable where delFlag = :delFlag ORDER BY tableName, key1, key2", UserTable.class)
				.setParameter("delFlag", 0)
				.getResultList();
//		ListResultBean<UserTable> res = userTableBhv.selectList(cb -> {
//			cb.query().setDelFlag_Equal(0);
//			cb.query().addOrderBy_TableName_Asc().addOrderBy_Key1_Asc().addOrderBy_Key2_Asc();
//			HashMap<String, Object> data = (HashMap<String, Object>) params.get("data");
//			String maxRecord = (String) data.get("maxRecord");
//			if (maxRecord != null) {
//				cb.paging(Integer.parseInt(maxRecord), 1);
//			} else {
//				cb.paging(MAX_RECORD, 1);
//			}
//			setupQueryCriteria(cb, data); FIXME
//		});
		ArrayList<Map<String, Object>> ar = resultToMap(userTableList, screen);

		return DBFluteUtil.setFetchResult(ar, 0, 0, userTableList.size(), params);
	}

	private ArrayList<Map<String, Object>> resultToMap(List<UserTable> res, String screen) {
		ArrayList<Map<String, Object>> ar = new ArrayList<Map<String, Object>>();
		for (UserTable entity : res) {
			Map<String, Object> map = entityToMap(entity);
			ar.add(map);
		}
		return ar;
	}

	private Map<String, Object> entityToMap(UserTable newEntity) {
		Map<String, Object> map = BeanUtil.copyBeanToNewMap(newEntity, include("id", "tableName", "key1", "key2",
				"s1Data", "s2Data", "s3Data", "n1Data", "n2Data", "n3Data", "versionNo"));
		return map;
	}

//FIXME
//	private void setupQueryCriteria(UserTableCB cb, HashMap<String, Object> data) {
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
