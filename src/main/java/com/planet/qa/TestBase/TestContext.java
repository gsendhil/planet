package com.planet.qa.TestBase;

import com.planet.qa.manager.DriverManager;
import com.planet.qa.manager.PageObjectManager;

public class TestContext {
	private PageObjectManager pageObjectManager;

	public TestContext() {
		pageObjectManager = new PageObjectManager(DriverManager.getDriver());
	}
	

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
}
