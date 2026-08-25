package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {
	private static final By EMAIL_TEXT_BOX_LOCATOR = By.id("email");
	private static final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
	private static final By SUBMIT_BUTTON_LOCATOR = By.xpath("//button[@id=\"SubmitLogin\"]");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public MyAccountPage doLoginWithValidCredentials(String email, String password) {
		sendKeys(EMAIL_TEXT_BOX_LOCATOR, email);
		sendKeys(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOnElement(SUBMIT_BUTTON_LOCATOR);
		MyAccountPage myAccountPage = new MyAccountPage(getDriver()); // create object of MyAccountPage class and pass the driver object to it.
		return myAccountPage; // return the MyAccountPage object to the test class.
	}	
}
