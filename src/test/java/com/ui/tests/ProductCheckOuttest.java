package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.MyAccountPage;
import com.ui.pages.SerchResultPage;

public class ProductCheckOuttest extends TestBase {
	private static final String SEARCH_TERM = "Printed Summer dress";
	private SerchResultPage searchResultPage;

	@BeforeMethod(description = "Setup method to login before each test")
	public void setup() {
		searchResultPage = homePage.goToLoginPage().doLoginWithValidCredentials("naratic104@aghism.com", "test123")
				.searchProduct(SEARCH_TERM);

		// Implement the setup steps for the test here
	}

	@Test(description = "Verify the logged in user is able to checkout a product", groups = { "e2e", "sanity",
			"smoke" })
	public void checkOutTest() {
		String Result = searchResultPage.clickOnProductAt(1).selectSize(L).clickAddToCart().clickProceedToCheckout()
				.gotoConfirmAddresspage().clickProceedToCheckoutaddress().goToShipmentPage().goToPaymentPage().makePayment();
		//System.out.println("Result: " + Result);
		Assert.assertTrue(Result.contains("complete"));

	}

}
