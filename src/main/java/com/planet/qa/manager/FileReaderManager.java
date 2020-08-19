package com.planet.qa.manager;

import java.util.Properties;
import org.apache.log4j.Logger;
import com.applitools.eyes.FileLogger;
import com.applitools.eyes.StdoutLogHandler;
import com.applitools.eyes.selenium.Eyes;
import com.planet.qa.TestBase.TestSetup;

public class FileReaderManager {
	
	public static String userDirectory = System.getProperty("user.dir");
	public static Properties prop;
	public static Logger log;
	public static Eyes eyes;
		
		
	public static Properties getprop() {
		return prop;
	}
	
	public static void setprop() {
		prop = new Properties();
	}
	
	
	public static Logger getlog() {
		return log;
	}
	
	public static void setlog() {
		log = Logger.getLogger(TestSetup.class);
	}
	
	public static void initiateeyes() {
		eyes = new Eyes();
		eyes.setApiKey("test");
		eyes.setApiKey(getprop().getProperty("applitools.api.key"));
		//https://help.applitools.com/hc/en-us/articles/360006914932-How-can-I-enable-Applitools-Eyes-SDK-traces-logs-
		//the below statement is to write logs to console
		eyes.setLogHandler(new StdoutLogHandler(true));
		//The below statement is for writing logs to file
		eyes.setLogHandler(new FileLogger(userDirectory + getprop().getProperty("APPLITOOLS_LOGPATH"), true, true));
	}
	
	public static Eyes eyes() {
		return eyes;	
	}
	
		
	public static void closeEyes() {
		eyes.close();
		
	}
	
	public static void eyesAbort() {
		eyes.abort();
	}
	
	
	
	
	
	

}
