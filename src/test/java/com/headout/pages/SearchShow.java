package com.headout.pages;

import org.testng.annotations.Test;

import com.headout.base.BaseTest;
import com.headout.utils.ConfigFileReader;

public class SearchShow extends BaseTest {
	HomePage home = new HomePage();

	@Test
	public void searchShow() {
		ConfigFileReader reader = new ConfigFileReader();
		String showName = reader.getShowName();
		home.searchForShowAndBook(showName);
	}

	@Test
	public void pickDate() {
		
	}
}
