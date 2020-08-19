package com.planet.qa.cucumber.runners;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.planet.qa.TestBase.TestSetup;
import com.planet.qa.manager.ExtentTestManager;
import com.planet.qa.manager.FileReaderManager;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions (features= {"src\\test\\resources\\features"}, 
	glue = {"com.planet.qa.cucumber.steps"}, 
	monochrome=true,
	tags= {"@smoke"}, 
	plugin= {"pretty","html:target/cucumber"})
public class RunCukeTNG extends AbstractTestNGCucumberTests {
	public TestSetup testsetup;
	private TestNGCucumberRunner testngCucumberRunner;
	
	@BeforeClass
	public  void Initialization() throws IOException {
		//ExtentCucumberFormatter.
		
		testsetup = new TestSetup();
		testsetup.setUpFramework();
		testsetup.launchBrowser(FileReaderManager.getprop().getProperty("BROWSER_CHROME"));
		testngCucumberRunner = new TestNGCucumberRunner(this.getClass());
		Object[][] data = testngCucumberRunner.provideScenarios();
		String featureName =data[0][1].toString().replaceAll("^\"|\"$", "");
		ExtentTestManager.startTest(featureName);
		// ExtentTestManager.setCounter(0);
		 
	}
	
	@AfterClass
	public void TearDown() {
		testsetup.quit();
	}
	
}
