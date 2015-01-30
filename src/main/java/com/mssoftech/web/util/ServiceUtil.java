package com.mssoftech.web.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.arnx.jsonic.JSON;

import org.dbflute.exception.EntityAlreadyExistsException;
import org.dbflute.exception.EntityAlreadyUpdatedException;
import org.dbflute.exception.SQLFailureException;
import org.seasar.util.exception.IllegalPropertyRuntimeException;
import org.seasar.util.exception.ParseRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mssoftech.springreact.service.LoginService;
import com.mssoftech.springreact.util.AppContextUtil;
import com.mssoftech.web.exception.SystemException;

public class ServiceUtil {
	static protected Logger log =LoggerFactory.getLogger(ServiceUtil.class);
	
	public static String invoke(String str, HttpServletRequest request,
			HttpServletResponse response, String smethod,
			Class clazz, AppContextUtil appContextUtil) {
		try {
			Method[] methods = clazz.getMethods();
			Object target = appContextUtil.rootContext.getBean(clazz);
			Object res = null;
			Map params = createParams(str, clazz);
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
			return JSON.encode(DBFluteUtil.setErrorMessage("System Error",
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
		if (cause.getClass() == SQLFailureException.class) {
			String message = getMessage(cause);
			rtn =  JSON.encode(DBFluteUtil.setErrorMessage(
					"SQL ERROR\n" + message, null));
		}

		else if (cause.getClass() == EntityAlreadyUpdatedException.class) {
			rtn =   JSON.encode(DBFluteUtil.setErrorMessage(
					"既にDataが更新されています。再度読み込んでから実行して下さい。", null));
		}
		else if (cause.getClass() == EntityAlreadyExistsException.class) {
			rtn =   JSON.encode(DBFluteUtil.setErrorMessage(
					"キー項目の重複です。既に登録されています。", null));
		}
		else if (cause.getClass() == SystemException.class) {
			rtn =   JSON.encode(DBFluteUtil.setErrorMessage(
					cause.getMessage(), null));
		}
		return rtn;
	}

	private static String getMessage(Throwable cause) {
		log.warn(cause.toString());
		String message = "";

		Throwable cause2 = cause.getCause();
		Throwable cause3 = null;
		if (cause2 != null) {
			message = cause2.getMessage();
			cause3 = cause2.getCause();
		}
		if (cause3 != null) {
			message=cause3.getMessage();
		}
		return message;
	}

	private static Map createParams(String str, Class<LoginService> clazz) {
		Map params = (Map) JSON.decode(str);
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
