package com.mssoftech.web.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;

public class DatabaseConvertUtil {

	private static String _space512 = null;

	public static synchronized String getSpace512() {
		if (_space512 == null) {
			byte[] ss = new byte[512];
			Arrays.fill(ss, (byte) 32);
			_space512 = new String(ss);
		}
		return _space512;
	}

	public static String formatFix(String s, int len) {
		if (s == null) {
			s = getSpace512().substring(0, len);
		} else {
			byte b[] = s.getBytes();
			s += getSpace512().substring(0, (len - b.length));
		}
		return s;
	}

	public static String formatFixRight(String s, int len) {
		if (s == null) {
			s = getSpace512().substring(0, len);
		} else {
			byte b[] = s.getBytes();
			s = getSpace512().substring(0, (len - b.length)) + s;
		}
		return s;
	}

	public static void convertNumericValueToString(Map map,
			final CharSequence... propertyNames) {
		for (CharSequence element : propertyNames) {
			if (map.get(element) != null) {
				if (map.get(element).getClass() == BigDecimal.class) {
					map.put(element, ((BigDecimal) map.get(element)).toString());
				}
				if (map.get(element).getClass() == Long.class) {
					map.put(element, ((Long) map.get(element)).toString());
				}
				if (map.get(element).getClass() == Integer.class) {
					map.put(element, ((Integer) map.get(element)).toString());
				}
			}
		}
	}

	public static void convertNumericValueToCommaString(Map map,
			final CharSequence... propertyNames) {
		for (CharSequence element : propertyNames) {
			if (map.get(element) != null) {
				try {
					map.put(element,
							StringUtil.formatData(map.get(element), "IC"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void convertToUpper(Map map,
			final CharSequence... propertyNames) {
		for (CharSequence element : propertyNames) {
			if (map.get(element) != null) {
				map.put(element, ((String) map.get(element)).toUpperCase());
			}
		}
	}

	public static void removeComma(Map map, final CharSequence... propertyNames) {
		for (CharSequence element : propertyNames) {
			if (map.get(element) != null) {
				map.put(element, removeComma((String) map.get(element)));
			}
		}
	}

	public static String removeComma(String ins) {
		if (ins == null) {
			return null;
		}
		String[] s = ins.split(",");
		String res = "";
		for (int i = 0; i < s.length; i++) {
			res = res + s[i];
		}
		return res;
	}

	public static void convertToStringWhenNull(Map newin,
			final CharSequence... propertyNames) {
		for (CharSequence element : propertyNames) {
			String indata = (String) newin.get(element);
			if (indata == null) {
				newin.put(element, "");
			}
		}
	}

	public static String dateTime(java.sql.Timestamp ts) {
		if (ts == null) {
			return "";
		}
		String s = ts.toString();
		return s.substring(0, 19);
	}
}
