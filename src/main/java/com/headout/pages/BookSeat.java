package com.headout.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.headout.utils.ConfigFileReader;
import com.headout.utils.TimeOuts;

public class BookSeat {
	WebDriver driver;
	ConfigFileReader fileReader = new ConfigFileReader();
	TimeOuts timeOut = new TimeOuts();
	
	public BookSeat(WebDriver driver){
		this.driver = driver;
	}
	
	public void bookSeat() {	
		timeOut.sleep();
		WebElement e = driver.findElement(By.xpath("//iframe[@marginheight='0']"));
		driver.switchTo().frame(e);
		driver.findElement(By.xpath("//*[name()='svg']//*[name()='circle' and @id='SE-STALLS-R-11']")).click();
		timeOut.sleep();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//div[@class='next-button selectable']")).click();
		timeOut.sleep();
	}
}
