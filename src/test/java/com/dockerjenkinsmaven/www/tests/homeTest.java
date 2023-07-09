package com.dockerjenkinsmaven.www.tests;

import org.junit.After;
import org.junit.Before;
import org.testng.annotations.Test;

import com.dockerjenkinsmaven.www.pages.BasePage;


public class homeTest extends BasePage {
	
	
	@Before
	public void initialize() {
		initializeBrowser();
	}
	
	
	@Test
	public void testmethod() {
		String baseURL="http://www.facebook.com";
		driver.get(baseURL);
		
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
