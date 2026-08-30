package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;

	public void onTestStart(ITestResult result) { // called when will be the test is going to start.
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) { // When the test is success
		logger.info(result.getMethod().getMethodName() + " " + "PASSED");
		ExtentTest test = ExtentReporterUtility.getTest();
		if (test != null) {
			test.log(Status.PASS, result.getMethod().getMethodName() + " " + "PASSED");
		} else {
			logger.warn("ExtentTest is null in onTestSuccess; skipping extent logging.");
		}

	}

	public void onTestFailure(ITestResult result) { // When the test is failure
		logger.error(result.getMethod().getMethodName() + " " + "FAILED");
		Throwable throwable = result.getThrowable();
		if (throwable != null) {
			logger.error(throwable.getMessage());
		} else {
			logger.error("Test failed with no throwable available.");
		}

		// Ensure ExtentTest is available to avoid NPE
		ExtentTest test = ExtentReporterUtility.getTest();
		if (test == null) {
			ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
			test = ExtentReporterUtility.getTest();
		}

		if (test != null) {
			test.log(Status.FAIL, result.getMethod().getMethodName() + " " + "FAILED");
			if (throwable != null) {
				test.log(Status.FAIL, throwable.getMessage());
			}
		} else {
			logger.warn("ExtentTest is null after creation attempt; skipping extent logging.");
		}

		Object testclass = result.getInstance();
		if (testclass instanceof TestBase) {
			BrowserUtility browserUtility = ((TestBase) testclass).getInstance();
			if (browserUtility != null) {
				logger.info("Capture the screen shot");
				String screenShotPath = null;
				try {
					screenShotPath = browserUtility.takeScreenShot(result.getMethod().getMethodName());
				} catch (Exception e) {
					logger.error("Error while taking screenshot: " + e.getMessage());
				}
				logger.info("Attaching to the screenshot to the HTML file");

				if (screenShotPath != null && !screenShotPath.isEmpty()) {
					try {
						if (test != null) {
							test.addScreenCaptureFromPath(screenShotPath);
						} else {
							logger.warn("Cannot attach screenshot because ExtentTest is null.");
						}
					} catch (Exception e) {
						logger.error("Failed to attach screenshot: " + e.getMessage());
					}
				} else {
					logger.warn("Screenshot path is empty, skipping attachment.");
				}
			} else {
				logger.warn("BrowserUtility instance is null, skipping screenshot.");
			}
		} else {
			logger.warn("Test class is not an instance of TestBase, skipping screenshot.");
		}

	}
	

	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + " " + "SKIPPED");
		ExtentTest test = ExtentReporterUtility.getTest();
		if (test != null) {
			test.log(Status.SKIP, result.getMethod().getMethodName() + " " + "SKIPPED");
		} else {
			logger.warn("ExtentTest is null in onTestSkipped; skipping extent logging.");
		}

	}

	public void onStart(ITestContext context) {
		logger.info("Test Suite Started");
		ExtentReporterUtility.setupSparkerReporter("report.html");
	}

	public void onFinish(ITestContext context) {
		logger.info("Test Suite Completed");
		ExtentReporterUtility.flushReport();
	}
}
