package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility {

	private static final By SIGN_IN_LOCATOR = By.xpath("//a[contains(text(),\"Sign in\")]");
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless); // to call the parent class constructor from the child class constructor.
		// gotoWebsite(readProperty(QA,"URL")); // launch the browser and maximize the
		// window
		logger.info("Get url");
		gotoWebsite(JSONUtility.readJson(QA).getUrl()); // launch the browser and maximize the window

	}
	
	public HomePage(WebDriver driver) {
		super(driver);
		gotoWebsite(JSONUtility.readJson(QA).getUrl()); // launch the browser and maximize the window	
		}

	public LoginPage goToLoginPage() { // page functions--->don't return void, return page object, return data
		clickOnElement(SIGN_IN_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver()); // create object of LoginPage class and pass the driver object
															// to it.
		return loginPage; // return the LoginPage object to the test class.
	}

	public void quit() {
		
			}

}
