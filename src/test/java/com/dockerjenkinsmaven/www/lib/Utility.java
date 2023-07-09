package com.dockerjenkinsmaven.www.lib;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.dockerjenkinsmaven.www.pages.BasePage;

public class Utility extends BasePage {
	
	
	
	
	
	public static void openNewAndSwitchTotheWindow() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.open()");
		Set<String> windows=driver.getWindowHandles();
		for(String window : windows) {
			driver.switchTo().window(window);
			if(driver.getTitle().contains("title")) {break;}
		}
	}
	
	
	public static void switchToExistingWindow(String title) {
		if(title.equalsIgnoreCase("outlook")) {title="Mail-outlook";}
		if(title.equalsIgnoreCase("gmail")) {title="Mail-gmail";}
		else {title.equalsIgnoreCase(title);}
		Set<String> windows=driver.getWindowHandles();
		for(String window : windows) {
			driver.switchTo().window(window);
			if(driver.getTitle().contains(title)) {break;}
		}
	}
	
	
	
	public static void scrollToTop() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)","");
	}
	
	
	public static void scrollTomiddle() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300");
	}
	
	
	public static void scrollToBottom() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)","");
	}
	
	
	public static void robotFileUpload(WebElement uploadElement) {
		uploadElement.click();
		
		File file=new File("src/test/resources/testData/image.jpgsrc/test/resources/testData/image.jpg");
		
		StringSelection ss=new StringSelection(file.getAbsolutePath());
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		
		Robot robot=null;
		try {
			robot=new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		
		
		robot.delay(3000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		
		robot.delay(3000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		robot.delay(3000);
		
		
		
	}
	
	
	
	public static void seleniumSendkeyFileUpload(WebElement uploadElement) {
		File file=new File("src/test/resources/testData/image.jpg");
//		uploadElement.sendKeys(file.getAbsoluteFile());
	}

	
	
	//clear history to do
	
	
	
	
		
}
