package com.shen.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 字符串工具类
 * 
 * @author shen
 * 
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(StringUtils.class);
	
	/**
	 * 判定输入的字符串是否为空或是空字符串。
	 * 
	 * @param input
	 * @return 空返回true，不空返回false。
	 */
	public static boolean blank(String input) {
		return input == null || "".equals(input) || input.length() == 0
				|| input.trim().length() == 0;
	}

	/**
	 * 判定输入的字符串不为空。
	 * @param input
	 * @return 不空返回true，空返回false。
	 */
	public static boolean notBlank(String input) {
		return !blank(input);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String aa = " ";
		logger.debug("字符串aa为空={}"+StringUtils.blank(aa));
	}

}
