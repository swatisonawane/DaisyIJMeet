package com.testingshastra.config;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.testingshastra.keywords.UIKeyWords;
import com.testingshastra.util.PropertiesFile;

public class BaseClass {
	UIKeyWords keywords = UIKeyWords.getInstance();
    
	@Parameters("browser-name")
	@BeforeMethod
	//public void setup() 
	public void setup(@Optional String browserName) {
		Application app = new Application();
		if(browserName == null) {
			browserName = app.getBrowser();
		}
		//keywords.openBrowser("chrome");   //using UIKeywords.java
		//keywords.openBrowser(app.getBrowser());  //using Application.java
		keywords.openBrowser(browserName);   
		
		//keywords.driver.get(PropertiesFile.getProperty("/src/main/resources/application.properties", "daisy.app.url"));
		keywords.driver.get(app.getAppUrl());
		//keywords.driver.get("https://ijmeet.com");
		
	}

	@AfterMethod
	public void tearDown() {
		keywords.quite();

	}

}
