package com.testingshastra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingshastra.keywords.UIKeyWords;

public class JoinMeetingPage {
	UIKeyWords keywords = UIKeyWords.getInstance();
	public JoinMeetingPage() {
		PageFactory.initElements(keywords.driver, this);
	}
	@FindBy(css = "h2.m-txt")
	public WebElement quickJoinMeetingTitle;

	public String getQuickJoinMeetingTitle() {
		return quickJoinMeetingTitle.getText();
	}
}
