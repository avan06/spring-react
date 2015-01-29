package com.mssoftech.web.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class StringUtil {
	public static boolean isNullOrSpace(String s) {
		if (s == null || s.equals("") || s.equals(" ")) {
			return true;
		}
		return false;
	}

	public static String nullConvToString(String s) {
		if (s == null) {
			return "";
		}
		return s;
	}

	public static String removeLeadingZero(String s) {
		// Leading 0 がない場合はそのまま返す
		if (!s.substring(0, 1).equals("0")) {
			return s;
		}
		if (s.contains(".") == false) {
			return removeLeadingZeroInt(s);
		}
		int spos = 0;
		for (int i = 0; i < s.length() && s.substring(i, i + 1).equals("0"); i++) {
			spos = i;
		}
		spos++;
		if (s.substring(spos, spos + 1).equals(".")) {
			spos--;
		}
		return s.substring(spos, s.length());
	}

	public static String removeLeadingZeroInt(String s) {
		int spos = 0;
		// Leading 0 がない場合はそのまま返す
		if (!s.substring(0, 1).equals("0")) {
			return s;
		}
		for (int i = 0; i < s.length() && s.substring(i, i + 1).equals("0"); i++) {
			spos = i;
		}
		if (spos < s.length() - 1) {
			spos++;
		}
		return s.substring(spos, s.length());
	}

	public static String trim(String s) {
		String sres = s.replaceAll("^\\s+", "");
		sres = sres.replaceAll("\\s+$", "");
		return sres;
	}

	public static String replaceZenkakuParenthensis(String s) {
		if (s == null) {
			return "";
		}
		String res = s.replaceAll("（", "(");
		res = res.replaceAll("）", ")");
		return res;
	}

	public static String formatData(Object data, String type) throws Exception {
		String res = null;
		if (data == null) {
			return "";
		}
		if (type.equals("S") || type.equals("I") || type.equals("N")) {
			res = String.valueOf(data);
		}
		if (type.equals("D")) {
			SimpleDateFormat dateFormat = CalenderUtil.getSdfDate();
			res = dateFormat.format(data);
		}
		if (type.equals("DT")) {
			SimpleDateFormat format = CalenderUtil.getSdfTimestamp();
			res = format.format(data);

		}
		if (type.equals("T")) {
			SimpleDateFormat format = CalenderUtil.getSdfTime();
			res = format.format(data);
		}
		if (type.equals("IC") || type.equals("NC")) {
			DecimalFormat df0 = new DecimalFormat("###,###,###,##0");
			res = df0.format(data);
		}
		if (type.equals("NC1")) {
			DecimalFormat df1 = new DecimalFormat("#,###,###,##0.0");
			res = df1.format(data);

		}
		if (type.equals("NC2")) {
			DecimalFormat df2 = new DecimalFormat("#,###,###,##0.00");
			res = df2.format(data);
		}
		if (type.equals("N1")) {
			DecimalFormat dfn1 = new DecimalFormat("###########0.0");
			res = dfn1.format(data);
		}
		if (type.equals("N2")) {
			DecimalFormat dfn2 = new DecimalFormat("###########0.00");
			res = dfn2.format(data);
		}
		if (type.equals("I2")) {
			DecimalFormat i2 = new DecimalFormat("00");
			res = i2.format(data);
		}
		if (type.equals("I3")) {
			DecimalFormat i3 = new DecimalFormat("000");
			res = i3.format(data);
		}
		if (data != null && res == null) {
			throw new Exception("Format " + type + " は未定義です");
		}
		return res;
	}
}
