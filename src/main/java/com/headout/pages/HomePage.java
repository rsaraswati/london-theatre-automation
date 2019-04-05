package com.headout.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.headout.base.BaseClass;
import com.headout.utils.ConfigFileReader;

public class HomePage extends BaseClass{
	
	 ConfigFileReader reader = new ConfigFileReader();
	 
	public void searchForShowAndBook(String showName) {
		System.out.println("search box value : "+reader.getSearchBox());
		
		WebElement searchBox = driver.findElement(By.id(reader.getSearchBox()));
		
		searchBox.sendKeys(showName);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		WebElement element = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.linkText(reader.bookShow())));
		
		element.click();
	}
}
