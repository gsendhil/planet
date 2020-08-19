package com.planet.qa.cucumber.runners;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.planet.qa.manager.DriverManager;
import com.planet.qa.manager.ExtentTestManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(features = { "src\\test\\resources\\features" }, glue = {
		"com.planet.qa.cucumber.steps" }, monochrome = true, tags = {
				"@product" }, plugin = { "pretty", "html:target/cucumber" })

public class RunCuke_LoginValidation extends AbstractTestNGCucumberTests {
	private TestNGCucumberRunner testngCucumberRunner;

	@Parameters("browsername")
	@BeforeTest
	public void InitialSetup(String browser) {
		DriverManager.setBrowser(browser);
		testngCucumberRunner = new TestNGCucumberRunner(this.getClass());
		Object[][] data = testngCucumberRunner.provideScenarios();
		String featureName = data[0][1].toString().replaceAll("^\"|\"$", "");
		ExtentTestManager.startTest(featureName);

	}

}
