package com.testingshastra.uitests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingshastra.config.BaseClass;
import com.testingshastra.keywords.UIKeyWords;
import com.testingshastra.pages.HomePage;
import com.testingshastra.pages.JoinMeetingPage;

public class HomePageTests extends BaseClass {
	UIKeyWords keywords = UIKeyWords.getInstance();

	// PageFactory.initElements(keywords.driver, "HomePage.class");
	@Test
	public void verifyTitleOfHomePage() {
		String expected = "IJmeet";
		Assert.assertEquals(keywords.driver.getTitle(), expected);

	}

	@Test
	public void verifyUserRedirectsToJoinMeetingPage() {
		//HomePage home = PageFactory.initElements(keywords.driver, HomePage.class);
		HomePage home = new HomePage();
		home.clickOnJoinMeetingTab();
		//JoinMeetingPage joinMeeting = PageFactory.initElements(keywords.driver, JoinMeetingPage.class);
		JoinMeetingPage joinMeeting = new JoinMeetingPage();
		String actual = joinMeeting.getQuickJoinMeetingTitle();
		Assert.assertTrue(actual.contains("Quick"));

	}
	
	@Test
	public void printAllInfLinks() {
		HomePage home = new HomePage();
		home.getTextOfInfoLinks();

	}

}
