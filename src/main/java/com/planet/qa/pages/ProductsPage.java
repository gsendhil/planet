package com.planet.qa.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.planet.qa.manager.ExtentTestManager;
import com.planet.qa.util.TestUtils;

public class ProductsPage {

	@FindBy(xpath = "//div[@class='inventory_item_name']")
	List<WebElement> productList;

	@FindBy(xpath = "//button[@class='btn_primary btn_inventory']")
	List<WebElement> addtocart;

	@FindBy(xpath = "//a[@class='shopping_cart_link fa-layers fa-fw']")
	WebElement cart;
	
	@FindBy(xpath = "//button[@class='btn_secondary cart_button']")
	List<WebElement> remove;

	

	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void findproductitem(String productname) throws Exception {
		Boolean flag = false;
		for (int icnt = 0; icnt <= productList.size(); icnt++) {
			String expectedProductname = productList.get(icnt).getText().trim();
			if (expectedProductname.equalsIgnoreCase(productname)) {
				addtocart.get(icnt).click();
				flag = true;
				break;
			}
		}

		if (flag) {
			ExtentTestManager.logpass("The Product { " + productname + " is added to the cart");
		} else {
			ExtentTestManager.logFail("The Product { " + productname + " is not found");
		}

	}

	public void clickcart() throws Exception {
		TestUtils.click(cart, "Cart");

	}

	public void verifyitemincart(String productname) {
		Boolean flag = false;
		for (int icnt = 0; icnt <= productList.size(); icnt++) {
			String expectedProductname = productList.get(icnt).getText().trim();
			if (expectedProductname.equalsIgnoreCase(productname)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			ExtentTestManager.logpass("The Product { " + productname + " is available in checkout cart");
		} else {
			ExtentTestManager.logFail("The Product { " + productname + " is not available in the checkout cart");
		}
	}
	
	
	public void removeitemfromcart (String productname) {
		Boolean flag = false;
		for (int icnt = 0; icnt <= productList.size(); icnt++) {
			String expectedProductname = productList.get(icnt).getText().trim();
			if (expectedProductname.equalsIgnoreCase(productname)) {
				remove.get(icnt).click();
				flag = true;
				break;
			}
		}
		if (flag) {
			ExtentTestManager.logpass("The Product { " + productname + " is removed from the cart");
		} else {
			ExtentTestManager.logFail("The Product { " + productname + " is not found");
		}
	}
	
	public void verifyitemremoved (String productname) {
				
		if (productList.size()==0) {
			ExtentTestManager.logpass("The Product { " + productname + " is not available in the cart");
		} else {
			ExtentTestManager.logFail("The Product { " + productname + " is still available in the cart");
		}
		
		
	}
	

}
