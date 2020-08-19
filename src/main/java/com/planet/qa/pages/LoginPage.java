package com.planet.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
import org.testng.Assert;

import com.planet.qa.manager.ExtentTestManager;
import com.planet.qa.util.TestUtils;

public class LoginPage {

	@FindBy(xpath = "//div[@class='login_logo']")
	WebElement saucelogo;

	@FindBy(id = "user-name")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "login-button")
	WebElement Login;

	@FindBy(xpath = "//div[@class='product_label']")
	WebElement productlabel;

	@FindBy(xpath = "//h3")
	WebElement loginerror;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void homepagevalidation() {
		TestUtils.iselementpresent(saucelogo, "Sauce Logo");
	}

	public void enterlogindetails(String str_username, String str_password) throws Exception {
		TestUtils.type(username, "user name", str_username);
		TestUtils.type(password, "Password", str_password);
	}

	public void clickonSignin() throws Exception {

		TestUtils.click(Login, "Login");
	}

	public void verifyLoginSuccess() {
		TestUtils.iselementpresent(productlabel, "Products");

		if (productlabel.getText().trim().equalsIgnoreCase("Products")) {
			ExtentTestManager.logpass("Login Successful & Product Page displayed");
		} else {
			ExtentTestManager.logFail("Login unsuccessful");

		}

		Assert.assertEquals(productlabel.getText().trim(), "Products");

	}

	public boolean verifyLoginUnSuccess() {
		TestUtils.iselementpresent(loginerror, "Login error");
		if (loginerror.getText().trim().contains("this user has been locked out")) {
			ExtentTestManager.logpass("Validation error displayed, Invalid User cannot login");
			return true;
		} else {
			ExtentTestManager.logFail("Login Validation error not displayed");
			return false;
		}

	}

}
