package com.testingshastra.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains UI keywords which are applicable for WebElements and
 * general actions. This is a singleton class. To create object of this class,
 * use {@code getInstance()} method
 * 
 * @author swatisonawane
 *
 */
public class UIKeyWords {
	public RemoteWebDriver driver = null;
	private static UIKeyWords uikeywords;
	static {
		uikeywords = new UIKeyWords();
	}

	public static UIKeyWords getInstance() {
		return uikeywords;

	}

	private UIKeyWords() {

	}

	/**
	 * This keyword is used to launch a specific browser.
	 * 
	 * @author swatisonawane
	 * @param browserName must be one of the following
	 *                    <ul>
	 *                    <li>chrome</li>
	 *                    <li>ie</li>
	 *                    <li>edge</li>
	 *                    </ul>
	 */

	public void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

		} else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else
			System.err.print("Invalid browser name: " + browserName);

	}

	public void close() {
		driver.close();

	}

	public void quite() {
		driver.quit();

	}

	public void launchUrl(String url) {
		driver.get(url);

	}

	public void click(WebElement element) {
		element.click();

	}

	public void enterText(WebElement element, String textToEnter) {
		element.sendKeys(textToEnter);

	}
	
    @Deprecated
	public void enterText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);

	}

	public void enterText(String object, String textToEnter) {
		String[] parts = object.split("##");
		getWebElement(parts[0], parts[1]).sendKeys(textToEnter);

	}

	public WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement element = null;
		if (locatorType.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			element = driver.findElement(By.cssSelector(locatorValue));
		} else if (locatorType.equalsIgnoreCase("class")) {
			element = driver.findElement(By.className(locatorValue));
		} else if (locatorType.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(locatorValue));
		}
		return element;

	}

	public void switchToFrameAt(int index) {
		driver.switchTo().frame(index);

	}

	public void switchToFrameAt(String idOrName) {
		driver.switchTo().frame(idOrName);

	}

	public void switchToFrameAt(WebElement frame) {
		driver.switchTo().frame(frame);

	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();

	}

	public String getTitle() {
		return driver.getTitle();

	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();

	}

	public RemoteWebDriver getDriver() {
		return driver;
	}

	public void click(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();

	}

}
