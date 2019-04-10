package com.headout.pages;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.headout.utils.ConfigFileReader;
import com.headout.utils.TimeOuts;

public class DatePicker {
	TimeOuts timeOut = new TimeOuts();
	ConfigFileReader fileReader = new ConfigFileReader();
	WebDriver driver;
	String month;
	String year;
	String day;

	public static String datePageUrl;

	public DatePicker(WebDriver webDriver) {
		this.driver = webDriver;
	}

	public String pickDate(String date) {

		String[] dateArr = parseDate(date);
		String monthAndYear = dateArr[1] + " " + dateArr[2];

		List<WebElement> elements = driver.findElements(By.className("month-title"));
		timeOut.sleep();

		// Block to get calendar
		for (WebElement e : elements) {
			WebElement span = e.findElement(By.tagName("span"));
			String monthFromSpanTag = span.getText();
			if (monthFromSpanTag.equalsIgnoreCase(monthAndYear)) {

				WebElement day = e.findElement(By.xpath("//div[contains(@class,'date-big-wrapper  ')]"));
				WebElement daySpan = day.findElement(By.tagName("span"));

				String dayFromSpan = daySpan.getText();
				if (dayFromSpan.equals(dateArr[0])) {

					timeOut.sleep();
//					Set<String> beforePopup = driver.getWindowHandles();

					day.click();

//					Set<String> afterPopup = driver.getWindowHandles();
//					try {
//						Thread.sleep(2500);
//					} catch (InterruptedException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
////					afterPopup.removeAll(beforePopup);
//					if (afterPopup.size() == 1) {
//						driver.switchTo().window((String) afterPopup.toArray()[0]);
//
//					}
					DatePicker.datePageUrl = driver.getCurrentUrl(); // URL for the next page to book seat

					timeOut.implicitWait(driver);

				}
			}
		}
		System.out.println("This URL " + DatePicker.datePageUrl);
		return DatePicker.datePageUrl;
	}

	private String[] parseDate(String date) {
		String[] dateArr = date.split("-");
		day = dateArr[0];
		month = dateArr[1];
		year = dateArr[2];
		return dateArr;
	}
}
