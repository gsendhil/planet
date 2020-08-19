package com.planet.qa.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.planet.qa.TestBase.TestSetup;
import com.planet.qa.manager.DriverManager;
import com.planet.qa.manager.ExtentTestManager;
import com.planet.qa.manager.FileReaderManager;



public class TestUtils extends TestSetup {
	
	//Wrapper method for verifying the element is present
	public static boolean iselementpresent (WebElement element, String locatorName) {
		boolean flag = false;
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 8);
		wait.until(ExpectedConditions.visibilityOf(element));
		try {
			if (element.isDisplayed()) {
				FileReaderManager.getlog().info(element + "The Element has display Successfully");
				flag = true;
			}
		} catch (NoSuchElementException ex) {
			FileReaderManager.getlog().info( "Verifing displayed element failed with exception"  + ex.getMessage());
		}
		return flag;
	}
	
	//Wrapper method Clicking a Button
	public static void click (WebElement element, String locatorName ) throws IOException {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),8);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		try {
			if (element.isDisplayed()) {
				element.click();
				FileReaderManager.getlog().info(locatorName + "The element has been clicked Successfully");
			}
			} catch (Exception ex) {
				FileReaderManager.getlog().info(locatorName + "The element is not accessible " + ex.getMessage());
			}
		}
	
	//Wrapper method for typing in a value to a exit box
	public static void type (WebElement element, String locatorName, String locatorValue) throws Exception {
		WebDriverWait wait = new WebDriverWait (DriverManager.getDriver(),8);
		
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			if (element.isEnabled()) {
				element.sendKeys(locatorValue);
				FileReaderManager.getlog().info(locatorName + "The value entered successfully");
				ExtentTestManager.getExtStep().pass(locatorName + " is Displayed " + " and the value { " + locatorValue + " } entered Successfully");
			}
		} catch (Exception ex) {
			FileReaderManager.getlog().info(locatorName + " The field does not exist" + ex.getMessage());
			ExtentTestManager.getExtStep().fail(ex.getMessage());
			}
		}
	
	
	
	
	public static String  getCurrentDate() {
		Date d = new Date();
		return System.setProperty("current.date", d.toString().replace(":", "_").replace(" ", "_"));
		

	}
	
		
	public static String screenshotPath;
	public static String screenshotName;
	static int i = 0;

	public static void captureScreenshot() {
		i = i + 1;
		File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + "_" + i + ".png";

		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/ExtentReports/" + screenshotName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	


}
