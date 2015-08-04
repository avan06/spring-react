package com.mssoftech.web.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBFluteUtil {
	static protected Logger log = LoggerFactory.getLogger(DBFluteUtil.class);
	static HashMap<String, String> _comnColMap = null;
	static HashMap<String, String> _omap = null;
	static HashMap<String, String> _omap2 = null;
	static Boolean localenv = null;
	static String LF = "\n";

	public static synchronized HashMap<String, String> getOpMap() {
		if (_omap == null) {

			_omap = new HashMap<String, String>();
			_omap.put("=", "Equal");
			_omap.put("<>", "NotEqual");
			_omap.put(">", "GreaterThan");
			_omap.put("<", "LessThan");
			_omap.put(">=", "GreaterEqual");
			_omap.put("<=", "LessEqual");
			_omap.put("contains", "LikeSearch");
			_omap.put("starts with", "LikeSearch");
			_omap.put("ends with", "LikeSearch");
			_omap.put("like", "LikeSearch");
			_omap.put("between", "GreaterEqual");
			_omap.put("exclude", "LessThan");
		}
		return _omap;
	}

	public static synchronized HashMap<String, String> getOpMap2() {
		if (_omap2 == null) {

			_omap2 = new HashMap<String, String>();
			_omap2.put("between", "LessEqual");
			_omap2.put("exclude", "GreaterThan");
		}
		return _omap2;
	}

	public static HashMap<String, Object> getJsCss(String contextPath, String[] js, String[] css, String title,
			String[] jscmd) {
		HashMap<String, Object> jsCss = new HashMap<String, Object>();

		String[] jsSmart = { "/js/sc/system/modules/ISC_Core.js", "/js/sc/system/modules/ISC_Foundation.js",
				// "/js/sc/system/modules/ISC_Calendar.js",
				"/js/sc/system/modules/ISC_Containers.js", "/js/sc/system/modules/ISC_Grids.js",
				"/js/sc/system/modules/ISC_Forms.js", "/js/sc/system/modules/ISC_DataBinding.js",
				"/js/sc/skins/EnterpriseBlue/load_skin.js", "/js/json2.min.js" };
		jsCss.put("js", new ArrayList<String>());
		jsCss.put("css", new ArrayList<String>());
		jsCss.put("jscmd", new ArrayList<String>());
		jsCss.put("jscmdh",
				"var isomorphicDir=\"" + contextPath + "/js/sc/\";" + "\n contextpath=\"" + contextPath + "\";");
		jsCss.put("title", title);
		putStrings(jsCss, "jscmd", jscmd);
		putStrings(jsCss, "js", contextPath, jsSmart);
		putStrings(jsCss, "js", contextPath, js);
		putStrings(jsCss, "css", contextPath, css);
		return jsCss;
	}

	public static void putStrings(HashMap<String, Object> map, String parameter, String contextPath, String[] strings) {
		for (String s : strings) {
			((ArrayList<String>) map.get(parameter)).add(contextPath + s);
		}
	}

	public static void putStrings(HashMap<String, Object> map, String parameter, String[] strings) {
		for (String s : strings) {
			((ArrayList<String>) map.get(parameter)).add(s);
		}
	}

	public static HashMap<String, HashMap<String, Object>> setFetchResult(Object data, Map<String, Object> params) {
		return setFetchResult(data, 0, 0, 1, params);
	}

	public static HashMap<String, HashMap<String, Object>> setErrorMessage(String errorMessage,
			Map<String, Object> params) {
		return setFetchResult(errorMessage, -1, 0, 0, params);
	}

	public static HashMap<String, HashMap<String, Object>> setFetchResult(Object data, int status, int startRow,
			int totalRows, Map<String, Object> params) {
		if (params != null) {
			putTreasureData(params);
		}
		HashMap<String, Object> response = getResponse(data, status, startRow, totalRows);
		HashMap<String, HashMap<String, Object>> result = new HashMap<String, HashMap<String, Object>>();
		result.put("response", response);
		return result;
	}

	public static HashMap<String, HashMap<String, Object>> setNormalFetchResult(ArrayList<Object> ar,
			Map<String, Object> params) {
		return setFetchResult(ar, 0, 0, ar.size(), params);
	}

	public static void putTreasureData(Map<String, Object> params) {
		Timestamp endTime = CalenderUtil.getCurrentTime();
		Timestamp startTime = (Timestamp) params.get("startTimeStamp");
		if (startTime == null) {
			return;
		}
		String sclass = (String) params.get("class");
		String[] ssclass = { "" };
		if (sclass != null) {
			ssclass = sclass.split("\\.");
		}
		String operationType = (String) params.get("operationType");
		Date start = new Date(startTime.getTime());
		SimpleDateFormat format = CalenderUtil.getSdfTimestamp();
		String sStart = format.format(start);

		Long duration = endTime.getTime() - startTime.getTime();
		System.out.println("@[development.ajax] {\"date\":\"" + sStart.substring(0, 10) + "\",\"hour\":\""
				+ sStart.substring(11, 13) + "\",\"min_sec\":\"" + sStart.substring(14, 19) + "\",\"class\":\""
				+ ssclass[ssclass.length - 1] + "\",\"opType\":\"" + operationType + "\",\"duration\":"
				+ duration.toString() + "}");

	}

	private static HashMap<String, Object> getResponse(Object data, int status, int startRow, int totalRows) {
		HashMap<String, Object> response = new HashMap<String, Object>();
		response.put("status", status);
		response.put("startRow", startRow);
		response.put("endRow", startRow + totalRows - 1);
		response.put("totalRows", totalRows);
		response.put("data", data);
		return response;
	}

	public static void removeMetaCommonColumns(Map<String, Object> resultMap, HashMap<String, Object> columns,
			String excludeCat, String[] excludeColumns) {
		for (Iterator<String> iterator = resultMap.keySet().iterator(); iterator.hasNext();) {
			String column = iterator.next();
			String columnCat = (String) columns.get(column);
			if (columnCat == null) {
				iterator.remove();
			} else if (excludeCat.contains(columnCat)) {
				iterator.remove();
			}
		}
		for (String c : excludeColumns) {
			resultMap.remove(c);
		}

	}

	public static String getSystemErrorJspPath() {
		return "/system_error.jsp";
	}

	public static String getNormalJspPath() {
		return "/index.jsp";
	}

	public static HashMap<String, Object> copyToHashMap(Object mt, String[] elements)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		for (String ele : elements) {
			hm.put(ele, PropertyUtils.getSimpleProperty(mt, ele));
		}
		return hm;
	}

	public static void copyCommonRegData(Object old, Object upd)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		String[] commonCols = new String[] { "registerDatetime", "registerUser", "registerProcess" };
		for (String col : commonCols) {
			PropertyUtils.setSimpleProperty(upd, col, PropertyUtils.getSimpleProperty(old, col));
		}

	}

	public static void copyWebXml(String from) throws Exception {
		log.debug("WEB.XML:" + from);
		String path = "src/main/webapp/WEB-INF";

		File jsfile = new File(path + "/" + from);
		File jsfile2 = new File(path + "/" + "web.xml");
		String buf = "";

		BufferedReader br = new BufferedReader(new FileReader(jsfile));
		BufferedWriter bw = new BufferedWriter(new FileWriter(jsfile2));
		while ((buf = br.readLine()) != null) {
			bw.write(buf + "\n");
		}
		br.close();
		bw.close();
	}
}
