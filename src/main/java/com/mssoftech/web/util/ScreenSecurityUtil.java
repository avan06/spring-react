package com.mssoftech.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dbflute.cbean.result.ListResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mssoftech.springreact.dbflute.exbhv.LoginBhv;
import com.mssoftech.springreact.dbflute.exbhv.SessionBhv;
import com.mssoftech.springreact.dbflute.exbhv.SysTableBhv;
import com.mssoftech.springreact.dbflute.exentity.Login;
import com.mssoftech.springreact.dbflute.exentity.Session;
import com.mssoftech.springreact.dbflute.exentity.SysTable;
import com.mssoftech.springreact.util.AppContextUtil;

public class ScreenSecurityUtil {
	static protected Logger log = LoggerFactory
			.getLogger(ScreenSecurityUtil.class);

	public static String generateAuthorizedScreen(HttpServletRequest request,
			HttpServletResponse response, String[] files, String[] libfiles,
			String title, AppContextUtil appContextUtil) {
		return generateAuthorizedScreen(request, response, files, libfiles,
				title, null, appContextUtil);
	}

	public static String generateAuthorizedScreen(HttpServletRequest request,
			HttpServletResponse response, String[] files, String[] libfiles,
			String title, String[] scripts, AppContextUtil appContextUtil) {
		String url[] = request.getRequestURL().toString().split("/");
		String screen = url[url.length - 1];
		Session session = LoginUtil.getSessionFromRequestCookie(request,
				appContextUtil.rootContext.getBean(SessionBhv.class));
		Login login = LoginUtil.getLoginFromSession(session,
				appContextUtil.rootContext.getBean(LoginBhv.class));
		if (session == null) {
			return JspUtil.returnError(request,"セッションが切れています。再度ログインして下さい。");
		}
		try {
			if (checkAuth(screen, session, login) == false) {
				return JspUtil.returnError(request,"この画面は権限がありません。");
			}
		} catch (Exception e) {
			CommonUtil.putStacktraceToLog(log, e);
			return e.getMessage();
		}

		JspUtil.setJspVariable(request, session, files, libfiles, title,
				scripts, appContextUtil.rootContext.getBean(LoginBhv.class));
		return "index";
	}

	private static boolean checkAuth(String screen, Session session, Login login)
			throws Exception {
		// SysTable table = getScreenData(screen, null, null);
		// String auth = table.getS1Data();
		return true;
		// String grp = StringUtil.nullConvToString(session.getGrp());
		// if (grp.length() != 1) {
		// return false;
		// }
		// if (auth.contains(StringUtil.nullConvToString(session.getGrp()))) {
		// return true;
		// }
		//
		// return false;
	}

	@SuppressWarnings("unused")
	private static SysTable getScreenData(String screen, Integer comp_id,
			String fy,SysTableBhv sysTableBhv) throws Exception {

		
		ListResultBean<SysTable> list = sysTableBhv.selectList(cb-> {
			//cb.ignoreNullOrEmptyQuery();
			cb.enableEmptyStringQuery(()->{
				cb.query().setKey2_Equal("");
			});
			cb.query().setDelFlag_Equal(0);
			cb.query().setTableName_Equal("screenAuth");
			cb.query().setKey1_Equal(screen);
			cb.query().addOrderBy_Key1_Asc().addOrderBy_Key2_Asc();
		});
		if (list.size() == 0) {
			throw new Exception("システムエラー  画面権限データ" + screen + " が登録されていません。");
		}

		return list.get(0);
	}
}
