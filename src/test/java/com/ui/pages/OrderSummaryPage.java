package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class OrderSummaryPage extends BrowserUtility {
	private static final By CONFIRM_ORDER_BUTTON_LOCATOR = By.xpath("//p[@id=\"cart_navigation\"]/button[@type=\"submit\"]");

	public OrderSummaryPage(WebDriver driver) {
		super(driver);
	}

	public OrderConfirmationPage clickConfirmOrder() {
		clickOnElement(CONFIRM_ORDER_BUTTON_LOCATOR);
		return new OrderConfirmationPage(getDriver());
	}	

}
