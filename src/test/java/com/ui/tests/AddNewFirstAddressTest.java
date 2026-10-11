package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddessUtility;

public class AddNewFirstAddressTest extends TestBase {
	// This class is currently empty and can be implemented with test methods for
	// adding a new address in the future.
	private MyAccountPage myAccountPage;
	private AddressPOJO addressPOJO;
	
	@BeforeMethod(description = "Setup method to login before each test")
	public void setup() {
		myAccountPage = homePage.goToLoginPage().doLoginWithValidCredentials("naratic104@aghism.com", "test123");
		addressPOJO = FakeAddessUtility.getFakeAddress();
	}

	@Test(description = "Verify the logged in user is able to add a new address", groups = { "e2e", "sanity", "smoke" })

	public void addNewAddress() {
		String newAddress = myAccountPage.goToAddNewAddressPage().saveAddress(addressPOJO);
		Assert.assertEquals(newAddress, addressPOJO.getAddressAlias().toUpperCase());
		// Implement the test steps for adding a new address here
	}
}
