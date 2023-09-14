package com.framework.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.testCases.BaseClass;

import coreUtilities.ConfiguratorReader;
import coreUtilities.ExtentReportManager;

public class HomePageSE extends BaseClass {
	
	static String refNo;
	public HomePageSE() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement usernameTxt;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement passwordTxt;
	
	@FindBy(xpath="//span[text()='Submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//*[local-name()='svg' and @class='icon icon-tabler icon-tabler-switch-horizontal']/../../..")
	WebElement TruGreenTab;
	
	@FindBy(xpath="//span[text()='Logout']")
	WebElement logoutBtn;
	
	@FindBy(xpath="//span[text()='Procurement']//ancestor::button")
	WebElement procurementBtn;
	
	@FindBy(xpath="//a[@href='/trugreen/procurement/rfps']")
	WebElement RFPLnk;
	
	@FindBy(xpath="(//input[@type='search'])[1]")
	WebElement clientDrpdwn;
	
	@FindBy(xpath="(//input[@type='search'])[2]")
	WebElement siteDrpdwn;
	
	@FindBy(xpath="//span[text()='New']/../..")
	WebElement newBtn;
	
	@FindBy(xpath="//textarea[@placeholder='Description']")
	WebElement descriptionTxt;
	
	@FindBy(xpath="//textarea[@placeholder='Justification']")
	WebElement justificatinTxt;
	
	@FindBy(xpath="//span[text()='Send for Approval']")
	WebElement sendForApprovalBtn;
	
	@FindBy(xpath="//span[text()='Confirm']")
	WebElement confirmBtnOnPopUp;
	
	@FindBy(xpath="//div[text()='RFP has been created']")
	WebElement RFPCreationSuccessMsg;
	
	@FindBy(xpath="((//table)[2]//tbody/tr/td[2])[1]")
	WebElement firstRefNoFromAllRFPs;
	
	public void enterCredentials() throws IOException, InterruptedException {
		Thread.sleep(2000);
		usernameTxt.sendKeys(ConfiguratorReader.getConfigValue("usernamese"));
		ExtentReportManager.logInfo("entered the se username");
		passwordTxt.sendKeys(ConfiguratorReader.getConfigValue("passwordse"));
		ExtentReportManager.logInfo("entered the se password");
	}
	
	public void clickOnSubmitButton() throws InterruptedException {
		submitBtn.click();
		Thread.sleep(2000);
		ExtentReportManager.logInfo("clicked on submit button");
	}
	
	public void visibilityOfTruGreenTab() {
		if(TruGreenTab.isDisplayed()==true) {
			Assert.assertTrue(true);
			ExtentReportManager.logPass("Test case passed");
		}else {
			Assert.assertFalse(false);
			ExtentReportManager.logFail("Test case failed");
		}
	}
		
	public void clickOnProcurement() throws InterruptedException {
		procurementBtn.click();
		Thread.sleep(6000);
		ExtentReportManager.logInfo("clicked on procurement button");
	}
	
	public void clickOnRFP() {
		RFPLnk.click();
		ExtentReportManager.logInfo("clicked on RFP link");
	}
	
	public void clickOnClientDD() {

		clientDrpdwn.click();
		//System.out.println("attribute values for client are:");
		for(int i=0;i<11;i++) {
			clientDrpdwn.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
			clientDrpdwn.click();
			String attributevalue=clientDrpdwn.getAttribute("value");
			//System.out.println(attributevalue);
			if(attributevalue.equals("Client Alpha")) {
				clientDrpdwn.sendKeys(Keys.ENTER);
				ExtentReportManager.logInfo("selected client alpha from client dropdown");
			}
		}	
	}
	
	public void clickOnSiteDD() throws InterruptedException {
		Thread.sleep(2000);
		siteDrpdwn.click();
		//System.out.println("attribute values for site are:");
		for(int i=0;i<1;i++) {
			siteDrpdwn.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
			siteDrpdwn.click();
			String attributevalue=siteDrpdwn.getAttribute("value");
			//System.out.println(attributevalue);
			if(attributevalue.equals("Alpha Three")) {
				siteDrpdwn.sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				ExtentReportManager.logInfo("selected alpha three from site dropdown");
			}
		}
	}
	
	public void clickOnNewButton() throws InterruptedException {
		newBtn.click();
		ExtentReportManager.logInfo("clicked on new button");
		Thread.sleep(2000);
	}
	
	public void enterDescription() {
		descriptionTxt.sendKeys("tea");
		ExtentReportManager.logInfo("entered description");
	}
	
	public void enterJustification() {
		justificatinTxt.sendKeys("tea coffee");
		ExtentReportManager.logInfo("entered value in justification");
	}
	
	public void clickOnSendForApproval() {
		sendForApprovalBtn.click();
		ExtentReportManager.logInfo("clicked on send for approval button");
	}
	
	public void clickOnConfirmOnPopUp() throws InterruptedException {
		Thread.sleep(5000);
		confirmBtnOnPopUp.click();
		ExtentReportManager.logInfo("clicked on comfirm button");
		Thread.sleep(5000);
	}
	
//	public void verifyRFPCreation() throws InterruptedException {
//		Thread.sleep(3000);
//		String actualSuccessMsg=RFPCreationSuccessMsg.getText();
//		Thread.sleep(2000);
//		String expectedSuccessMsg="RFP has been created";
//		if(actualSuccessMsg.equals(expectedSuccessMsg)) {
//			Assert.assertTrue(true);
//			ExtentReportManager.logPass("Successfully passed the test case");
//			Thread.sleep(2000);
//		}else {
//			Assert.assertTrue(true);
//			ExtentReportManager.logFail("test case got failed");
//		}
//	}
	
	public void refNoVerification() throws InterruptedException {
		Thread.sleep(15000);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",firstRefNoFromAllRFPs);
		refNo=firstRefNoFromAllRFPs.getText();
		Thread.sleep(3000);
		System.out.println("ref no is: "+refNo);

	}
	
	public void clickOnLogout() {
		logoutBtn.click();
		ExtentReportManager.logInfo("clicked on logout");
	}
	
	
	
	
	
	

}
