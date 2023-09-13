package com.framework.testCases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.pages.HomePageSE;


@Listeners(com.framework.listeners.ITestListener.class)
public class HomePageTestSE extends BaseClass {
	
	HomePageSE homepage;
	
	@Test
	public void homepageTest() throws IOException, InterruptedException {
		homepage=new HomePageSE();
		homepage.enterCredentials();
		homepage.clickOnSubmitButton();
		
		homepage=new HomePageSE();
		homepage.clickOnProcurement();
		homepage.clickOnRFP();
		homepage.clickOnClientDD();
		homepage.clickOnSiteDD();
		homepage.clickOnNewButton();
		homepage.enterDescription();
		homepage.enterJustification();
		homepage.clickOnSendForApproval();
		homepage.clickOnConfirmOnPopUp();
		//homepage.verifyRFPCreation();
		homepage.refNoVerification();
		homepage.clickOnLogout();
		
	}

	
	

}
