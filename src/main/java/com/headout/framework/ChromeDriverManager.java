package com.headout.framework;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager{

	@Override
	protected void createDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/rumela/Downloads/chromedriver");
		this.driver = new ChromeDriver();
	}
}
