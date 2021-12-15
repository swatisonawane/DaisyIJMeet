package com.testingshastra.util;

import static com.testingshastra.util.PropertiesFile.getObject; //import all static members of Properties file 

public class Locator {
	public static final String SIGNUP_FULLNAME = PropertiesFile.getObject("signup.fullname");
	public static final String SIGNUP_COMPANYNAME = getObject("signup.companyname"); // static import
	public static final String SIGNUP_EMAILID = getObject("signup.emailid");
	public static final String SIGNUP_MOBILENUMBER = getObject("signup.mobilenumber");
	public static final String SIGNUP_PASSWORD = getObject("signup.password");
	public static final String SIGNUP_RECAPTCHA = getObject("signup.recaptcha");
	public static final String SIGNUP_SIGNUPBTN = getObject("signup.signupbtn");

}
