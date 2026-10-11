package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners(com.ui.listeners.TestListener.class)

public class SearchProductTest extends TestBase {
	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM = "Printed Summer dress";

	@BeforeMethod(description = "Login to the application before executing the test cases")
	public void setup() {
		myAccountPage = homePage.goToLoginPage().doLoginWithValidCredentials("naratic104@aghism.com", "test123");
	}

	@Test(description = "Verify the logged in user is able to search the product and valid products are displayed", groups = {
			"e2e", "sanity", "smoke" })
	
	public void VerifySearchProductTest() {
		boolean actualResult =myAccountPage.searchProduct(SEARCH_TERM).isSerachNamePresentInProductList(SEARCH_TERM);
		Assert.assertEquals(actualResult, true); 

	}

}
