package com.mssoftech.web.util;

import java.math.BigDecimal;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.slf4j.Logger;

public class CommonUtil {
	static String LF = "\n";

	public static Map<Object, Object> loadProperties(String path) throws IOException {
		InputStream in = CommonUtil.class.getClassLoader().getResourceAsStream(path);
		if (in == null) {
			throw new IllegalArgumentException(path + " not found.");
		}
		Properties props = new Properties();
		props.load(in);
		return new HashMap<Object, Object>(props);
	}

	public static BigDecimal nullConvToZero(BigDecimal b) {
		if (b == null) {
			return new BigDecimal(new Long(0));
		}
		return b;
	}

	public static void putStacktraceToLog(Logger log, Exception e) {
		log.error(e.getMessage());
		StackTraceElement[] stackTrace = e.getStackTrace();
		for (StackTraceElement stackTraceElement : stackTrace) {
			log.error(stackTraceElement.toString());
		}
		Throwable cause = e.getCause();
		if (cause != null) {
			log.error(" ");
			log.error("Caused By");
			putStacktraceToLog(log, (Exception) cause);
		}
	}

	public static String putStacktraceToString(Exception e) {
		StringBuffer sb = new StringBuffer();
		StackTraceElement[] stackTrace = e.getStackTrace();
		for (StackTraceElement stackTraceElement : stackTrace) {
			sb.append(stackTraceElement.toString() + LF);
		}
		Throwable cause = e.getCause();
		if (cause != null) {
			sb.append("Caused By" + LF);
			sb.append(putStacktraceToString((Exception) cause));
		}
		return sb.toString();
	}

	public static String convertToString(Object data) {
		String start = null;
		Object ostart = data;
		if (ostart != null) {
			start = data.toString();
		}
		return start;
	}

}
