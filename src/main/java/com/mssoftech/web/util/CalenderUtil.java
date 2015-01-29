package com.mssoftech.web.util;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

import com.mssoftech.web.exception.SystemException;

public class CalenderUtil {
	public static SimpleDateFormat getSdfDate() {

		SimpleDateFormat sdfDate = new SimpleDateFormat();
		sdfDate.applyPattern("yyyy/MM/dd");
		sdfDate.setLenient(false); // 厳密な解析

		return sdfDate;
	}

	public static SimpleDateFormat getSdfTimestamp() {

		SimpleDateFormat sdfTimestamp = new SimpleDateFormat();
		sdfTimestamp.applyPattern("yyyy/MM/dd HH:mm:ss");
		sdfTimestamp.setLenient(false); // 厳密な解析

		return sdfTimestamp;
	}

	public static SimpleDateFormat getSdfTime() {

		SimpleDateFormat sdfTime = new SimpleDateFormat();
		sdfTime.applyPattern("hh:mm");
		sdfTime.setLenient(false); // 厳密な解析

		return sdfTime;
	}

	public static String getCurrentDate() {
		return getSdfDate().format(new Date());
	}

	public static String getCurrentDatetime() {
		SimpleDateFormat format = getSdfTimestamp();
		return format.format(new Date());
	}

	public static Timestamp getCurrentTime() {

		return new java.sql.Timestamp(System.currentTimeMillis());

	}

	public static void convertTimestampFromString(Map m, String ele)
			throws ParseException {
		m.put(ele, timestampConvertFromString((String) m.get(ele)));
	}

	public static Timestamp timestampConvertFromString(String sDatetime)
			throws ParseException {
		if (sDatetime == null) {
			return null;
		}
		SimpleDateFormat format = getSdfTimestamp();
		Timestamp tDatetime;
		synchronized (format) {
			tDatetime = new Timestamp(format.parse(sDatetime).getTime());
		}
		return tDatetime;
	}

	public static Date getToday() {
		try {
			SimpleDateFormat format = getSdfDate();
			synchronized (format) {
				return format.parse(getSdfDate().format(new Date()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date get1stOfMonth() {
		try {
			SimpleDateFormat format = getSdfDate();
			synchronized (format) {
				String today = getSdfDate().format(new Date());
				String firstOfMonth = today.substring(0, 8) + "01";
				return format.parse(firstOfMonth);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getNextYear(String year) {
		Integer next_year = Integer.parseInt(year) + 1;
		return next_year.toString();
	}

	public static String getPreviousYear(String year) {
		Integer previou_year = Integer.parseInt(year) - 1;
		return previou_year.toString();
	}

	public static String getPreviousMonth(String month) {
		int imonth = Integer.parseInt(month);
		Integer previous_month = imonth - 1;
		if (previous_month == 0) {
			previous_month = 12;
		}
		return toTwoString(previous_month.toString());
	}

	public static String getNextMonth(String month) {
		int imonth = Integer.parseInt(month);
		Integer next_month = imonth + 1;
		if (next_month == 13) {
			next_month = 1;
		}
		return toTwoString(next_month.toString());
	}

	public static String toTwoString(String svalue) {
		if (svalue.length() > 1) {
			return svalue;
		}
		svalue = "0" + svalue;
		svalue = svalue.substring(svalue.length() - 2, svalue.length());
		return svalue;
	}

	public static String getStringDay(int iday) {
		String sday = toTwoString((new Integer(iday % 100)).toString());
		return sday;
	}

	public static Date getDate(String sdate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		try {
			return formatter.parse(sdate);
		} catch (ParseException e) {
			return null;
		}
	}

	public static void convertData(Map updateInput, String... elements)
			throws Exception {
		for (String ele : elements) {
			convertEachData(updateInput, ele);
			convertEachData(updateInput, "ele");
		}

	}

	public static void convertEachData(Map updateInput, String element)
			throws Exception {
		String stime = (String) updateInput.get(element);
		String hour = "0";
		String min = "0";
		if (stime != null) {
			int pos = stime.indexOf(":");
			if (pos == -1) {
				if (stime.length() == 3 || stime.length() == 4) {
					hour = stime.substring(0, stime.length() - 2);
					min = stime.substring(stime.length() - 2, stime.length());
				} else {
					throw new SystemException("時間　:" + stime + "は正しくありません");
				}
			} else {
				String[] split = stime.split(":");
				if (split.length != 2) {
					throw new SystemException("時間　:" + stime + "は正しくありません");
				}
				hour = split[0];
				min = split[1];
			}
			// 日本の時差 ９時間を引く
			hour = toTwoString(hour);
			min = toTwoString(min);
			if (hour.compareTo("24") >= 0) {
				throw new SystemException("時間が異常値です。:" + hour);
			}
			if (min.compareTo("60") >= 0) {
				throw new SystemException("分が異常値です。:" + min);
			}
			Long milisecond = ((Long.parseLong(hour) - 9L) * 3600 + Long
					.parseLong(min) * 60) * 1000;
			Time time = new Time(milisecond);
			updateInput.put(element, time);
		}
	}

	public static void convertIntToTime(Map map, String... elements) {
		for (String ele : elements) {
			convertEachIntToTime(map, ele);
		}
	}

	private static void convertEachIntToTime(Map map, String ele) {
		Object tt = (Object) map.get(ele);
		map.put(ele, convertIntToStringTime(tt));
	}

	public static String convertIntToStringTime(Object tt) {
		Integer t = null;
		if (tt != null) {
			if (tt.getClass().equals(Integer.class)) {
				t = (Integer) tt;
			}
			if (tt.getClass().equals(Long.class)) {
				t = ((Long) tt).intValue();
			}

			if (t == 0) {
				return null;
			}
			Integer hour = t / 60;
			Integer min = t % 60;
			return hour.toString() + ":" + toTwoString(min.toString());
		} else {
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	public static Date convertIntToDate(Integer i) {
		if (i == null) {
			return null;
		}
		return new Date(i * 60 * 1000 + (new Date("1900/01/01")).getTime());
	}

	public static Integer convertStringTimeToInt(String stime) {
		if (stime == null) {
			return null;
		}
		String[] split = stime.split(":");
		if (split.length != 2) {
			return null;
		}
		return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
	}

	public static Double convertStringToDoubleTime(String data) {

		double s;
		double hh;
		double mm;
		// シリアル値への変換
		if (data == null) {
			return null;
		}
		if (data.length() == 4) {
			data = "0" + data;
		}
		hh = Double.parseDouble(data.substring(0, 2)) * (1.0 / 24.0);
		mm = Double.parseDouble(data.substring(3, 5)) * (1.0 / 24.0 / 60.0);
		s = hh + mm;
		return s;
	}

	static public String getStringFromDatetime(Date d) {
		if (d == null) {
			return "";
		}
		SimpleDateFormat sdfTimestamp = new SimpleDateFormat();
		sdfTimestamp.applyPattern("yyyy/MM/dd HH:mm:ss");
		sdfTimestamp.setLenient(false); // 厳密な解析
		sdfTimestamp.setTimeZone(TimeZone.getTimeZone("JST"));
		return sdfTimestamp.format(d);
	}

	static public Date getDateFromStrTimestamp(String s) throws SystemException {
		String ins = StringUtil.nullConvToString(s);
		if (ins.length() != 0 && ins.length() != 19) {
			throw new SystemException("日付の形式が違います。 (ｙｙｙy/mm/dd hh:mm:dd):" + s);
		}
		if (ins.length() == 0) {
			return null;
		}
		SimpleDateFormat sdfTimestamp = new SimpleDateFormat();
		sdfTimestamp.applyPattern("yyyy/MM/dd HH:mm:ss");
		sdfTimestamp.setLenient(false); // 厳密な解析
		sdfTimestamp.setTimeZone(TimeZone.getTimeZone("JST"));
		try {
			Date date = sdfTimestamp.parse(ins);
			return date;
		} catch (ParseException e) {
			throw new SystemException("日付が変換出来ません " + ins);
		}
	}

}
