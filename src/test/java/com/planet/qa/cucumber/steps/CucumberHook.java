package com.planet.qa.cucumber.steps;


import java.io.IOException;

import com.planet.qa.TestBase.TestSetup;
import com.planet.qa.manager.DriverManager;
import com.planet.qa.manager.ExtentTestManager;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHook {
	
	protected Scenario scenario;
	protected String scenarioName;
	
	@Before
	
	public synchronized void before (Scenario scenario) throws IOException {
		
		TestSetup testsetup = new TestSetup();
		testsetup.setUpFramework();
		testsetup.launchBrowser(DriverManager.getBrowser());
		this.scenario = scenario;
		scenarioName=scenario.getName();
		ExtentTestManager.setExtScenario(ExtentTestManager.getExtFeature().createNode(scenarioName));
	}
	
	@After
	
	public void after (Scenario scenario) throws IOException { 
		ExtentTestManager.getAssert().assertAll();
		DriverManager.getDriver().quit();
		
	}

}
