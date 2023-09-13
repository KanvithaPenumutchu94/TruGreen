package com.framework.testCases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.pages.HomePageSE;
import com.framework.pages.HomePageSM;


@Listeners(com.framework.listeners.ITestListener.class)
public class HomePageTestSM extends BaseClass {
	HomePageSE homepagese;
	HomePageSM homepagesm;
	
	@Test
	public void homepageTest() throws IOException, InterruptedException {
		homepagese=new HomePageSE();
		homepagesm=new HomePageSM();
		
		homepagesm.enterCredentialsSM();
		homepagese.clickOnSubmitButton();
		homepagese.clickOnProcurement();
		homepagese.clickOnRFP();
		homepagese.clickOnClientDD();
		homepagese.clickOnSiteDD();
		Thread.sleep(3000);
		homepagesm.approveRFP();
		
		//homepagese.clickOnLogout();
	}

	
	

}
