package com.mssoftech.web.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

public class HerokuUtil {
	static protected Logger log = Logger.getLogger(HerokuUtil.class);
	
	static public String httpCheckAndHttpsRedirect(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String scheme = request.getHeader("x-forwarded-proto");
		String newurl = "https://" + request.getServerName()
				+ request.getContextPath();
		if (scheme != null && (!scheme.equals("https"))
				&& (!request.getServerName().equals("localhost"))) {
			log.debug("Redirect to:" + newurl);
			//response.sendRedirect(newurl);
			return newurl;
		}
		return "";
	}
	
	static public String getRedirectUrl(HttpServletRequest request, String address) {
		String newurl;
		if (request.getServerName().equals("localhost")) {
			newurl = "http://" + request.getServerName() + ":"
					+ (new Integer(request.getLocalPort())).toString() + "/"
					+ address;
		} else {
			newurl = "https://" + request.getServerName() + "/" + address;
		}
		return newurl;
	}
}

