package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class AddressConfirmPage extends BrowserUtility {
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.name("processAddress");

	public AddressConfirmPage(WebDriver driver) {
		super(driver);
	}

	public ShippingConfirmPage clickProceedToCheckoutaddress() {
		clickOnElement(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ShippingConfirmPage(getDriver());
	}

}
