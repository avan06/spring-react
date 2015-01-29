package com.mssoftech.web.util;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.codec.digest.DigestUtils;
import org.dbflute.cbean.result.ListResultBean;
import com.mssoftech.springreact.dbflute.exbhv.LoginBhv;
import com.mssoftech.springreact.dbflute.exbhv.SessionBhv;
import com.mssoftech.springreact.dbflute.exentity.Login;
import com.mssoftech.springreact.dbflute.exentity.Session;

public class LoginUtil {

	public static Session getSession(String uuid, SessionBhv sessionBhv) {
		if (uuid == null) {
			return null;
		}
		ListResultBean<Session> list = sessionBhv.selectList(cb -> {
			cb.ignoreNullOrEmptyQuery();
			cb.query().setUuid_Equal(uuid);
			cb.query().setDelFlag_Equal(0);
		});
		if (list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	public static Session getSessionFromRequestCookie(
			HttpServletRequest request, SessionBhv sessionBhv) {
		Cookie[] cookies = request.getCookies();
		String uuid = null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("uuid")) {
				uuid = cookie.getValue();
			}
		}
		;
		return getSession(uuid, sessionBhv);
	}

	public static HashMap checkLogin(Session session, Map params) {
		HashMap res = null;
		if (session == null) {
			res = DBFluteUtil.setErrorMessage("ログインは有効ではありません", params);
		}
		return res;
	}

	public static Login getLoginFromSession(Session session,
			LoginBhv loginBhv) {
		if (session == null) {
			return null;
		}

		ListResultBean<Login> list = loginBhv.selectList(cb -> {
			cb.query().setId_Equal(session.getLoginId());
		});
		if (list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public static String[] getLoginInformation(Session session,LoginBhv loginBhv) {
		Login login = LoginUtil.getLoginFromSession(session,loginBhv);
		
		String[] loginInfoScript = new String[] {
				"if (!(window[\"$c\"] != null)) {window[\"$c\"] = {};}\n",
				"$c.login = {};\n",
				"$c.login.uid = " + login.getId().toString() + ";\n",
				"$c.login.name = '" + login.getName() + "';\n" };
		return loginInfoScript;
	}

	public static String createMd5(String data) {
		return DigestUtils.md5Hex(data);
	}
}
