package com.planet.qa.TestBase;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.applitools.eyes.BatchInfo;
import com.planet.qa.manager.DriverManager;
import com.planet.qa.manager.FileReaderManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSetup {
	
	public FileInputStream file;
	public static String userDirectory = System.getProperty("user.dir");
	private WebDriver driver;
	//public static Eyes eyes;
		
	//private WebDriver driver;
	public void setUpFramework() throws IOException {
		FileReaderManager.setprop();
		file = null;
		
		try {
		file = new FileInputStream(userDirectory + "\\src\\test\\resources\\properties\\config.properties");
		System.out.println(userDirectory);
		FileReaderManager.getprop().load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				file.close();
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}
				
		System.out.print(userDirectory + FileReaderManager.getprop().getProperty("LOGCONFIG_PATH"));
		FileReaderManager.setlog();
		PropertyConfigurator.configure(userDirectory + FileReaderManager.getprop().getProperty("LOGCONFIG_PATH")) ;
		FileReaderManager.getlog().info("Configuration Properties File Loaded");
		
		
	
	}
	
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//				
//		TestSetup test = new TestSetup();
//		test.setUpFramework();
//				
//
//	}
	
	public void launchBrowser (String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", userDirectory + FileReaderManager.getprop().getProperty("CHROME_DRIVERPATH"));
			WebDriverManager.chromedriver().version(FileReaderManager.getprop().getProperty("BROWSER_CHROMEVERSION")).setup();
			driver = new ChromeDriver();
			FileReaderManager.initiateeyes();
			System.out.println("Launching : " + browserName);
			DriverManager.setDriver(driver);
			driver.manage().window().maximize();
			driver.get(FileReaderManager.getprop().getProperty("APPLICATIONURL"));
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(FileReaderManager.getprop().getProperty("IMPLICITWAIT")),TimeUnit.SECONDS);
			//BatchInfo batch = new BatchInfo("Google Home");
			//eyesValidateWindow("Google","Opening browser",batch);
			//this.quit();					
									
		}
		
	}
	
	public void quit() {
		if (DriverManager.getDriver() !=null) {
			DriverManager.getDriver().quit();
		}
	}
	
	
	public static void eyesValidateWindow(String testName, String testStepName, BatchInfo batch) {
		FileReaderManager.eyes.setBatch(batch);
		FileReaderManager.eyes.setForceFullPageScreenshot(true);
		FileReaderManager.eyes.open(DriverManager.getDriver(), "Planet", testName);
		FileReaderManager.eyes.checkWindow(5000,testStepName);
		FileReaderManager.eyes.close();
		FileReaderManager.eyes.abort();
	}

	public static void eyesValidateElement(WebElement element, String validationMessage, BatchInfo batch  ) {
		FileReaderManager.eyes.setBatch(batch);
		FileReaderManager.eyes.setForceFullPageScreenshot(true);
		FileReaderManager.eyes.checkElement(element, 5, validationMessage);
		FileReaderManager.eyes.close();
				
	}
}
