package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListener.class)

public class InvalidCredLoginTest extends TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final String INVALID_EMAIL = "Betty@gmail.com";
	private static final String INVALID_PASSWORD = "Betty123";

	@Test(description = "Verify the test with invalid credentials", groups = { "e2e", "sanity", "smoke" })
	/*
	 * Test Method 1, Test script small and readable 2. you cannot have conditional
	 * statements in the test method (loops, if else, switch case),try catch block,
	 * try to avoid any logic in the test method, if you have any logic in the test
	 * method then move it to the page class. 3, Tests scripts should only follow
	 * the test steps, 4. Reduce the use of local variables 5. you should use
	 * atleast one assertion
	 */

	public void loginTest() { // Test method with data provider, user is the object of User class which is
								// passed from the data provider

		assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL, INVALID_PASSWORD)
				.getErrorMessage(), "Authentication failed.");

	}

}
