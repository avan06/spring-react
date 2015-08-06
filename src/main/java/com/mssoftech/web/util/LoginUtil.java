package com.mssoftech.web.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import com.mssoftech.springreact.domain.Login;
import com.mssoftech.springreact.domain.Session;

@Component
public class LoginUtil {
	@PersistenceContext
	private EntityManager em;

	public Session getSession(String uuid) {
		if (uuid == null) {
			return null;
		}
		List<Session> sessionList =  em.createQuery("From Session where uuid = :uuid and delFlag = :delFlag", Session.class)
			.setParameter("uuid", uuid)
			.setParameter("delFlag", 0).getResultList();

		if (sessionList.size() == 1) {
			return sessionList.get(0);
		}
		return null;
	}

	public Session getSessionFromRequestCookie(
			HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String uuid = null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("uuid")) {
				uuid = cookie.getValue();
			}
		}
		;
		return getSession(uuid);
	}

	public HashMap<String, HashMap<String, Object>> checkLogin(Session session, Map<String, Object> params) {
		HashMap<String, HashMap<String, Object>> res = null;
		if (session == null) {
			res = DBFluteUtil.setErrorMessage("ログインは有効ではありません", params);
		}
		return res;
	}

	public Login getLoginFromSession(Session session) {
		if (session == null) {
			return null;
		}

		List<Login> loginList =  em.createQuery("From Login where id = :id", Login.class)
				.setParameter("id", session.getLogin().getId()).getResultList();

		if (loginList.size()==0){
			return null;
		}
		return loginList.get(0);
	}

	public String[] getLoginInformation(Session session) {
		Login login = this.getLoginFromSession(session);
		
		String[] loginInfoScript = new String[] {
				"if (!(window[\"base\"] != null)) {window[\"base\"] = {};}\n",
				"base.login = {};\n",
				"base.login.uid = " + login.getId().toString() + ";\n",
				"base.login.name = '" + login.getName() + "';\n" };
		return loginInfoScript;
	}

	public String createMd5(String data) {
		return DigestUtils.md5Hex(data);
	}
}
