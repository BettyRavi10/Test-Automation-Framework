package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LoginTestold {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver();// launch browser. Browser session created
		
//		BrowserUtility browserUtility = new BrowserUtility(wd); // create object of BrowserUtility class and pass the driver object to it.
//		browserUtility.launchBrowser("https://automationpractice.techwithjatin.com/login"); // launch the browser and maximize the window
//		
//
//		// Signin link locator
//		browserUtility.clickOnElement(signinLocator); // click on the element
//		
//		
//		// email textbox locator
//		By emailTextboxLocator = By.id("email");
//		browserUtility.sendKeys(emailTextboxLocator, "naratic104@aghism.com");// enter email in the element --invalid/validcredentials
//
//		// password textbox locator
//		By passwordTextboxLocator = By.id("passwd");
//		browserUtility.sendKeys(passwordTextboxLocator, "test123");// enter password in the element --invalid/valid credentials
//		
//		//Signin - Submit login button locator
//		By submitButtonLocator = By.xpath("//button[@id=\"SubmitLogin\"]");
//		browserUtility.clickOnElement(submitButtonLocator); // click on the element
//		
//	
		}

}
