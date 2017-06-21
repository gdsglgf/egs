package com.mybatis.examples.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {
	private static Properties prop = null;
	public static String configs = "configs.properties";
	
	private PropertyUtils() {}
	
	static {
		try {
			InputStream inStream = new FileInputStream(new File(configs));
			prop = new Properties();
			prop.load(inStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getProperty(String key) {
		return prop.getProperty(key);
	}
}
