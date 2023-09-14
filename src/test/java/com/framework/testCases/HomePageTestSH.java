package com.framework.testCases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.pages.HomePageSE;
import com.framework.pages.HomePageSH;
import com.framework.pages.HomePageSM;

@Listeners(com.framework.listeners.ITestListener.class)
public class HomePageTestSH extends BaseClass {
	HomePageSE homepagese;
	HomePageSM homepagesm;
	HomePageSH homepagesh;

	@Test
	public void homepageTestSH() throws IOException, InterruptedException {
		homepagese=new HomePageSE();
		homepagesm=new HomePageSM();
		homepagesh=new HomePageSH();
		
		Thread.sleep(2000);
		homepagesh.enterCredentialsSH();
		
		homepagese.clickOnSubmitButton();
		homepagese.clickOnProcurement();
		homepagese.clickOnRFP();
		homepagese.clickOnClientDD();
		homepagese.clickOnSiteDD();
		Thread.sleep(5000);
		
		homepagesm.clickOnSelectActionDD();
		homepagesm.clickOnApproveOption();
		Thread.sleep(4000);
		homepagesh.clickOnApproveBtnPopupSH();
		Thread.sleep(4000);	
		homepagese.clickOnLogout();
	}
	

}
