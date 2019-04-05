package com.headout.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	protected WebDriver driver;
	
	@BeforeTest
	public void setDriver() {

		final String CHROME_DRIVER_PATH = "/Users/rumela/Downloads/chromedriver";

		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);

		driver = new ChromeDriver();

		driver.get("https://www.london-theater-tickets.com/");

		driver.manage().window().maximize();

	}

	@AfterClass
	public void killDriver() {

		driver.quit();

		if (driver != null) {
			driver.quit();
		}
	}
}
