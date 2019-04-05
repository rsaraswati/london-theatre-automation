package com.headout.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = "configs//Configuration.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
//				reader.close();
//				System.out.println(properties.getProperty("searchBox"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found at : " + propertyFilePath + "Reason is : " + e.getMessage());
		}
	}
	
	public String getSearchBox() {
		String searchBox = properties.getProperty("searchBox");
//		System.out.println(properties.getProperty("searchBox"));
		if(searchBox != null) 
			return searchBox;
		else throw new RuntimeException("Search Box not found !");	
	}
	
	public String getShowName() {
		String showName = properties.getProperty("showName");
		if(showName != null) 
			return showName;
		else throw new RuntimeException("Show not available !");		
	}
	
	public String bookShow() {
		String bookButton = properties.getProperty("bookButton");
		if(bookButton != null) 
			return bookButton;
		else throw new RuntimeException("Sorry, can't book !");		
	}
}
