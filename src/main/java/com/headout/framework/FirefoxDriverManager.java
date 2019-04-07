package com.headout.framework;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {

	@Override
	protected void createDriver() {
		this.driver = new FirefoxDriver();
	}
}
