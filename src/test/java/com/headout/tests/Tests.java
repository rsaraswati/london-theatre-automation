package com.headout.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.headout.framework.DriverManager;
import com.headout.framework.DriverManagerFactory;
import com.headout.framework.DriverType;
import com.headout.pages.DatePicker;
import com.headout.pages.HomePage;
import com.headout.utils.ConfigFileReader;

public class Tests {
	DriverManager driverManager;
	WebDriver webDriver;
	HomePage homePage;
	DatePicker datePicker;
	ConfigFileReader fileReader = new ConfigFileReader();
	
	protected final static String APP_URL = "https://www.london-theater-tickets.com/";

	@BeforeClass
	public void setUp() {
		driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
		webDriver = driverManager.getWebDriver();
		webDriver.get(APP_URL);
	}

	@Test
	public void navigateToLondonTheatre() {
		String showName = fileReader.getShowName();
		homePage = new HomePage(webDriver);
		if (showName.equals(null) || showName.equals(' ')) {
			Assert.fail("Did not enter show name !");
		} else {
			homePage.searchForShowAndBook(showName);
		}
	}
	@Test
	public void pickDate() {
		datePicker = new DatePicker(webDriver);
		String date = fileReader.getDate();
		if (date.equals(null) || date.equals(' ')) {
			Assert.fail("Did not enter date !");
		} else {
			datePicker.pickDate(date);
		}
	}
	
	@AfterClass
	public void tearDown() {
		driverManager.quitDriver();
	}
}
