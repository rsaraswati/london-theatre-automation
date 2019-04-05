package com.headout.pages;

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
		
		Helper helper = new Helper();
		helper.checkVisibilityOfLocatedElement(reader.bookShow());
		WebElement element = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.linkText(reader.bookShow())));
		
		element.click();
	}
	
	public void setDriver(WebDriver driver) {
		
		HomePage.driver = driver;
	}
}
