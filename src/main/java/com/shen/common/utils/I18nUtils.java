package com.shen.common.utils;

import java.util.Locale;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 国际化工具类
 * 
 * @author shen
 * 
 */
public class I18nUtils {

	private static final Logger logger = LoggerFactory
			.getLogger(I18nUtils.class);

	/**
	 * 获得此 Java 虚拟机实例的当前‘默认语言环境值’ 的 ‘国家/地区代码’ 可以是‘空字符串’或‘大写’的 ISO 3166
	 * 两字母代码，如中国返回 CN
	 * 
	 * @return
	 */
	public static String getLocalCountry() {
		return Locale.getDefault().getCountry();
	}

	/**
	 * 获得此 Java 虚拟机实例的当前‘默认语言环境值’ 的 ‘语言代码’ 可以是‘空字符串’或‘小写’的 ISO 639 代码，如中国返回 zh
	 * 
	 * @return
	 */
	public static String getLocalLanguage() {
		return Locale.getDefault().getLanguage();
	}

	/**
	 * 获得此 Java 虚拟机实例的当前默认语言环境值的字符串信息。
	 * 
	 * @return
	 */
	public static String getLocalI18n() {
		return Locale.getDefault().toString();
	}
	
	

	public static void main(String[] args) {
		logger.debug("本地语言环境国家代码={}", I18nUtils.getLocalCountry());
		logger.debug("本地语言环境语言代码={}", I18nUtils.getLocalLanguage());
		logger.debug("本地语言环境={}", I18nUtils.getLocalI18n());
		
		Locale currentLocale = new Locale("ja", "JP");
		
		ResourceBundle rb = ResourceBundle.getBundle("res.MessagesBundle", currentLocale);
		// 当rb访问不到currentLocale对应的资源文件时，会去读缺省的basename的那个文件。所以basename的那个文件一定要提供。
		System.out.println(rb.getString("k1"));
		System.out.println(rb.getString("k2"));
	}

}
