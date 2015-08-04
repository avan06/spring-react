package com.mssoftech.springreact.control;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mssoftech.springreact.util.AppContextUtil;
import com.mssoftech.web.util.CommonUtil;
import com.mssoftech.web.util.DBFluteUtil;
import com.mssoftech.web.util.HerokuUtil;
import com.mssoftech.web.util.JspUtil;
import com.mssoftech.web.util.ScreenSecurityUtil;

@Controller
@RequestMapping("/")
public class IndexControl {
	final static Logger logger = LoggerFactory.getLogger(IndexControl.class);

	private AppContextUtil appContextUtil;
	@Autowired
	private JspUtil jspUtil;
	@Autowired
	private ScreenSecurityUtil screenSecurityUtil;

	public AppContextUtil getAppContextUtil() {
		return appContextUtil;
	}

	@Autowired
	public void setAppContextUtil(AppContextUtil appContextUtil) {
		this.appContextUtil = appContextUtil;
	}

	@RequestMapping("/")
	String index(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			String redirect = HerokuUtil.httpCheckAndHttpsRedirect(request,
					response);
			if (!redirect.equals("")) {
				return "redirect:" + redirect;
			}
			HashMap<String, Object> jsCss = jspUtil.getJsCss(request.getContextPath(),
					new String[] { "/js/$c.js", "/js/$v.js", "/js/index.js",
							"/js/_cjsx.js", "/js/indexjsx.js" }, 
					new String[] {"/js/lib/fluxxor.js", "/js/lib/react.js",
							"/js/lib/react-bootstrap.js",
							"/js/lib/jquery-1.11.1.js", "/js/lib/lodash.js" },
					new String[] { "/css/bootstrap.css", "/css/main.css" },
					"メニュー", new String[] {});
			request.setAttribute("__jscss", jsCss);
			return "index";
		} catch (Exception e) {
			CommonUtil.putStacktraceToLog(logger, e);
			return "redirect:" + DBFluteUtil.getSystemErrorJspPath();
		}
	}

	@RequestMapping("/user")
	String user(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String[] files = new String[] { "/js/$c.js", "/js/$v.js",
				"/js/user.js", "/js/_cjsx.js", "/js/userjsx.js" };
		String[] libfiles = new String[] { "/js/lib/fluxxor.js",
				"/js/lib/react.js", "/js/lib/react-bootstrap.js",
				"/js/lib/jquery-1.11.1.js", "/js/lib/lodash.js" };
		String title = "USER管理";
		return screenSecurityUtil.generateAuthorizedScreen(request, response,
				files, libfiles, title,appContextUtil);
	}

	@RequestMapping("/userin")
	String userin(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String[] files = new String[] { "/js/$c.js", "/js/$v.js",
				"/js/userin.js", "/js/_cjsx.js", "/js/userinjsx.js" };
		String[] libfiles = new String[] { "/js/lib/fluxxor.js",
				"/js/lib/react.js", "/js/lib/react-bootstrap.js",
				"/js/lib/jquery-1.11.1.js", "/js/lib/lodash.js" };
		String title = "USER INLINE";
		return screenSecurityUtil.generateAuthorizedScreen(request, response,
				files, libfiles, title,appContextUtil);
	}
	

	@RequestMapping("/usertab")
	String usertab(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String[] files = new String[] { "/js/$c.js", "/js/$v.js",
				"/js/usertab.js", "/js/_cjsx.js", "/js/usertabjsx.js" };
		String[] libfiles = new String[] { "/js/lib/fluxxor.js",
				"/js/lib/react.js", "/js/lib/react-bootstrap.js",
				"/js/lib/jquery-1.11.1.js", "/js/lib/lodash.js" };
		String title = "USER TAB";
		return screenSecurityUtil.generateAuthorizedScreen(request, response,
				files, libfiles, title,appContextUtil);
	}
	@RequestMapping("/usertbl")
	String usertbl(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String[] files = new String[] { "/js/$c.js", "/js/$v.js",
				"/js/usertbl.js", "/js/_cjsx.js", "/js/usertbljsx.js" };
		String[] libfiles = new String[] { "/js/lib/fluxxor.js",
				"/js/lib/react.js", "/js/lib/react-bootstrap.js",
				"/js/lib/jquery-1.11.1.js", "/js/lib/lodash.js" };
		String title = "USER TAB";
		return screenSecurityUtil.generateAuthorizedScreen(request, response,
				files, libfiles, title,appContextUtil);
	}
	@RequestMapping("/systbl")
	String systbl(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String[] files = new String[] { "/js/$c.js", "/js/$v.js",
				"/js/systbl.js", "/js/_cjsx.js", "/js/systbljsx.js" };
		String[] libfiles = new String[] { "/js/lib/fluxxor.js",
				"/js/lib/react.js", "/js/lib/react-bootstrap.js",
				"/js/lib/jquery-1.11.1.js", "/js/lib/lodash.js" };
		String title = "USER TAB";
		return screenSecurityUtil.generateAuthorizedScreen(request, response,
				files, libfiles, title,appContextUtil);
	}
}
