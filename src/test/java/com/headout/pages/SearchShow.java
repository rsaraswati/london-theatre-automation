package com.headout.pages;

import org.testng.annotations.Test;

import com.headout.base.BaseTest;
import com.headout.utils.ConfigFileReader;

public class SearchShow extends BaseTest{
	
	@Test
	public void searchShow() {
		HomePage home = new HomePage();
		
		ConfigFileReader reader = new ConfigFileReader();
		String showName = reader.getShowName();
		home.searchForShowAndBook(showName);
	}
}
