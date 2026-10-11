package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Size;
import com.utility.BrowserUtility;

public class ProductDetailPage extends BrowserUtility {
	private static final By SIZE_DROP_DOWN_LOCATOR = By.id("group_1");
	private static final By ADD_TO_CART_BUTTON_LOCATOR = By.name("Submit");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//a[@title=\"Proceed to checkout\"]");
	// By visibleSizeDropdown = By.cssSelector("#uniform-group_1 span");

	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}

//	public ProductDetailPage selectSize(Size size) {
//		selectDropdown(SIZE_DROP_DOWN_LOCATOR, size.toString());
//		return new ProductDetailPage(getDriver()); // return the ProductDetailPage object to the test class.
//	}

	public ProductDetailPage selectSize(Size size) {
		selectDropdown(SIZE_DROP_DOWN_LOCATOR, size.getValue());
		return new ProductDetailPage(getDriver());
	}

	public ProductDetailPage clickAddToCart() {
		clickOnElement(ADD_TO_CART_BUTTON_LOCATOR);
		return new ProductDetailPage(getDriver());

	}

	public ShoppingCartSummaryPage clickProceedToCheckout() {
		clickOnElement(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ShoppingCartSummaryPage(getDriver());

	}

}
