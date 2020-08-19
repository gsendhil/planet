package com.planet.qa.pages;


import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.planet.qa.manager.ExtentTestManager;
import com.planet.qa.util.TestUtils;

public class CheckoutPage {
	
	@FindBy(xpath="//a[@class='btn_action checkout_button']")
	WebElement checkout;
	
	@FindBy(xpath="//input[@id='first-name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='last-name']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@id='postal-code']")
	WebElement zipcode;
	
	@FindBy(xpath="//input[@value='CONTINUE']")
	WebElement continue_btn;
	
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	List<WebElement> productList;
	
	
	
	@FindBy(xpath="//a[@class='btn_action cart_button']")
	WebElement finish;
	
	@FindBy(xpath="//h2[text()='THANK YOU FOR YOUR ORDER']")
	WebElement orderconfirmation;
				
		
	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickoncheckout() throws Exception {
		TestUtils.click(checkout, "checkout");
		
		
	}
	
	public void clickonfinish() throws Exception {
		TestUtils.click(finish, "Finish");
	}
	
	public void entercheckoutdetails() throws Exception {
		TestUtils.type(firstname, "First Name", "John");
		TestUtils.type(lastname, "Last Name", "Smith");
		TestUtils.type(zipcode, "Zipcode", "07001");
		TestUtils.click(continue_btn, "continue button");
	}
	
	public void orderconfirmation(String confirmationmessage) {
		
		if (orderconfirmation.getText().equalsIgnoreCase(confirmationmessage)) {
			ExtentTestManager.logpass("The confirmation message { " + confirmationmessage + " is displayed successfully");
		} else {
			ExtentTestManager.logFail("The confirmation message { " + confirmationmessage + " is not displayed");
		}
		
		
	}
	
	
	
	

}
