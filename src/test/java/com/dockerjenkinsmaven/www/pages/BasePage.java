package com.dockerjenkinsmaven.www.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {
	public static WebDriver driver;
	
	public static Properties prop;
	
	
	public BasePage() {
		prop=new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream("config.properties");
			prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public static WebDriver initializeBrowser() {
		String browser= prop.getProperty("broswer");
		String OSName=System.getProperty("os.name");
		String OSversion=System.getProperty("os.version");
		System.out.print(OSName);
		ChromeOptions opts=new ChromeOptions();
		
		if(browser.equalsIgnoreCase("chrome")||browser.equalsIgnoreCase("ch")) {
			
			if(OSName.contains("Windows")) {
				System.setProperty("webdriver.chrome.driver","C:\\Seleniumdrivers\\chromedriver.exe");
//				or
//				System.setProperty("webdriver.chrome.driver","/src/test/resources/drivers/chromedriver.exe");

			}
			
			
			if(OSName.contains("Mac")) {
				System.setProperty("webdriver.chrome.driver","Macintosh\\Users\\metootopa\\Downloads\\chromedriver");
//				or
//				System.setProperty("webdriver.chrome.driver","/src/test/resources/drivers/chromedriver");
			}
			
			
			if(OSName.contains("Linux")) {
				System.setProperty("webdriver.chrome.driver","/usr/bin/chrome/chromedriver");
				System.out.println("Log: LINUX HEADLESS EXECUTION");
				opts.addArguments("--headless");
//				opts.setHeadless(true);
			}
			
			
			opts.addArguments("--start-maximized");
			opts.addArguments("--disable-geolocation");
			opts.addArguments("--incognito");
			opts.addArguments("--disable-gpu");
			opts.addArguments("--enable-strict-powerful-feature-restriction");
			opts.addArguments("--no-sandbox");
			opts.setAcceptInsecureCerts(true);
			opts.setCapability("acceptSslCert", true);
			opts.addArguments("disable-blink-features=automationControlled");
			opts.addArguments("--verbose");
//			opts.addArguments("--headless");

		
			driver= new ChromeDriver(opts);
			
		}
		
		
		else if(browser.equalsIgnoreCase("frirefox")) {
			System.setProperty("webdriver.firefox.marionette","Macintosh\\Users\\metootopa\\Downloads\\geckodriver.tar");

			driver= new FirefoxDriver();
		}
		
		
		return driver;
		
	}

}
