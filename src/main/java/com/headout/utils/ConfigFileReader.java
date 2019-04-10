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
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found at : " + propertyFilePath + "Reason is : " + e.getMessage());
		}
	}
	
	public String getSearchBox() {
		String searchBox = properties.getProperty("searchBox");
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
	
	public String getDate() {
		String date = properties.getProperty("date");
		if(date != null) 
			return date;
		else throw new RuntimeException("Date not available !");	
	}

	public String getMonthAndYear() {
		String monthAndYear = properties.getProperty("monthYear");
		if(monthAndYear != null) 
			return monthAndYear;
		else throw new RuntimeException("Month not available !");
	}
	
	public String getPrice() {
		String price = properties.getProperty("price");
		if(price != null) 
			return price;
		else throw new RuntimeException("Price not available !");
	}
	
	public String getFirstName() {
		String firstName = properties.getProperty("firstName");
		return firstName;
	}
	
	public String getLastName() {
		String lastName = properties.getProperty("lastName");
		return lastName;
	}
	
	public String getEmail() {
		String email = properties.getProperty("email");
		return email;
	}
	
	public String getPhoneNumber() {
		String phone = properties.getProperty("phone");
		return phone;
	}
	
	public String getCardNumber() {
		String cardNumber = properties.getProperty("cardNumber");
		return cardNumber;
	}
	
	public String getExpiry() {
		String expiry = properties.getProperty("expiry");
		return expiry;
	}
	
	public String getCvv() {
		String cvv = properties.getProperty("cvv");
		return cvv;
	}
	
	public String getHolderName() {
		String cardHolderName = properties.getProperty("carholderName");
		return cardHolderName;
	}
}
