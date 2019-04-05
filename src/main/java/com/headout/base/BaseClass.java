package com.headout.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.headout.pages.HomePage;

public class BaseClass {

	protected static WebDriver driver;
	protected static HomePage homePage;
	protected final static String APP_URL = "https://www.london-theater-tickets.com/";

	@BeforeClass
	public static void launchApplication() {
		setChromeDriverProperty();
		driver = new ChromeDriver();
		driver.get(APP_URL);
		homePage = new HomePage();
		homePage.setDriver(driver);
	}

	private static void setChromeDriverProperty() {
		System.setProperty("webdriver.chrome.driver", "/Users/rumela/Downloads/chromedriver");
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();

		if (driver != null) {
			driver.quit();
		}
	}
}
