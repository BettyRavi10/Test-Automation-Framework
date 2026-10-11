package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BrowserUtility {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private WebDriverWait wait;

	public WebDriver getDriver() {
		return driver.get();

	}

	public BrowserUtility(WebDriver driver) { // parameterized constructor
		super();
		this.driver.set(driver); // initialize the instance variable driver.
		wait = new WebDriverWait(driver, Duration.ofSeconds(30L)); // initialize the wait object with a timeout of 10
																	// seconds

	}

	public BrowserUtility(String browserName) { // parameterized constructor
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			// WebDriverManager.chromedriver().setup();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else {
			throw new IllegalArgumentException("Invalid browser name: " + browserName);
		}
	}

	public BrowserUtility(Browser browserName) { //
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			// WebDriverManager.chromedriver().setup();
		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) { // headless mode
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old"); // headless
				options.addArguments("--window-size=1920,1080");
				// options.addArguments("--headless");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--disable-gpu");

				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

				// WebDriverManager.chromedriver().setup();
			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			}
		}

		else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old"); // headless
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			} else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			}
		} else if (browserName == Browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old"); // headless
				driver.set(new FirefoxDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			} else {
				driver.set(new FirefoxDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

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
		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	
	public void clickOnCheckBox(By locator) {
		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.click();
	}

	public void clickOnElement(WebElement element) {
		element.click();
	}

	public void sendKeys(By locator, String text) {
		logger.info("Sending keys to element: " + locator.toString() + " with text: " + locator.toString());
		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element found: " + text.toString());
		element.sendKeys(text);
	}

	public void clearText(By textBoxlocator) {
		// WebElement element = driver.get().findElement(textBoxlocator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxlocator));
		logger.info("Element found:  nad clear the text" + textBoxlocator.toString());
		element.clear();
	}

//	public void selectDropdown(By dropDownLocator, String optionToSelect) {
//		logger.info("Selecting value from dropdown: " + dropDownLocator.toString() + " with value: "
//				+ dropDownLocator.toString());
//		WebElement element = driver.get().findElement(dropDownLocator);
//		Select dropdown = new Select(element);
//		dropdown.selectByValue("2");
//		element.click();
//		// dropdown.selectByVisibleText(optionToSelect);
//		// logger.info("selecting the option: " + optionToSelect.toString());
//
//	}

	public void selectDropdown(By dropDownLocator, String value) {

		logger.info("Selecting dropdown value: [" + value + "]");

		WebElement element = driver.get().findElement(dropDownLocator);

		Select dropdown = new Select(element);
		dropdown.selectByValue(value);

		System.out.println("Selected option: " + dropdown.getFirstSelectedOption().getText());
	}

	public void selectDropdownCountry(By dropDownLocator, String value) {
		logger.info("Selecting value from dropdown: " + dropDownLocator.toString() + " with value: "
				+ dropDownLocator.toString());
		WebElement element = driver.get().findElement(dropDownLocator);
		Select dropdown = new Select(element);
		dropdown.selectByValue("5");
		element.click();

	}

	public void enterSpecialKey(By locator, Keys keysToEnter) {
		logger.info("Sending special keys to element: " + locator.toString() + " with keys: " + locator.toString());
		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element found: " + keysToEnter.toString());
		element.sendKeys(keysToEnter);
	}

	public List<String> getAllVisibleText(By locator) {
		List<WebElement> elementList = driver.get().findElements(locator);
		List<String> visibleTextList = new java.util.ArrayList<>();
		for (WebElement element : elementList) {
			logger.info("Element found: " + element.getText());
			visibleTextList.add(getVisibleText(element));
		}
		return visibleTextList;
	}

		
	public List<WebElement> getAllElements(By locator) {
		List<WebElement> elementList = driver.get().findElements(locator);
		return elementList;
	}

	public String getVisibleText(By locator) {
		WebElement element = driver.get().findElement(locator);
		return element.getText();
	}

	public String getVisibleText(WebElement element) {
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
		// String path = System.getProperty("user.dir") + ("//screenshots//" + name +
		// "-" + "timeStamp" + ".png");
		String path = "./screenshots/" + name + "-" + timeStamp + ".png";

		File screenShotFile = new File(path);
		try {
			FileUtils.copyFile(screenShotData, screenShotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
