package com.testingshastra.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	public static String getProperty(String fileName, String key) {
		String value = "";
		String cwd = System.getProperty("user.dir");
		try {
			FileInputStream fis = new FileInputStream(cwd+fileName);
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;

	}
	/**
	 * This method used to return s the locator value from ObjectRepository
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 */
	public static String getObject(String key){
//		String value = "";
//		String cwd = System.getProperty("user.dir");
//		try {
//			FileInputStream fis = new FileInputStream(cwd+"/src/test/resources/ObjectRepository.properties");
//			Properties prop = new Properties();
//			prop.load(fis);
//			value = prop.getProperty(key);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return value;
//		
		
		return getProperty("/src/test/resources/ObjectRepository.properties", key);
		
	}

}
