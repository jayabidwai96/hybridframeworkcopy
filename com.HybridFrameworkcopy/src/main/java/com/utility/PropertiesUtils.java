package com.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtils {

	public static String readproperty(String key) {
		Properties prop = new Properties();
		try {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
		prop.load(fis);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
		
	}
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir")+"/src/main/resources/config.properties");
	}
}
