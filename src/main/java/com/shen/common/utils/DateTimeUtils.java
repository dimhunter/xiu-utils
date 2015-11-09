package com.shen.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期时间工具类
 * 
 * @author shen
 * 
 */
public class DateTimeUtils {

	private static final Logger logger = LoggerFactory
			.getLogger(DateTimeUtils.class);
	
	/** yyyyMMddHHmmss **/
	public static final String TIME_FORMAT_SHORT = "yyyyMMddHHmmss";
	public static final String TIME_FORMAT_NORMAL = "yyyy-MM-dd HH:mm:ss";
	public static final String TIME_FORMAT_ENGLISH = "MM/dd/yyyy HH:mm:ss";
	public static final String TIME_FORMAT_CHINA = "yyyy年MM月dd日 HH时mm分ss秒";
	public static final String TIME_FORMAT_MILLISECOND = "yyyyMMddhhmmssSSS"; // 毫秒级别

	public static final String DATE_FORMAT_SHORT = "yyyyMMdd";
	public static final String DATE_FORMAT_NORMAL = "yyyy-MM-dd";
	public static final String DATE_FORMAT_ENGLISH = "MM/dd/yyyy";
	public static final String DATE_FORMAT_CHINA = "yyyy年MM月dd日";
	public static final String MONTH_FORMAT = "yyyyMM";
	public static final String DATE_FORMAT_MINUTE = "yyyyMMddHHmm";

	
	/**
	 * 得到时间字符串,格式为 formate形式
	 * @param date 时间
	 * @param format 要格式化成的时间串形式
	 * @return 返回格式化的时间串
	 */
	public static String getTimeAsStyle(Date date,String format) {
		DateFormat fmt = new SimpleDateFormat(format);
		return fmt.format(date);
	}
	
	/**
	 * 得到时间字符串,格式为 yyyyMMddHHmmss
	 * 
	 * @return 返回当前时间的字符串
	 */
	public static String getNowTimeShortString() {
		return getTimeAsStyle(new Date(),TIME_FORMAT_SHORT);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		logger.debug("现在时间={}",DateTimeUtils.getTimeAsStyle(new Date(),TIME_FORMAT_CHINA));
		logger.debug("现在时间={}",DateTimeUtils.getTimeAsStyle(new Date(),TIME_FORMAT_MILLISECOND));
		logger.debug("现在时间={}",DateTimeUtils.getNowTimeShortString());
	}

}
