package com.planet.qa.manager;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


//import org.apache.log4j.PropertyConfigurator;


	
public class demo {
	

public static Logger log = Logger.getLogger(demo.class);


	public static void main(String[] args) {
		PropertyConfigurator.configure("./src/test/resources/properties/log4j2.properties");
		// TODO Auto-generated method stub
		log.info("this is infor Message");
		log.fatal("this is infor Message");
		log.error("this is infor Message");
		log.warn("this is infor Message");
		
		
	}

}
