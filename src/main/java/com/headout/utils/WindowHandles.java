package com.headout.utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowHandles {
	
	private String url;
	private WebDriver driver;
	private Set<String> beforePopup;
	private Set<String> afterPopup;

	public WindowHandles(WebDriver driver) {
		this.driver = driver;
	}

	public void setBeforePopup() {
		this.beforePopup = driver.getWindowHandles();
	}

	public Set<String> getBeforePopup() {
		return beforePopup;
	}

	public String getAfterPopup() {
		setAfterPopup();
		return url;
	}

	public void setAfterPopup() {
		afterPopup = driver.getWindowHandles();
		afterPopup.removeAll(beforePopup);
		if (afterPopup.size() == 1) {
			driver.switchTo().window((String) afterPopup.toArray()[0]);
			url = driver.getCurrentUrl();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			System.out.println("Time out " + e1.getMessage());
			e1.printStackTrace();
		}
		emptySets();
	}

	private void emptySets() {
		beforePopup = null;
		afterPopup = null;
	}
}
