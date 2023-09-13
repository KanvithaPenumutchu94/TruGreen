package com.framework.listeners;

import org.testng.IExecutionListener;
import org.testng.ISuite;

import coreUtilities.ExtentReportManager;

public class ISuiteListener implements org.testng.ISuiteListener,IExecutionListener {

	public void onStart(ISuite suite) {
		ExtentReportManager.startReport();
	}

	public void onFinish(ISuite suite) {
		ExtentReportManager.stopReport();
	}

	public void onExecutionStart() {
		
	}

	public void onExecutionFinish() {
		
	}

	
	

}
