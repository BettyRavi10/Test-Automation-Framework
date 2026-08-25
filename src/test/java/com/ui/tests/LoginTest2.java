package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;

public class LoginTest2 {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver();// launch browser. Browser session created
		//HomePage homePage = new HomePage(wd); // create object of HomePage class and pass the driver object to it.
		//LoginPage loginPage = homePage.goToLoginPage(); // click on the Sign in link
		//loginPage.doLoginWithValidCredentials("naratic104@aghism.com", "test123"); // enter email and password and click on the Sign in button

	}

}
