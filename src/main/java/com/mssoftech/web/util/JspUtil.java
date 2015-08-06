package com.mssoftech.web.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mssoftech.springreact.domain.Session;

@Component
public class JspUtil {
	@Autowired
	private LoginUtil loginUtil;

	public void setJspVariable(HttpServletRequest request, Session session, String[] jsnames,
			String[] jslibnames, String title, String[] addLoginScripts) {
		String[] loginInfoScripts = loginUtil.getLoginInformation(session);
		ArrayList<String> scripts = new ArrayList<String>(Arrays.asList(loginInfoScripts));
		if (addLoginScripts != null) {
			for (int i = 0; i < addLoginScripts.length; i++) {
				scripts.add(addLoginScripts[i]);
			}
		}
		String[] jss = prepareJsnames(jsnames);
		String[] jslibs = prepareJsLibnames(jslibnames);
		HashMap<String, Object> jsCss = getJsCss(request.getContextPath(), jss, jslibs,
				new String[] { "/css/bootstrap.css", "/css/main.css" }, title, scripts.toArray(new String[] {}));
		request.setAttribute("__jscss", jsCss);
	}

	private String[] prepareJsnames(String[] jsnames) {
		ArrayList<String> ar = new ArrayList<String>();
		// ar.add("/js/sc-common.js");
		// ar.add("/js/dateformat.js");
		for (int i = 0; i < jsnames.length; i++) {
			ar.add(jsnames[i]);
		}
		return ar.toArray(new String[] {});
	}

	private String[] prepareJsLibnames(String[] jslibnames) {
		ArrayList<String> ar = new ArrayList<String>();
		for (int i = 0; i < jslibnames.length; i++) {
			ar.add(jslibnames[i]);
		}
		return ar.toArray(new String[] {});
	}

	public HashMap<String, Object> getJsCss(String contextPath, String[] js, String[] jslib, String[] css,
			String title, String[] jscmd) {
		HashMap<String, Object> jsCss = new HashMap<String, Object>();
		jsCss.put("js", new ArrayList<String>());
		jsCss.put("jslib", new ArrayList<String>());
		jsCss.put("css", new ArrayList<String>());
		jsCss.put("jscmd", new ArrayList<String>());
		jsCss.put("jscmdh", "base_contextpath=\"" + contextPath + "\";");
		jsCss.put("title", title);
		DBFluteUtil.putStrings(jsCss, "jscmd", jscmd);
		DBFluteUtil.putStrings(jsCss, "js", contextPath, js);
		DBFluteUtil.putStrings(jsCss, "jslib", contextPath, jslib);
		DBFluteUtil.putStrings(jsCss, "css", contextPath, css);
		return jsCss;
	}

	public String returnError(HttpServletRequest request, String errmsg) {
		request.setAttribute("__errmsg", errmsg);
		return "error";
	}
}
