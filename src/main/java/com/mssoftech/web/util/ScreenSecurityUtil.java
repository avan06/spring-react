package com.mssoftech.web.util;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mssoftech.springreact.domain.Login;
import com.mssoftech.springreact.domain.Session;
import com.mssoftech.springreact.domain.SysTable;
import com.mssoftech.springreact.util.AppContextUtil;

@Component
@Transactional
public class ScreenSecurityUtil {
	@PersistenceContext
	private EntityManager em;
	@Autowired
	private LoginUtil loginUtil;
	@Autowired
	private JspUtil jspUtil;

	protected Logger log = LoggerFactory.getLogger(ScreenSecurityUtil.class);

	public String generateAuthorizedScreen(HttpServletRequest request, HttpServletResponse response,
			String[] files, String[] libfiles, String title, AppContextUtil appContextUtil) {
		return generateAuthorizedScreen(request, response, files, libfiles, title, null, appContextUtil);
	}

	public String generateAuthorizedScreen(HttpServletRequest request, HttpServletResponse response,
			String[] files, String[] libfiles, String title, String[] scripts, AppContextUtil appContextUtil) {
		String url[] = request.getRequestURL().toString().split("/");
		String screen = url[url.length - 1];
		Session session = loginUtil.getSessionFromRequestCookie(request);
		Login login = loginUtil.getLoginFromSession(session);
		if (session == null) {
			return jspUtil.returnError(request, "セッションが切れています。再度ログインして下さい。");
		}
		try {
			if (checkAuth(screen, session, login) == false) {
				return jspUtil.returnError(request, "この画面は権限がありません。");
			}
		} catch (Exception e) {
			CommonUtil.putStacktraceToLog(log, e);
			return e.getMessage();
		}

		jspUtil.setJspVariable(request, session, files, libfiles, title, scripts);
		return "index";
	}

	private boolean checkAuth(String screen, Session session, Login login) throws Exception {
		SysTable table = getScreenData(screen, null, null);
		String auth = table.getS1Data();
		String grp = StringUtil.nullConvToString(session.getRole());
		if (grp.length() != 1) {
			return false;
		}
		if (auth.contains(StringUtil.nullConvToString(session.getRole()))) {
			return true;
		}

		return false;
	}

	@Transactional //FIXME
	private SysTable getScreenData(String screen, Integer comp_id, String fy) throws Exception {
		List<SysTable> sysTableList = em
				.createQuery("From SysTable "
						+ "where delFlag = :delFlag and tableName = :tableName and key1 = :key1 and key2 = :key2 "
						+ "ORDER BY key1, key2", SysTable.class)
				.setParameter("delFlag", 0)
				.setParameter("tableName", "screenAuth")
				.setParameter("key1", screen)
				.setParameter("key2", "").getResultList();

		if (sysTableList.size() == 0) {
			//throw new Exception("システムエラー  画面権限データ" + screen + " が登録されていません。");
			Date d = new Date();

			SysTable sysTable = new SysTable();
			sysTable.setTableName("screenAuth");
			sysTable.setKey1(screen);
			sysTable.setKey2("");
			
			sysTable.setS1Data("1");

			sysTable.setVersionNo(1);
			sysTable.setDelFlag(0);

			sysTable.setRegisterDatetime(d);
			sysTable.setRegisterUser("SYSTEM");
			sysTable.setRegisterProcess(this.getClass().getSimpleName());
			sysTable.setUpdateDatetime(d);
			sysTable.setUpdateUser("SYSTEM");
			sysTable.setUpdateProcess(this.getClass().getSimpleName());

			em.persist(sysTable);
			return getScreenData(screen, comp_id, fy);
		}

		return sysTableList.get(0);
	}
}
