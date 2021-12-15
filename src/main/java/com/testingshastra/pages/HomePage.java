package com.testingshastra.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingshastra.keywords.UIKeyWords;

public class HomePage {
	UIKeyWords keywords = UIKeyWords.getInstance();

	public HomePage() {
		PageFactory.initElements(keywords.driver, this);
	}

	@FindBy(css = "div#navbarContent ul  li:nth-child(1)")
	public WebElement joinMeetingTab;

	@FindBy(css = "div.footer-last-view-support div:nth-child(3) li a")
	public List<WebElement> infoLinks;

	public void clickOnJoinMeetingTab() {
		joinMeetingTab.click();
	}

	public void getTextOfInfoLinks() {
		Iterator<WebElement> itr = infoLinks.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().getText());

		}

	}

	public List<WebElement> getAllLinks() {
		return keywords.driver.findElements(By.tagName("a"));

	}

}
