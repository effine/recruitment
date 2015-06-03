package cn.effine.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {

	/**
	 * 取得系统当前时间(格式：1970年1月1日0时起到当前的毫秒)
	 *
	 * @return 当前时间
	 */
	public static long getCurrentTiem() {
		return System.currentTimeMillis();
	}

	/**
	 * 取得当前时间，格式： yyyy-MM-dd hh:mm:ss
	 *
	 * @return 当前时间
	 */
	public static String getNowTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(new Date().getTime());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(calendar.getTime());
	}
	
	/**
	 * 字符串(格式：yyyy-MM-dd hh:mm:ss) --> 毫秒(说明：1970年1月1日0时起到当前字符串时间的毫秒)
	 *
	 * @return 毫秒数(1970年1月1日0时起到当前字符串时间的毫秒)
	 */
	public static long stringToMillis(String source) {
		Date date = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = dateFormat.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(null == date) return 0;
		return date.getTime();
	}
}
