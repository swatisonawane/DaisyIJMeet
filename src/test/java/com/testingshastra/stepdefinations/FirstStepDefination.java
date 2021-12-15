package com.testingshastra.stepdefinations;

import org.testng.Assert;

import com.testingshastra.config.Application;
import com.testingshastra.keywords.UIKeyWords;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class FirstStepDefination {
	UIKeyWords keywords = UIKeyWords.getInstance();

	//@Before
	public void setup() {
		Application app = new Application();
		String browserName = app.getBrowser();
		keywords.openBrowser(browserName);
		keywords.driver.get(app.getAppUrl());
	}

	//@After
	public void tearDown() {
		keywords.driver.quit();

	}

	@Given("The chrome browser is launched")
	public void the_chrome_browser_is_launched() {
		Application app = new Application();
		String browserName = app.getBrowser();
		keywords.openBrowser(browserName);

	}

	@Given("The url of application is also launched")
	public void the_url_of_application_is_also_launched() {
		Application app = new Application();
		keywords.driver.get(app.getAppUrl());

	}

	@Then("Verify the title of homepage")
	public void verify_the_title_of_homepage() {
		String actual = keywords.driver.getTitle();
		String expected = "IJmeet";
		Assert.assertEquals(actual, expected);

	}

}
