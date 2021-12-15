/*
 * File for use content of application.properties
 * all comman things in application.properties file
 */

package com.testingshastra.config;

import com.testingshastra.util.PropertiesFile;

public class Application {
	public static final String FILEPATH = "/src/main/resources/application.properties";

	public String getBrowser() {
		return PropertiesFile.getProperty(FILEPATH, "daisy.browserName");

	}

	public void getDbUrl() {
		// TODO Auto-generated method stub

	}
	public String getAppUrl() {
		return PropertiesFile.getProperty(FILEPATH, "daisy.app.url");

	}
}
