package com.mssoftech.web.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.mssoftech.springreact.dbflute.exbhv.LoginBhv;
import com.mssoftech.springreact.dbflute.exentity.Session;

public class JspUtil {

	static public void setJspVariable(HttpServletRequest request,
			Session session, String[] jsnames, String[] jslibnames,String title,
			String[] addLoginScripts,LoginBhv loginBhv) {
		String[] loginInfoScripts = LoginUtil.getLoginInformation(session,loginBhv);
		ArrayList<String> scripts = new ArrayList(
				Arrays.asList(loginInfoScripts));
		if (addLoginScripts != null) {
			for (int i = 0; i < addLoginScripts.length; i++) {
				scripts.add(addLoginScripts[i]);
			}
		}
		String[] jss = prepareJsnames(jsnames);
		String[] jslibs = prepareJsLibnames(jslibnames);
		HashMap jsCss = getJsCss(request.getContextPath(), jss,jslibs,
				new String[] { "/css/bootstrap.css","/css/main.css" }, title,
				scripts.toArray(new String[] {}));
		request.setAttribute("__jscss", jsCss);
	}

	static private String[] prepareJsnames(String[] jsnames) {
		ArrayList<String> ar = new ArrayList<String>();
//		ar.add("/js/sc-common.js");
//		ar.add("/js/dateformat.js");
		for (int i = 0; i < jsnames.length; i++) {
			ar.add(jsnames[i]);
		}
		return ar.toArray(new String[] {});
	}
	static private String[] prepareJsLibnames(String[] jslibnames) {
		ArrayList<String> ar = new ArrayList<String>();
		for (int i = 0; i < jslibnames.length; i++) {
			ar.add(jslibnames[i]);
		}
		return ar.toArray(new String[] {});
	}
	public static HashMap getJsCss(String contextPath, String[] js,String[] jslib,
			String[] css, String title, String[] jscmd) {
		HashMap jsCss = new HashMap();
		jsCss.put("js", new ArrayList());
		jsCss.put("jslib", new ArrayList());
		jsCss.put("css", new ArrayList());
		jsCss.put("jscmd", new ArrayList());
		jsCss.put("jscmdh", "$c_contextpath=\"" + contextPath + "\";");
		jsCss.put("title", title);
		DBFluteUtil.putStrings(jsCss, "jscmd", jscmd);
		DBFluteUtil.putStrings(jsCss, "js", contextPath, js);
		DBFluteUtil.putStrings(jsCss, "jslib", contextPath, jslib);
		DBFluteUtil.putStrings(jsCss, "css", contextPath, css);
		return jsCss;
	}

	public static String returnError(HttpServletRequest request,String errmsg) {
		request.setAttribute("__errmsg", errmsg);
		return "error";
	}
}
