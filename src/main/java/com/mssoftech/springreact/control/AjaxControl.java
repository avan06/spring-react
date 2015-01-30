package com.mssoftech.springreact.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mssoftech.springreact.service.LoginService;
import com.mssoftech.springreact.service.SysTableService;
import com.mssoftech.springreact.service.UserTableService;
import com.mssoftech.springreact.util.AppContextUtil;
import com.mssoftech.web.util.ServiceUtil;

@RestController
@RequestMapping("/ajax")
public class AjaxControl {

	private AppContextUtil appContextUtil;

	public AppContextUtil getAppContextUtil() {
		return appContextUtil;
	}

	@Autowired
	public void setAppContextUtil(AppContextUtil appContextUtil) {
		this.appContextUtil = appContextUtil;
	}
	@RequestMapping(value = "/health", method = RequestMethod.GET)
	String health() {

		return "OK";
	}

	@RequestMapping(value = "/loginauth", method = RequestMethod.POST)
	String loginauth(HttpServletRequest request, HttpServletResponse response,
			@RequestBody String str) {

		return ServiceUtil.invoke(str, request, response, "loginAuth",
				LoginService.class, appContextUtil);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(HttpServletRequest request,
			HttpServletResponse response) {
		String str = "{\"dummy\":\"\"}";
		return ServiceUtil.invoke(str, request, response, "logout",
				LoginService.class, appContextUtil);

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request,
			HttpServletResponse response, @RequestBody String str) {
		return ServiceUtil.invoke(str, request, response, "execute",
				LoginService.class, appContextUtil);

	}
	
	@RequestMapping(value = "/usertbl", method = RequestMethod.POST)
	public String usertbl(HttpServletRequest request,
			HttpServletResponse response, @RequestBody String str) {
		return ServiceUtil.invoke(str, request, response, "execute",
				UserTableService.class, appContextUtil);

	}
	
	@RequestMapping(value = "/systbl", method = RequestMethod.POST)
	public String systbl(HttpServletRequest request,
			HttpServletResponse response, @RequestBody String str) {
		return ServiceUtil.invoke(str, request, response, "execute",
				SysTableService.class, appContextUtil);

	}
}
