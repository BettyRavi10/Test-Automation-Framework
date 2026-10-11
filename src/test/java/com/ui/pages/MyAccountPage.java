package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class MyAccountPage extends BrowserUtility {
	public WebDriver driver;
	private static final By USER_NAME_LOCATOR = By.xpath("//a[@title=\"View my customer account\"]//span");
	private static final By SEARCH_TEXT_BOX_LOCATOR = By.id("search_query_top");
	private static final By SADD_NEW_ADDRESS_LINK_LOCATOR = By.xpath("//a[@title=\"Add my first address\"]");

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	public String getUserName() {
		return getVisibleText(USER_NAME_LOCATOR);
	}

	public SerchResultPage searchProduct(String productName) {
		sendKeys(SEARCH_TEXT_BOX_LOCATOR, productName);
		enterSpecialKey(SEARCH_TEXT_BOX_LOCATOR, Keys.ENTER);
		SerchResultPage searchResultPage = new SerchResultPage(getDriver()); // create object of SerchResultPage class
																				// and pass the driver object to it.
		return searchResultPage; // return the SerchResultPage object to the test class.
	}
	
	public AddressPage goToAddNewAddressPage() {
		clickOnElement(SADD_NEW_ADDRESS_LINK_LOCATOR);
		AddressPage addressPage = new AddressPage(getDriver()); // create object of AddressPage class and pass the driver object to it.	
		return addressPage; // return the AddressPage object to the test class.
	}
}
