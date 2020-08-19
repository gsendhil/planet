package com.planet.qa.manager;

import org.openqa.selenium.WebDriver;

import com.planet.qa.pages.CheckoutPage;
import com.planet.qa.pages.LoginPage;
import com.planet.qa.pages.ProductsPage;

public class PageObjectManager {
	private WebDriver driver;
	private LoginPage loginPage;
	private ProductsPage productsPage;
	private CheckoutPage checkoutPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public ProductsPage getProductsPage() {
		return (productsPage == null) ? productsPage = new ProductsPage(driver) : productsPage;
	}

	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}

	public CheckoutPage getCheckoutPage() {
		return (checkoutPage == null) ? checkoutPage = new CheckoutPage(driver) : checkoutPage;
	}

}
