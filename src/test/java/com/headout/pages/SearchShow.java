package com.headout.pages;

import org.testng.annotations.Test;

public class SearchShow {
	
	@Test
	public void searchShow() {
		HomePage home = new HomePage();
		home.searchForShowAndBook("The Simon and Garfunkel Story ");
	}
}
