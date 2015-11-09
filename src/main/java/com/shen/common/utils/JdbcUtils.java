package com.shen.common.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * jdbc连接数据库工具类
 * @author 申路国
 */
public class JdbcUtils {
	private static Properties info = new Properties();
//	private static InputStream is = null;
	/**
	 * 静态代码块初始化db.properties中的数据库配置信息。
	 */
//	static {
//		try {
//			//设置系统配置资源类路径到qingbao.cfg.dir全局常量
////			OsUtils.QINGBAO_CFG_DIR = OsUtils.getConfigResourcePath();
//			//设置db.properties文件所在类路径
////			if(!StringUtils.isBlank(OsUtils.QINGBAO_CFG_DIR)){//QINGBAO_CFG_DIR 不为空
////	    		is = new FileInputStream(new File(OsUtils.QINGBAO_CFG_DIR + OsUtils.FILE_SEPARATOR + OsUtils.APP_CFG_FILE_NAME_SEARCHER + OsUtils.FILE_SEPARATOR + "db.properties"));// JdbcUtil.class.getResourceAsStream();
////	    	}else{//默认
//	    		is = JdbcUtil.class.getResourceAsStream("/db.properties");
////	    	}
//			info.load(is);
//			is.close();
//		} catch (Exception e) {
//			throw new ExceptionInInitializerError(e);
//		}finally{
//			try {
//				is.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName(info.getProperty("driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("加载oracle驱动，初始化db.properties配置文件出错。");
		}
		try {
			conn = DriverManager.getConnection(info.getProperty("url"), info
					.getProperty("username"), info.getProperty("password"));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("创建数据库连接失败，请检查db.properties配置文件，并查看数据库用户名密码是否配置正确。");
		}
		return conn;
	}
	/**
	 * 根据参数获取数据库连接
	 * @param driver
	 * @param url
	 * @param username
	 * @param password
	 * @return
	 */
	public static Connection getConnection(String driver,String url,String username,String password){
		Connection conn = null;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("加载数据库驱动出错。");
		}
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("创建数据库连接失败，请检查参数是否配置正确。");
		}
		return conn;
	}
	
	/**
	 * 释放资源,释放数据库连接
	 * @param rs
	 * @param stm
	 * @param conn
	 */
	public static void release(ResultSet rs, Statement stm, Connection conn) {
		if (rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭ResultSet出错");
			}
		}
		if (stm != null){
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭Statement出错");
			}
		}
		if (conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭Connection出错");
			}
		}
	}
	/**
	 * main方法测试
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
//		System.out.println(getConnection());
		System.out.println(JdbcUtils.getConnection("org.h2.Driver", "jdbc:h2:tcp://localhost/D:/work/h2db/ccc", "sa", "1234"));
		System.out.println("==== 数据库连接成功 ====");
	}
}
