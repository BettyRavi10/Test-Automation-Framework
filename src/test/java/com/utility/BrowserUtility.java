package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BrowserUtility {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		return driver.get();
		
	}

	public BrowserUtility(WebDriver driver) { // parameterized constructor
		super();
		this.driver.set(driver); // initialize the instance variable driver.
		
	}

	public BrowserUtility(String browserName) { // parameterized constructor
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
			//WebDriverManager.chromedriver().setup();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		} else {
			throw new IllegalArgumentException("Invalid browser name: " + browserName);
		}
	}

	public BrowserUtility(Browser browserName) { //
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
			//WebDriverManager.chromedriver().setup();
		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		} else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
		}
	}
	

	public BrowserUtility(Browser browserName, boolean isHeadless) { // headless mode
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old"); // headless
				options.addArguments("--window-size=1920,1080");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--headless=new");
				driver.set(new ChromeDriver(options));
				//WebDriverManager.chromedriver().setup();
			} else {
				driver.set(new ChromeDriver());

			}
		}

		else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old"); // headless
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
			} else {
				driver.set(new EdgeDriver());
			}
		} else if (browserName == Browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old"); // headless
				driver.set(new FirefoxDriver(options));
			} else {
				driver.set(new FirefoxDriver());
			}
		}
	}
	// launch the browser and maximize the window

	public void gotoWebsite(String url) {
		driver.get().get(url);
		maximizeWindow();
	}

	public void maximizeWindow() {
		driver.get().manage().window().maximize();
	}

	public void clickOnElement(By locator) {
		WebElement element = driver.get().findElement(locator);
		element.click();
	}

	public void sendKeys(By locator, String text) {
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(text);
	}

	public String getVisibleText(By locator) {
		WebElement element = driver.get().findElement(locator);
		return element.getText();
	}

	public void closeBrowser() {
		driver.get().quit();
	}

	public String takeScreenShot(String name) {
		TakesScreenshot screenShot = (TakesScreenshot) driver.get();
		File screenShotData = screenShot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-MM-SS");
		String timeStamp = format.format(date);
		String path = System.getProperty("user.dir") + ("//screenshots//" + name + "-" + "timeStamp" + ".png");
		File screenShotFile = new File(path);
		try {
			FileUtils.copyFile(screenShotData, screenShotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
