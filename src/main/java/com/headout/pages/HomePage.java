package com.headout.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.headout.utils.ConfigFileReader;
import com.headout.utils.Helper;

public class HomePage{
	
	public static WebDriver driver;
	 ConfigFileReader reader = new ConfigFileReader();
	
	public void searchForShowAndBook(String showName) {
		
		WebElement searchBox = driver.findElement(By.xpath(reader.getSearchBox()));
		
		searchBox.sendKeys(showName + Keys.ENTER);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
//		Helper helper = new Helper();
//		helper.checkVisibilityOfLocatedElement(reader.bookShow());
//		WebElement element = wait.until(
//		        ExpectedConditions.visibilityOfElementLocated(driver.findElement(By.linkText(reader.bookShow()))));
//		WebElement element = driver.findElement(By.cssSelector(reader.bookShow()));
//		element.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			System.out.println("Time out "+ e1.getMessage());
			e1.printStackTrace();
		}
		WebElement book = driver.findElement(By.partialLinkText("BOOK NOW"));
		book.click();
	}
	
	public void setDriver(WebDriver driver) {
		
		HomePage.driver = driver;
	}
}
