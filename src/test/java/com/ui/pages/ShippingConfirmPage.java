package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShippingConfirmPage extends BrowserUtility {
	private static final By TERMS_OF_SERVICE_CHECKBOX_LOCATOR = By.id("uniform-cgv");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.name("processCarrier");

	public ShippingConfirmPage(WebDriver driver) {
		super(driver);
	}

	public ShipmentPage goToShipmentPage() {
		clickOnCheckBox(TERMS_OF_SERVICE_CHECKBOX_LOCATOR);
		clickOnElement(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ShipmentPage(getDriver());
	}
	
	

}
