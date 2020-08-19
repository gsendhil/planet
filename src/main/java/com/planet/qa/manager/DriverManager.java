package com.planet.qa.manager;
import org.openqa.selenium.WebDriver;

public class DriverManager {
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static ThreadLocal<String> browserName = new ThreadLocal<String>();
	
	//public static WebDriver driver;
	//public static String browser;
		
		
	public static WebDriver getDriver() {
		//return driver;
		return driver.get();
				
	}
	
	public static void setDriver(WebDriver dr)
	{
		//driver = dr;
		driver.set(dr);
				
	}
	public  static String getBrowser() {
		return browserName.get();
	}

	public static void setBrowser(String browser) {
		browserName.set(browser);
	}
	

}
