package com.ui.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {

	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest;

	@Parameters({ "browser", "isLambdaTest", "isHeadless" })
	@BeforeMethod(description = "Load the home page")
	public void setUp(
			@Optional("chrome") String browser, 
			@Optional("true") boolean isLambdaTest, 
			@Optional("false") boolean isHeadless, ITestResult result) {
		this.isLambdaTest = isLambdaTest;
		WebDriver lambdaDriver;
		if (isLambdaTest) {
			lambdaDriver = LambdaTestUtility.initializelambdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);
		} else {
			// Running the test on local machine
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless); // create object of HomePage 																							// class and pass the driver
																					// object // to it.
			
			logger.info("Launch browser");

		}

	}

	public BrowserUtility getInstance() {
		return homePage;

	}

	@AfterMethod(description = "Tear down the browser")
	public void tearDown() {
		if (isLambdaTest) {
			LambdaTestUtility.quitSession(); // quit the broswesession on lamdaTest
		} else {
			homePage.quit();
		}

	}
}
