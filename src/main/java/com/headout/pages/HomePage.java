package com.headout.pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.headout.utils.ConfigFileReader;
import com.headout.utils.TimeOuts;

public class HomePage {
	TimeOuts timeOut = new TimeOuts();
	
	public static WebDriver driver;
	ConfigFileReader reader = new ConfigFileReader();
	public static String url;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void searchForShowAndBook(String showName) {

		WebElement searchBox = driver.findElement(By.xpath(reader.getSearchBox()));

		searchBox.sendKeys(showName + Keys.ENTER);

		timeOut.sleep();
		
		Set<String> beforePopup = driver.getWindowHandles();
		
		WebElement book = driver.findElement(By.partialLinkText("BOOK NOW"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		book.click();
		
		Set<String> afterPopup = driver.getWindowHandles();
		afterPopup.removeAll(beforePopup);
		if (afterPopup.size() == 1) {
			driver.switchTo().window((String) afterPopup.toArray()[0]);
		}
		url = driver.getCurrentUrl();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
}
