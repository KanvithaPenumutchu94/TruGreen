package com.framework.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.framework.testCases.BaseClass;

import coreUtilities.ExtentReportManager;


public class ITestListener implements org.testng.ITestListener {

	public void onTestStart(ITestResult result) {
		//ExtentReportManager.extent.createTest(result.getMethod().getMethodName());
		ExtentReportManager.startTest(result.getMethod().getMethodName(), result.getMethod().getDescription(), "Smoke");
	}

	public void onTestSuccess(ITestResult result) {
		ExtentReportManager.logPass(result.getMethod().getMethodName()+" Test Case passed successfully");
		try {
			Media mediaModel = MediaEntityBuilder.createScreenCaptureFromBase64String(BaseClass.takeScreenShot()).build();
			ExtentReportManager.logScreenshot(mediaModel);
		} catch (IOException e) {
			
		}
		
	}

	public void onTestFailure(ITestResult result) {
		ExtentReportManager.logFail(result.getThrowable().getMessage());
		
		try {
			Media mediaModel = MediaEntityBuilder.createScreenCaptureFromBase64String(BaseClass.takeScreenShot()).build();
			ExtentReportManager.logScreenshot(mediaModel);
		} catch (IOException e) {
			
		}
		//getCurrentTest().info("", mediaModel);
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}
	
	

}
