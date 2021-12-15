package com.testingshastra.uitests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.testingshastra.config.BaseClass;
import com.testingshastra.keywords.UIKeyWords;
import com.testingshastra.util.Locator;
import com.testingshastra.util.WaitFor;
import com.testingshastra.util.TestListener;
/**
 * when listener written in testng.xml i.e it run from .xml file
 *  then no need to write and import @Listeners here for that conver project into testng
 * @author dell
 *
 */
@Listeners(TestListener.class)   
public class SignupPageTests extends BaseClass {
	UIKeyWords keywords = UIKeyWords.getInstance();

	private static final Logger LOG = Logger.getLogger(SignupPageTests.class);

	
	@Test
	public void validateFirstNameFieldForCorrectInput() {
		LOG.info("URL is launched");
		//keywords.launchUrl("https://www.ijmeet.com");

		// Approach 1
		// WebElement signup =
		// keywords.getDriver().findElement(By.cssSelector("li:nth-child(5)
		// a.nav-link"));
		// keywords.click(signup);

		// Approach 2
		/**
		 * In this approach there is no reusability of locators
		 */

//	keywords.click("css", "li:nth-child(5) a.nav-link");
//	keywords.enterText("css", "input#name", "Swati Sonawane");
//	keywords.enterText("css", "input#company_name", "Testing Shastra");
//	keywords.enterText("css", "input#email", "testingshastra@gmail.com");
//	keywords.enterText("css", "input#contact", "7648268967");
//	keywords.enterText("css", "input#password", "12345678");
//	keywords.switchToFrameAt(0);
//	keywords.click("css", "div.recaptcha-checkbox-border");
//	keywords.switchToDefaultContent();
//	keywords.click("css", "button[type='submit']");
//	String actualUrl = keywords.getCurrentUrl();
//	Assert.assertTrue(actualUrl.contains("dashboard"));

		/**
		 * in this we can reuse the locators using ObjectRepository file
		 */

		keywords.click("css", "li:nth-child(5) a.nav-link");
		keywords.enterText(Locator.SIGNUP_FULLNAME, "Swati Sonawane");
		keywords.enterText(Locator.SIGNUP_COMPANYNAME, "Testing Shastra");
		keywords.enterText(Locator.SIGNUP_EMAILID, "testingsha@gmail.com");
		keywords.enterText(Locator.SIGNUP_MOBILENUMBER, "7648268967");
		keywords.enterText(Locator.SIGNUP_PASSWORD, "Dfghh@12dg");
		keywords.switchToFrameAt(0);
		LOG.info("Switched inside a frame");
		WaitFor.elementToBeClickable(keywords.getWebElement("css", "div.recaptcha-checkbox-border"));
		keywords.click("css", "div.recaptcha-checkbox-border");
		keywords.switchToDefaultContent();
		keywords.click("css", "button[type='submit']");
		String actualUrl = keywords.getCurrentUrl();
		Assert.assertTrue(actualUrl.contains("dashboard"));
	}

}
