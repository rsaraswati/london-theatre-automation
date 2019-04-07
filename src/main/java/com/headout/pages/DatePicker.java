package com.headout.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.headout.utils.ConfigFileReader;

public class DatePicker {
	WebDriver driver;
	String month;
	String year;
	String day;
	HomePage home = new HomePage();
	ConfigFileReader fileReader = new ConfigFileReader();
	
	public DatePicker(WebDriver webDriver) {
		this.driver = webDriver;
	}

	public void pickDate(String date) {
		home.getCurrentUrl();
		String[] dateArr = parseDate(date);
		String monthAndYear = dateArr[1] + " "	+ dateArr[2];
		
		List<WebElement> elements = driver.findElements(By.className("month-title"));
		
		for(WebElement e : elements ) {
			WebElement span = e.findElement(By.tagName("span"));
			String monthFromSpanTag = span.getText();
			if(monthFromSpanTag.equalsIgnoreCase(monthAndYear)) {
				WebElement day = e.findElement(By.xpath("//div[contains(@class,'date-big-wrapper  ')]"));
				WebElement daySpan = day.findElement(By.tagName("span"));
				String dayFromSpan = daySpan.getText();
				if(dayFromSpan.equals(dateArr[0])) {
					day.click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}			
		}
	}

	private String[] parseDate(String date) {
		String[] dateArr = date.split("-");
		day = dateArr[0];
		month = dateArr[1];
		year = dateArr[2];
		return dateArr;
	}
}
