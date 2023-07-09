package com.dockerjenkinsmaven.www.tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class homeTest {
	
	@Test
	public void testmethod() {
		String baseURL="http://www.facebook.com";
//		System.setProperty("webdriver.firefox.marionette","Macintosh\\Users\\metootopa\\Downloads\\geckodriver.tar");
		System.setProperty("webdriver.firefox.marionette","Macintosh\\Users\\metootopa\\Downloads\\geckodriver.tar");
		WebDriver driver= new FirefoxDriver();
		driver.get(baseURL);
		driver.quit();
	}

}
