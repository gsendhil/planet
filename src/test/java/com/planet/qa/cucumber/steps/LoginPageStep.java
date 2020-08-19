package com.planet.qa.cucumber.steps;

import java.util.List;
import java.util.Map;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.planet.qa.TestBase.TestContext;
import com.planet.qa.manager.ExtentTestManager;
import com.planet.qa.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStep {
	public TestContext testContext;
	public LoginPage loginpage;

	public LoginPageStep(TestContext context) {
		testContext = context;
		loginpage = testContext.getPageObjectManager().getLoginPage();
	}
	
	@Given("^User logged in as a valid user and in product page$")
	public void user_logged_in_as_a_valid_user_and_in_product_page(DataTable dataTable) throws Exception {
		ExtentTest step = ExtentTestManager.getExtScenario().createNode(new GherkinKeyword("Given"),
				"User logged in as a valid user and in product page");
		ExtentTestManager.setExtStep(step);
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		String userName = (String)data.get(0).get("userid");
		String password= (String)data.get(0).get("password");
		loginpage.enterlogindetails(userName, password);
		loginpage.clickonSignin();
	}
	

	@Given("^the user is on saucedemo site$")
	public void the_user_is_on_saucedemo_site() throws Exception {
		ExtentTest step = ExtentTestManager.getExtScenario().createNode(new GherkinKeyword("Given"),
				"the user is on sauce demo login page");
		ExtentTestManager.setExtStep(step);
		loginpage.homepagevalidation();

	}

	@When("^the use enters valid login details email \"([^\"]*)\" and password \"([^\"]*)\" fields$")
	public void the_use_enters_valid_login_details_email_something_and_password_something_fields(String str_username,
			String str_password) throws Exception {
		ExtentTest step = ExtentTestManager.getExtScenario().createNode(new GherkinKeyword("When"),
				"the user enters valid login details email and password");
		ExtentTestManager.setExtStep(step);
		
		loginpage.enterlogindetails(str_username, str_password);
	}

	@And("clicks on the login button")
	public void clicks_on_the_login_button() throws Exception {
		ExtentTest step = ExtentTestManager.getExtScenario().createNode(new GherkinKeyword("And"),
				"clicks on the login button");
		ExtentTestManager.setExtStep(step);
		loginpage.clickonSignin();
	}

	@Then("verify the account page is displayed")
	public void verify_the_account_page_is_displayed() throws Exception {
		ExtentTest step = ExtentTestManager.getExtScenario().createNode(new GherkinKeyword("Then"),
				"clicks on the login button");
		ExtentTestManager.setExtStep(step);
		loginpage.verifyLoginSuccess();
	}
	
	@Then("^verify login error is displayed$")
    public void verify_login_error_is_displayed() throws Exception {
		ExtentTest step = ExtentTestManager.getExtScenario().createNode(new GherkinKeyword("Then"),
				"verify login error is displayed");
		ExtentTestManager.setExtStep(step);
		boolean flag = loginpage.verifyLoginUnSuccess();
		ExtentTestManager.getAssert().assertEquals(flag, true);
		
        
		
    }
	

}
