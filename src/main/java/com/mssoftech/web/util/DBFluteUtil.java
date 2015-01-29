package com.mssoftech.web.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.dbflute.bhv.AbstractBehaviorWritable;
import org.dbflute.cbean.AbstractConditionQuery;
import org.dbflute.cbean.coption.ConditionOptionCall;
import org.dbflute.cbean.coption.LikeSearchOption;
import org.dbflute.dbmeta.AbstractDBMeta;
import org.dbflute.dbmeta.info.ColumnInfo;
import org.dbflute.hook.AccessContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mssoftech.web.exception.SystemException;


public class DBFluteUtil {
	static protected Logger log = LoggerFactory.getLogger(DBFluteUtil.class);
	static HashMap _comnColMap = null;
	static HashMap<String, String> _omap = null;
	static HashMap<String, String> _omap2 = null;
	static Boolean localenv = null;
	static String LF = "\n";
	
	public static void clearAccessContext() {
		AccessContext.clearAccessContextOnThread();
		log.debug("ActionAccessContextIntercepter End");
	}

	public static void setUserProcessToAccessContext(String user, String process) {
		AccessContext ac = AccessContext.getAccessContextOnThread();
		ac.setAccessUser(user);
		ac.setAccessProcess(process);
	}
	public static void setNewAccessContext(String user, String process) {
		AccessContext ac = new AccessContext();
		ac.setAccessUser(user);
		ac.setAccessProcess(process);
		AccessContext.setAccessContextOnThread(ac);
		log.debug("ActionAccessContextIntercepter Begin");
	}
	public static synchronized HashMap getOpMap() {
		if (_omap == null) {

			_omap = new HashMap();
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

	public static synchronized HashMap getOpMap2() {
		if (_omap2 == null) {

			_omap2 = new HashMap();
			_omap2.put("between", "LessEqual");
			_omap2.put("exclude", "GreaterThan");
		}
		return _omap2;
	}

	public static HashMap getJsCss(String contextPath, String[] js,
			String[] css, String title, String[] jscmd) {
		HashMap jsCss = new HashMap();

		String[] jsSmart = {
				"/js/sc/system/modules/ISC_Core.js",
				"/js/sc/system/modules/ISC_Foundation.js",
				// "/js/sc/system/modules/ISC_Calendar.js",
				"/js/sc/system/modules/ISC_Containers.js",
				"/js/sc/system/modules/ISC_Grids.js",
				"/js/sc/system/modules/ISC_Forms.js",
				"/js/sc/system/modules/ISC_DataBinding.js",
				"/js/sc/skins/EnterpriseBlue/load_skin.js", "/js/json2.min.js" };
		jsCss.put("js", new ArrayList());
		jsCss.put("css", new ArrayList());
		jsCss.put("jscmd", new ArrayList());
		jsCss.put("jscmdh", "var isomorphicDir=\"" + contextPath + "/js/sc/\";"
				+ "\n contextpath=\"" + contextPath + "\";");
		jsCss.put("title", title);
		putStrings(jsCss, "jscmd", jscmd);
		putStrings(jsCss, "js", contextPath, jsSmart);
		putStrings(jsCss, "js", contextPath, js);
		putStrings(jsCss, "css", contextPath, css);
		return jsCss;
	}

	public static void putStrings(HashMap map, String parameter,
			String contextPath, String[] strings) {
		for (String s : strings) {
			((ArrayList) map.get(parameter)).add(contextPath + s);
		}
	}

	public static void putStrings(HashMap map, String parameter,
			String[] strings) {
		for (String s : strings) {
			((ArrayList) map.get(parameter)).add(s);
		}
	}

	public static HashMap setFetchResult(Object data, Map params) {
		return setFetchResult(data, 0, 0, 1, params);
	}

	public static HashMap setErrorMessage(String errorMessage, Map params) {
		return setFetchResult(errorMessage, -1, 0, 0, params);
	}

	public static HashMap setFetchResult(Object data, int status, int startRow,
			int totalRows, Map params) {
		if (params != null) {
			putTreasureData(params);
		}
		HashMap response = getResponse(data, status, startRow, totalRows);
		HashMap result = new HashMap();
		result.put("response", response);
		return result;
	}

	public static HashMap setNormalFetchResult(ArrayList ar, Map params) {
		return setFetchResult(ar, 0, 0, ar.size(), params);
	}

	public static void putTreasureData(Map params) {
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
		System.out.println("@[development.ajax] {\"date\":\""
				+ sStart.substring(0, 10) + "\",\"hour\":\""
				+ sStart.substring(11, 13) + "\",\"min_sec\":\""
				+ sStart.substring(14, 19) + "\",\"class\":\""
				+ ssclass[ssclass.length - 1] + "\",\"opType\":\""
				+ operationType + "\",\"duration\":" + duration.toString()
				+ "}");

	}

	private static HashMap getResponse(Object data, int status, int startRow,
			int totalRows) {
		HashMap response = new HashMap();
		response.put("status", status);
		response.put("startRow", startRow);
		response.put("endRow", startRow + totalRows - 1);
		response.put("totalRows", totalRows);
		response.put("data", data);
		return response;
	}

	public static void removeMetaCommonColumns(Map<String, Object> resultMap,
			HashMap columns, String excludeCat, String[] excludeColumns) {
		for (Iterator<String> iterator = resultMap.keySet().iterator(); iterator
				.hasNext();) {
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

	public static HashMap copyToHashMap(Object mt, String[] elements)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		HashMap hm = new HashMap();
		for (String ele : elements) {
			hm.put(ele, PropertyUtils.getSimpleProperty(mt, ele));
		}
		return hm;
	}

	public static void copyCommonRegData(Object old, Object upd)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		String[] commonCols = new String[] { "registerDatetime",
				"registerUser", "registerProcess" };
		for (String col : commonCols) {
			PropertyUtils.setSimpleProperty(upd, col,
					PropertyUtils.getSimpleProperty(old, col));
		}

	}

	public static void setCriteria(AbstractConditionQuery query, Map map)
			 {
		// AbstractConditionQuery
		HashMap opMap = getOpMap();
		HashMap opMap2 = getOpMap2();
		String field = (String) map.get("fieldName");

		String operator = (String) map.get("operator");
		String op = (String) opMap.get(operator);
		String setter = "set" + field.substring(0, 1).toUpperCase()
				+ field.substring(1) + "_" + op;
		String op2 = (String) opMap2.get(operator);
		String setter2 = "set" + field.substring(0, 1).toUpperCase()
				+ field.substring(1) + "_" + op2;
		String start = CommonUtil.convertToString(map.get("start"));
		String end = CommonUtil.convertToString(map.get("end"));
		
		ConditionOptionCall<LikeSearchOption> likeContain = (o) -> {
			o.likeContain();
		};
		ConditionOptionCall<LikeSearchOption> likePrefix = (o) -> {
			o.likePrefix();
		};
		ConditionOptionCall<LikeSearchOption> likeSuffix = (o) -> {
			o.likeSuffix();
		};

		// start がNullまたは Spaceなら何もしない
		if (operator == null || start == null || start.equals("")) {
			return;
		}
		if (operator.equals("between") && (end == null || end.equals(""))) {
			return;
		}

			
		
		try {
			Method[] methods = query.getClass().getMethods();
			for (Method method : methods) {
				if (method.getName().equals(setter)) {
					Object startObj = convParameterFromString(start,
							method.getParameterTypes()[0]);
					if (op.equals("LikeSearch") || op.equals("NotLikeSearch")) {
						ConditionOptionCall<LikeSearchOption> lso = null;
						if (operator.equals("contains")
								|| operator.equals("does not contain")) {
							lso=likeContain;
						}
						if (operator.equals("starts with")
								|| operator.equals("does not start with")) {
							lso=likePrefix;
						}
						if (operator.equals("ends with")
								|| operator.equals("does not end with")) {
							lso=likeSuffix;
						}
						// method.invoke(query, startObj, lso);
						method.invoke(query, startObj, lso);
					} else {
						method.invoke(query, startObj);
					}

				}
				// if (operator.equals("between") &&
				// method.getName().equals(setter2)) {
				if (method.getName().equals(setter2)) {
					Object endObj = convParameterFromString(end,
							method.getParameterTypes()[0]);
					method.invoke(query, endObj);
				}
			

			}
		} catch (Exception e) {
			if (e.getClass().equals(SystemException.class)){
				throw (SystemException)e;
			}
			log.error("SetupQueryCriteriaError");
			CommonUtil.putStacktraceToLog(log, e);
			throw new SystemException("SetupQueryCriteriaError");
		}

	}

	private static Object convParameterFromString(String param, Class<?> class1) {
		if (param == null) {
			return null;
		}
		if (class1.equals(String.class)) {
			return param;
		}
		param = param.trim();
		if (class1.equals(Integer.class)) {
			try {
				return Integer.valueOf(param);
			} catch (Exception e) {
				throw new SystemException(param + "の整数形式が正しくないです。");
			}
		}
		if (class1.equals(Date.class)) {
			SimpleDateFormat format = CalenderUtil.getSdfDate();
			try {
				return format.parse(param);
			} catch (Exception e) {
				throw new SystemException(param + "の日付形式が正しくないです。");
			}

		}
		if (class1.equals(Timestamp.class)) {

			if (param.length() == 10) {
				param = param + " 00:00:00";
			}
			SimpleDateFormat format = CalenderUtil.getSdfTimestamp();

			try {
				return new Timestamp(format.parse(param).getTime());
			} catch (Exception e) {
				;
				throw new SystemException(param + "の時間形式が正しくないです。");
			}

		}
		if (class1.equals(Boolean.class)) {
			if (param.equals("true")) {
				return new Boolean(true);
			}
			return new Boolean(false);
		}

		throw new RuntimeException("Conversion rule not set for "
				+ class1.toString());
	}

	public static HashMap getColumns(AbstractBehaviorWritable bhv)
			throws Exception {
		HashMap<String, String> columns = new HashMap();
		HashMap commonColMap = getComnColMap();
		Method getMyDBMeta = bhv.getClass().getMethod("getMyDBMeta",
				(Class<?>[]) null);
		AbstractDBMeta myDBMeta = (AbstractDBMeta) getMyDBMeta.invoke(bhv,
				(Object[]) null);
		Method[] methods = myDBMeta.getClass().getMethods();
		String type = null;
		for (Method method : methods) {
			String methodName = method.getName();

			if (!methodName.startsWith("column")
					|| method.getReturnType() != ColumnInfo.class) {
				continue;
			}
			String column = methodName.substring(6, 7).toLowerCase()
					+ methodName.substring(7);
			if ((type = (String) commonColMap.get(column)) != null) {
				columns.put(column, type);
			} else {
				columns.put(column, "N");
			}
		}
		return columns;
	}

	private static synchronized HashMap getComnColMap() {
		if (_comnColMap == null) {
			_comnColMap = new HashMap();
			for (String c : new String[] { "registerDatetime", "registerUser",
					"registerProcess" }) {
				_comnColMap.put(c, "R");
			}
			for (String c : new String[] { "updateDatetime", "updateUser",
					"updateProcess" }) {
				_comnColMap.put(c, "U");
			}
			for (String c : new String[] { "versionNo" }) {
				_comnColMap.put(c, "V");
			}
		}
		return _comnColMap;
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
