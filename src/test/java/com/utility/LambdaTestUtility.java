package com.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LambdaTestUtility {
	public static final String HUB_URL = "https://hub.lambdatest.com/wd/hub"; // IN FW, it is going to be constant
	private static ThreadLocal<WebDriver> driverLocal = new ThreadLocal<WebDriver>();
	private static ThreadLocal<DesiredCapabilities> capabilitiesLocal = new ThreadLocal<DesiredCapabilities>();

	public static WebDriver initializelambdaTestSession(String browser, String testName) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", browser);
		capabilities.setCapability("browserVersion", "latest");
		Map<String, Object> ltOptions = new HashMap<>();
		ltOptions.put("user", "bettysn");
		ltOptions.put("accessKey", "LT_bvz8ICr0Q4ucSQixscn8eNJVhqvliJ0zwZciIRZBcb9ItKJ");
		ltOptions.put("build", "Selenium 4");
		ltOptions.put("name", testName);
		ltOptions.put("platformName", "Windows 10");
		ltOptions.put("seCdp", true);
		ltOptions.put("selenium_version", "latest");
		capabilities.setCapability("LT:Options", ltOptions);
		capabilitiesLocal.set(capabilities);
		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL(HUB_URL), capabilitiesLocal.get());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driverLocal.set(driver);
		return driverLocal.get();
	}

	public static void quitSession() {
		if (driverLocal != null) {
			driverLocal.get().quit();
		}
	}
}
