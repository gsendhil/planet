package com.planet.qa.cucumber.steps;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.planet.qa.TestBase.TestContext;
import com.planet.qa.manager.ExtentTestManager;
import com.planet.qa.pages.CheckoutPage;
import com.planet.qa.pages.ProductsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutPageStep {

	public TestContext testContext;
	public CheckoutPage checkoutPage;
	public ProductsPage ProductsPage;

	public CheckoutPageStep(TestContext context) {
		testContext = context;
		checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
		ProductsPage = testContext.getPageObjectManager().getProductsPage();
	}

	@When("^user clicks on checkout$")
	public void user_clicks_on_checkout() throws Throwable {
		ExtentTest step = ExtentTestManager.getExtScenario().createNode(new GherkinKeyword("When"),
				"user clicks on checkout");
		ExtentTestManager.setExtStep(step);
		checkoutPage.clickoncheckout();
	}

	@And("^provides the user details and cliks on continue$")
	public void provides_the_user_details_and_cliks_on_continue() throws Throwable {

		ExtentTest step = ExtentTestManager.getExtScenario().createNode(new GherkinKeyword("When"),
				"provides the user details and clicks on continue");
		ExtentTestManager.setExtStep(step);
		checkoutPage.entercheckoutdetails();
	}
	
	
	@Then("^verify \"([^\"]*)\" is present in checkout overview$")
	public void verify_something_is_present_in_checkout_overview(String productname) throws Throwable {
		ExtentTest step = ExtentTestManager.getExtScenario().createNode(new GherkinKeyword("When"),
				"verify the product is available in checkout overview");
		ExtentTestManager.setExtStep(step);
		ProductsPage.verifyitemincart(productname);
	}
	
	

	@And("^user clicks on finish$")
	public void user_clicks_on_finish() throws Throwable {
		ExtentTest step = ExtentTestManager.getExtScenario().createNode(new GherkinKeyword("When"),
				"click on finish");
		ExtentTestManager.setExtStep(step);
		checkoutPage.clickonfinish();
	}

	@Then("^verify the order confirmation \"([^\"]*)\"$")
	public void verify_the_order_confirmation_something(String message) throws Throwable {
		ExtentTest step = ExtentTestManager.getExtScenario().createNode(new GherkinKeyword("When"),
				"verify the order confirmation");
		ExtentTestManager.setExtStep(step);
		checkoutPage.orderconfirmation(message);
	}

}