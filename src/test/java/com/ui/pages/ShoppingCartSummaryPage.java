package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShoppingCartSummaryPage extends BrowserUtility {
	private static final By  PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//p[contains(@class,\"cart_navigation\")]/a[@title=\"Proceed to checkout\"]");
	public ShoppingCartSummaryPage(WebDriver driver) {
		super(driver);
	}

	public AddressConfirmPage gotoConfirmAddresspage() {
		clickOnElement(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new AddressConfirmPage(getDriver());
	}	
	
	

}
