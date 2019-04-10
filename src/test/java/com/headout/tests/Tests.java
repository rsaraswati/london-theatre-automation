package com.headout.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.headout.framework.DriverManager;
import com.headout.framework.DriverManagerFactory;
import com.headout.framework.DriverType;
import com.headout.pages.BookSeat;
import com.headout.pages.DatePicker;
import com.headout.pages.HomePage;
import com.headout.pages.PaymentPage;
import com.headout.utils.ConfigFileReader;

public class Tests {
	DriverManager driverManager;
	WebDriver webDriver;
	HomePage homePage;
	DatePicker datePicker;
	BookSeat bookSeat;
	PaymentPage payment;
	String url;
	ConfigFileReader fileReader = new ConfigFileReader();

	protected final static String APP_URL = "https://www.london-theater-tickets.com/";

	@BeforeClass
	public void setUp() {
		driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
		webDriver = driverManager.getWebDriver();
		webDriver.get(APP_URL);
	}

	@Test(priority = 1)
	public void navigateToLondonTheatre() {
		String showName = fileReader.getShowName();
		homePage = new HomePage(webDriver);
		if (showName.equals(null) || showName.equals(' ')) {
			Assert.fail("Did not enter show name !");
		}
		homePage.searchForShowAndBook(showName);
	}

	@Test(priority = 2)
	public void pickDate() {
		datePicker = new DatePicker(webDriver);
		String date = fileReader.getDate();
		if (date.equals(null) || date.equals(' ')) {
			Assert.fail("Did not enter date !");
		}
		datePicker.pickDate(date);
	}

	@Test(priority = 3)
	public void bookSeat() {
		bookSeat = new BookSeat(webDriver);
		bookSeat.bookSeat();

	}

	@Test(priority = 4)
	public void makePayment() {
		payment = new PaymentPage(webDriver);
		payment.enterGuestDetails();
		payment.enterCardDeatails();
		payment.clickNext();
	}

	@AfterClass
	public void tearDown() {
		driverManager.quitDriver();
	}
}
