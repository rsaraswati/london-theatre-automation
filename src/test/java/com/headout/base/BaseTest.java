package com.headout.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.headout.pages.HomePage;

public class BaseTest {

	private WebDriver webDriver;
	private static BaseTest baseTest;
	protected static HomePage homePage;
	private final String APP_URL = "https://www.london-theater-tickets.com/";

	public BaseTest() {
		this(false);
	}

	public BaseTest(boolean b) {
		if (b) {
			setChromeDriverProperty();
			webDriver = new ChromeDriver();
			webDriver.get(APP_URL);
			homePage = new HomePage();
			homePage.setDriver(webDriver);
		}
	}

	@BeforeClass
	public static void launchApplication() {
		baseTest = new BaseTest(true);
	}

	@AfterClass
	public static void closeBrowser() {
		baseTest.webDriver.close();
	}

	private void setChromeDriverProperty() {
		System.setProperty("webdriver.chrome.driver", "/Users/rumela/Downloads/chromedriver");

	}

}
