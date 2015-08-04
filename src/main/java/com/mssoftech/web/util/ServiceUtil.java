package com.mssoftech.web.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.arnx.jsonic.JSON;

import org.seasar.util.exception.IllegalPropertyRuntimeException;
import org.seasar.util.exception.ParseRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mssoftech.springreact.util.AppContextUtil;
import com.mssoftech.web.exception.SystemException;

public class ServiceUtil {
	static protected Logger log =LoggerFactory.getLogger(ServiceUtil.class);
	
	public static String invoke(String str, HttpServletRequest request,
			HttpServletResponse response, String smethod,
			Class<?> clazz, AppContextUtil appContextUtil) {
		try {
			Method[] methods = clazz.getMethods();
			Object target = appContextUtil.rootContext.getBean(clazz);
			Object res = null;
			Map<String, Object> params = createParams(str, clazz);
			for (Method method : methods) {
				if (method.getName().equals(smethod)) {
					res = method.invoke(target, params, request, response);
				}
			}
			target=null;
			return JSON.encode(res);
		} catch (InvocationTargetException e) {
			Throwable targetException = ((InvocationTargetException) e)
					.getTargetException();
			Throwable cause = null;
			String rtn = null;
			if (targetException.getClass() == InvocationTargetException.class) {
				cause = targetException.getCause();

				// ----- ここから　下まで同じ
				rtn=setRtnMessage(cause);
				if (rtn != null){
					return rtn;
				}
				// ---------------------------------
			} else {
				cause = e.getTargetException();
				// ----- ここから　下まで同じ
				rtn=setRtnMessage(cause);
				if (rtn != null){
					return rtn;
				}
				// ---------------------------------
			}
			putErrorLog(e);
			return JSON.encode(DBFluteUtil.setErrorMessage("System Error...\n" + e,
					null));

		} catch (Exception e) {
			putErrorLogOrg(e);
			return JSON.encode(DBFluteUtil.setErrorMessage("System Error",
					null));
		}
	}

	private static void putErrorLogOrg(Exception e) {
		String msg = e.getClass().getName();
		log.debug("System Error:" + msg);
		CommonUtil.putStacktraceToLog(log, e);
	}

	private static void putErrorLog(InvocationTargetException e) {
		Exception cause = (Exception) e.getCause();
		String msg = cause.getClass().getName();
		log.debug("System Error:" + msg);
		CommonUtil.putStacktraceToLog(log, (Exception) e.getCause());
	}

	private static String setRtnMessage(Throwable cause) {
		String rtn=null;
		if (cause.getClass() == SystemException.class) {
			rtn =   JSON.encode(DBFluteUtil.setErrorMessage(
					cause.getMessage(), null));
		}
		return rtn;
	}

	private static Map<String, Object> createParams(String str, Class<?> clazz) { // Class<LoginService>
		Map<String, Object> params = (Map<String, Object>) JSON.decode(str);
		params.put("startTimeStamp", CalenderUtil.getCurrentTime());
		params.put("class", clazz.getSimpleName());
		return params;
	}

	public static void mapToNewBeanExceptionAnalyze(Exception e) throws Exception {
		String propetyName = "";
		if (e.getClass().equals(IllegalPropertyRuntimeException.class)) {
			propetyName = ((IllegalPropertyRuntimeException) e)
					.getPropertyName();
		}
		if (e.getCause().getClass().equals(ParseRuntimeException.class)) {
			throw new SystemException(e.getMessage());
		}
		if (e.getCause().getClass().equals(NumberFormatException.class)) {
			throw new SystemException(propetyName + " 数値形式ではありません。");
		}
		throw e;		
	}

}
