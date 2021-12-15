package com.testingshastra.uitests.homepagetest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingshastra.config.BaseClass;
import com.testingshastra.keywords.UIKeyWords;
import com.testingshastra.pages.HomePage;

@Test
public class HomePageTests extends BaseClass {
	HomePage home = new HomePage();
	UIKeyWords keywords = UIKeyWords.getInstance();
	String expectedTitle = "IJmeet";

	public void verifyTitleOfHomePage() {
		// keywords.launchUrl("https://www.testingshastra.com");
		String title = keywords.getTitle();
		Assert.assertEquals(title, expectedTitle);

	}

	public void validateAllLinksOfHomepage() throws IOException { // verify broken links
		List<WebElement> links = home.getAllLinks();
		Iterator<WebElement> itr = links.iterator();
		while (itr.hasNext()) {
			String url = itr.next().getAttribute("href");
			try {
			HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			int code = con.getResponseCode();
			System.out.println("url: "+url+" status code: "+code);
			if (code >= 400) {
				System.out.println("Links is broken " + url);
			}
			}catch(MalformedURLException e){
				System.out.println("Url "+url);
			}
		}

	}
}
