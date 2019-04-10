package com.headout.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.headout.utils.ConfigFileReader;
import com.headout.utils.TimeOuts;

public class PaymentPage {
	WebDriver driver;
	TimeOuts timeOut = new TimeOuts();
	ConfigFileReader fileReader = new ConfigFileReader();
	
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterGuestDetails() {
		driver.findElement(By.xpath("//input[@id=' 41630_0_first']")).sendKeys(fileReader.getFirstName());
		driver.findElement(By.xpath("//input[@id=' 41630_0_last']")).sendKeys(fileReader.getLastName());
		driver.findElement(By.xpath(" //input[@id=' 41631_0']")).sendKeys(fileReader.getEmail());
		driver.findElement(By.xpath("//input[@id=' 41631_0_confirm']")).sendKeys(fileReader.getEmail());
		driver.findElement(By.xpath("//input[@id=' 41632_0']")).sendKeys(fileReader.getPhoneNumber());
		timeOut.sleep();
	}
	
	public void enterCardDeatails() {
		driver.findElement(By.xpath("//input[@id='card-number']")).sendKeys(fileReader.getCardNumber());
		driver.findElement(By.xpath("//input[@id='card-expiry']")).sendKeys(fileReader.getExpiry());
		driver.findElement(By.xpath("//input[@id='card-cvv']")).sendKeys(fileReader.getCvv());
		driver.findElement(By.xpath("//input[@id='card-name']")).sendKeys(fileReader.getHolderName());
		timeOut.sleep();
	}
	public void clickNext() {
		driver.findElement(By.xpath("//div[@class='booking-card-bottom']//div[@class='product-checkout-button hero-button']"));
		timeOut.sleep();
	}
}
