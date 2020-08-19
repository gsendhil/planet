package com.planet.qa.cucumber.steps;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.planet.qa.TestBase.TestContext;
import com.planet.qa.manager.ExtentTestManager;
import com.planet.qa.pages.ProductsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductsPageStep {
	public TestContext testContext;
	public ProductsPage ProductsPage;

	public ProductsPageStep(TestContext context) {
		testContext = context;
		ProductsPage = testContext.getPageObjectManager().getProductsPage();
	}

	@When("^User click the add button to add the product  \"([^\"]*)\" to cart$")
    public void user_click_the_add_button_to_add_the_product_something_to_cart(String productname) throws Throwable {
		ExtentTest step = ExtentTestManager.getExtScenario().createNode(new GherkinKeyword("When"),
				"user_finds_something_in_product_page and click on add to cart");
		ExtentTestManager.setExtStep(step);
		ProductsPage.findproductitem(productname);

	}

	@And("^clicks on cart$")
	public void clicks_on_cart() throws Exception {
		ExtentTest step = ExtentTestManager.getExtScenario().createNode(new GherkinKeyword("And"), "clicks on cart");
		ExtentTestManager.setExtStep(step);
		ProductsPage.clickcart();
	}

	  @Then("^verify \"([^\"]*)\" is present in the cart$")
	    public void verify_something_is_present_in_the_cart(String productname) throws Throwable {
		ExtentTest step = ExtentTestManager.getExtScenario().createNode(new GherkinKeyword("Then"),
				"verify the product is presetn in cart");
		ExtentTestManager.setExtStep(step);
		ProductsPage.verifyitemincart(productname);

	}

	
	  @And("^user click ons remove button to remove the product \"([^\"]*)\" from cart$")
	    public void user_click_ons_remove_button_to_remove_the_product_something_from_cart(String productname) throws Throwable {
		ExtentTest step = ExtentTestManager.getExtScenario().createNode(new GherkinKeyword("And"),
				"user selects the product and clicks remove");
		ExtentTestManager.setExtStep(step);
		ProductsPage.removeitemfromcart(productname);

	}
	
	@Then("^verify \"([^\"]*)\" is removed from cart$")
	public void verify_something_is_removed_from_cart(String productname) throws Throwable {
		ExtentTest step = ExtentTestManager.getExtScenario().createNode(new GherkinKeyword("And"),
				"verify the product is removed from cart");
		ExtentTestManager.setExtStep(step);
		ProductsPage.verifyitemremoved(productname);
		
		

	}
	
	

}
