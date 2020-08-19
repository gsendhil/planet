package com.planet.qa.manager;

import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



//getReporter method is called to return singleton ExtentReports class.
//Whole test execution will use the same extent report to log the test results.
  
public class ExtentManager {
 
	static ExtentReports extent;
    static Date d = new Date();
	static String fileName = "Extent_Planet_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
    
    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
        	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReports/"+fileName);	  
 	        htmlReporter.config().setTheme(Theme.STANDARD);
 	        htmlReporter.config().setDocumentTitle(fileName);
 	        htmlReporter.config().setEncoding("utf-8");
 	        htmlReporter.config().setReportName(fileName);
 	        
 	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Automation Tester", "QA Team");
	        extent.setSystemInfo("Department", "QA");
	        extent.setSystemInfo("UI Version no", "SPRINT1");
	        extent.setSystemInfo("Server Version no", "SPRINT2");
        }
        return extent;
    }

	}

