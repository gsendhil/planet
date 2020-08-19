package com.planet.qa.manager;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import com.aventstack.extentreports.MediaEntityBuilder;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Feature;


/*getter setters and thread safe methods for Extent reporting.
Reporting is done at Cucumber Feature / Scenario / Step  levels*/

public class ExtentTestManager {
	private static ThreadLocal<ExtentTest> extentTestFeature = new ThreadLocal<ExtentTest>();
	
	private static ThreadLocal<ExtentTest> extentTestScenarioDef  = new ThreadLocal<ExtentTest>();
	
	private static ThreadLocal<ExtentTest> extentTestStep = new ThreadLocal<ExtentTest>();
	
	//This is for creating an integration for counter
	public static ThreadLocal<Integer> counter = new ThreadLocal<>();
		
	public static ExtentReports extentReport = ExtentManager.getReporter();
	
	private static SoftAssert softAssert = new SoftAssert();
	
	public static int getCounter() {
		return counter.get();
	}
	
	public static void setCounter (int i) {
		counter.set(i);
	}
	
	public static SoftAssert getAssert() {
		return softAssert;
	}
	
	private static boolean failedScenarioFlag;
	
	//Scenario failed status getter setter
	
	public static void setScenarioStatus (boolean flag) {
		failedScenarioFlag = flag;
	}
	
	public static boolean getScenarioStatus() {
		return failedScenarioFlag;
	}
	
	//Feature Getter Setter
	
	public static void setExtFeature (ExtentTest test) {
		extentTestFeature.set(test);
	}
	
	public static ExtentTest getExtFeature () {
		return extentTestFeature.get();
	}
	
	
	//Scenario Getter Setter
	
	public static void setExtScenario (ExtentTest test) {
		extentTestScenarioDef.set(test);
		
	}
	
	public static ExtentTest getExtScenario () {
		return extentTestScenarioDef.get();
	}
	
	//Step Getter Setter
	
	public static void setExtStep (ExtentTest test) {
		extentTestStep.set(test);
	}
	
	public static ExtentTest getExtStep() {
		return extentTestStep.get();
	}
	
	//Log Status Reporting
	
	public static void loginfo (String message) {
		getExtStep().log(Status.INFO, message);
	}
	
	public static void logpass(String message) {
		getExtStep().log(Status.PASS, message);
	}
	
	public static void logFail (String message ) {
		getExtStep().log(Status.FAIL, message);
	}
		
	
	public static synchronized ExtentTest startTest(String testName) {
		ExtentTest extentTest = extentReport.createTest(Feature.class, testName);
		setExtFeature(extentTest);
		return extentTest;
	}

}
