package com.mssoftech.springreact.control;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mssoftech.web.util.CommonUtil;
import com.mssoftech.web.util.DBFluteUtil;
import com.mssoftech.web.util.HerokuUtil;
import com.mssoftech.web.util.JspUtil;
import com.mssoftech.web.util.ScreenSecurityUtil;

@Controller
@RequestMapping("/")
public class IndexControl {
	final static Logger logger = LoggerFactory.getLogger(IndexControl.class);

	@Autowired
	private JspUtil jspUtil;
	@Autowired
	private ScreenSecurityUtil screenSecurityUtil;
	
	private String[] libfiles = new String[] { "/js/lib/fluxxor.js", "/js/lib/react.js", "/js/lib/react-bootstrap.js", "/js/lib/jquery-1.11.1.js", "/js/lib/lodash.js" };

	@RequestMapping("/")
	String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String redirect = HerokuUtil.httpCheckAndHttpsRedirect(request, response);
			if (!redirect.equals("")) {
				return "redirect:" + redirect;
			}
			HashMap<String, Object> jsCss = jspUtil.getJsCss(request.getContextPath(),
					new String[] { "/js/rsv.js", "/js/base.js", "/js/baseJsx.js", "/js/index.js", "/js/indexJsx.js" },
					libfiles,
					new String[] { "/css/bootstrap.css", "/css/main.css" }, "メニュー", new String[] {});
			request.setAttribute("__jscss", jsCss);
			return "index";
		} catch (Exception e) {
			CommonUtil.putStacktraceToLog(logger, e);
			return "redirect:" + DBFluteUtil.getSystemErrorJspPath();
		}
	}

	@RequestMapping("/user")
	String user(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] files = new String[] { "/js/rsv.js", "/js/base.js", "/js/baseJsx.js", "/js/user.js", "/js/userJsx.js" };
		String title = "USER管理";
		return screenSecurityUtil.generateAuthorizedScreen(request, response, files, libfiles, title);
	}

	@RequestMapping("/userin")
	String userin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] files = new String[] { "/js/rsv.js", "/js/base.js", "/js/baseJsx.js", "/js/userin.js", "/js/userinJsx.js" };
		String title = "USER INLINE";
		return screenSecurityUtil.generateAuthorizedScreen(request, response, files, libfiles, title);
	}

	@RequestMapping("/usertab")
	String usertab(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] files = new String[] { "/js/rsv.js", "/js/base.js", "/js/baseJsx.js", "/js/usertab.js", "/js/usertabJsx.js" };
		String title = "USER TAB";
		return screenSecurityUtil.generateAuthorizedScreen(request, response, files, libfiles, title);
	}

	@RequestMapping("/usertbl")
	String usertbl(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] files = new String[] { "/js/rsv.js", "/js/base.js", "/js/baseJsx.js", "/js/usertbl.js", "/js/usertblJsx.js" };
		String title = "USER TAB";
		return screenSecurityUtil.generateAuthorizedScreen(request, response, files, libfiles, title);
	}

	@RequestMapping("/systbl")
	String systbl(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] files = new String[] { "/js/rsv.js", "/js/base.js", "/js/baseJsx.js", "/js/systbl.js", "/js/systblJsx.js" };
		String title = "USER TAB";
		return screenSecurityUtil.generateAuthorizedScreen(request, response, files, libfiles, title);
	}
}
