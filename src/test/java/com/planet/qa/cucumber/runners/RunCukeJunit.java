package com.planet.qa.cucumber.runners;

import java.io.IOException;



import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


import com.planet.qa.TestBase.TestSetup;
import com.planet.qa.manager.FileReaderManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import com.cucumber.listener



@RunWith (Cucumber.class)
@CucumberOptions (features= {"src\\test\\resources\\features"},
	glue = {"com.planet.qa.cucumber.steps"},
	monochrome=true,
	tags= {"@smoke"},
    plugin= {"pretty","html:target/cucumber"})

public class RunCukeJunit {
	public static TestSetup testsetup;
	
	
	@BeforeClass
	
	public static void Initialization() throws IOException {
		
		testsetup = new TestSetup();
		testsetup.setUpFramework();
		testsetup.launchBrowser(FileReaderManager.getprop().getProperty("BROWSER_CHROME"));
		
	}
	
	@AfterClass
	
	public static void TearDown() {
		testsetup.quit();
	}
}




