package com.shen.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 操作系统工具类
 * @author shen
 *
 */
public class OsUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(OsUtils.class);
	
	/**
	 * 判断当前系统是否windows
	 * @return 是windows系统返回true，否则就是linux，返回false
	 */
	public static boolean isWindowsOS() {
		boolean isWindowsOS = false;
		String osName = System.getProperty("os.name");
		String osVersion = System.getProperty("os.version");
		System.out.println(osName + " - " + osVersion);  
		if (osName.toLowerCase().indexOf("windows") > -1) {
			isWindowsOS = true;
		}
		return isWindowsOS;
	}
	
	/**
	 * 
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException{
		logger.debug("该系统是window = "+ OsUtils.isWindowsOS());
		System.out.println(InetAddress.getLocalHost());
	}
	
}
