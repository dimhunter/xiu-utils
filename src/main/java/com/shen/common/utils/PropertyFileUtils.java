package com.shen.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * properties文件工具类。
 * @author shen
 *
 */
public class PropertyFileUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(PropertyFileUtils.class);

	private static Map<String, PropertyFileUtils> instanceMap = new HashMap<String, PropertyFileUtils>();

	private Properties properties;

	private String pfile;// 属性文件名

	private File propFile;// 属性文件

	private long lastModifiedTime = 0;// 最后修改日期

	private boolean dynamicLoad = false;

	// 构造方法私有
	private PropertyFileUtils(String file) {
		URL url = getClass().getResource("/" + file);
		if (url == null) {
			logger.error(file + " file does not exist!");
			return;
		}
		pfile = url.getFile();
		propFile = new File(pfile);
		lastModifiedTime = propFile.lastModified();
		properties = new Properties();
		try {
			properties.load(new FileInputStream(propFile));
//			String dynamicload = properties.getProperty("DynamicLoad");
//			if (!StringUtils.isBlank(dynamicload) && (Boolean) StringUtils.com.shen.convert(dynamicload, Boolean.class)) {
//				dynamicLoad = true;
//				logger.debug("dynamic load properties file!");
//			}
		} catch (IOException e) {
			logger.debug(e.toString());
		}
	}

	public static PropertyFileUtils getInstance() {
		return getInstance(null);
	}

	synchronized public static PropertyFileUtils getInstance(String file) {
		if (StringUtils.isBlank(file)) {
			file = "sysconfig.properties";
		}
		PropertyFileUtils instance = instanceMap.get(file);
		if (instance == null) {
			logger.debug("create a new instance of SysConfigPropertyUtil!");
			instance = new PropertyFileUtils(file);
			instanceMap.put(file, instance);
		} else {
			logger.debug("SysConfigPropertyUtil instance already exists");
		}
		return instance;
	}

	public String getPropertyValue(String key) {
		if (StringUtils.isBlank(key)) {
			return null;
		}
		if (dynamicLoad) {
			boolean reload = false;
			if (lastModifiedTime == 0) {
				lastModifiedTime = propFile.lastModified();
				reload = true;
			} else if (propFile.lastModified() > lastModifiedTime) {
				properties.clear();
				reload = true;
			}
			if (reload) {
				logger.info(pfile + " file had been modified,so load again!");
				try {
					properties.load(new FileInputStream(propFile));
				} catch (IOException e) {
					if (lastModifiedTime == 0) {
						logger.error(pfile + " does not exist!");
					} else {
						logger.error(pfile + " file was deleted!");
					}
					logger.error(e.toString());
				}
			}
		}
		return properties.getProperty(key);
	}

}
