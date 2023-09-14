package com.framework.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.testCases.BaseClass;

import coreUtilities.ConfiguratorReader;
import coreUtilities.ExtentReportManager;

public class HomePageSM extends BaseClass {
	
	public HomePageSM() {
		PageFactory.initElements(driver, this);
	}
	
	HomePageSE homepagese=new HomePageSE();
	
	@FindBys({@FindBy(how=How.XPATH, using="(//table)[1]/tbody/tr/td[2]")})
	List<WebElement> refnos;
	
	@FindBy(xpath="(//table)[1]//tbody/tr/td[9]")
	WebElement ActionDD;
	
	@FindBy(xpath="(//table)[1]/tbody/tr[1]/td//input[@data-mantine-stop-propagation='true']")
	WebElement ApproveBtn;
	
	@FindBy(xpath="//input[@placeholder='Select Assignee']/..")
	WebElement AssignToDD;
	
	@FindBy(xpath="//input[@placeholder='Select Assignee' and @data-mantine-stop-propagation='true']")
	WebElement siteHead;
	
	@FindBy(xpath="//div[text()='Success']")
	WebElement successMsg;
	
	@FindBy(xpath="//span[text()='Approve']")
	WebElement ApproveBtnPopUp;
	
	public void enterCredentialsSM() throws IOException, InterruptedException {
		Thread.sleep(2000);
		homepagese.usernameTxt.sendKeys(ConfiguratorReader.getConfigValue("usernamesm"));
		ExtentReportManager.logInfo("entered the sm username");
		homepagese.passwordTxt.sendKeys(ConfiguratorReader.getConfigValue("passwordsm"));
		ExtentReportManager.logInfo("entered the sm password");
	}
	
	public void clickOnSelectActionDD() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("all ref nos are");
		for(WebElement refno:refnos) {
			String refValue=refno.getText();
			Thread.sleep(3000);
			System.out.println(refValue);
				if(refValue.contains(HomePageSE.refNo)){
				ActionDD.click();
				ExtentReportManager.logInfo("Select Option dropdown in Action coloumn");
				Thread.sleep(5000);
				break;
			}
		}
	}
	
	public void clickOnApproveOption() throws InterruptedException {
		Thread.sleep(2000);
		ApproveBtn.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		ExtentReportManager.logInfo("Selected approve option");
	}
	
	public void clickOnAssignToDD() throws InterruptedException {
		AssignToDD.click();
		ExtentReportManager.logInfo("Clicked on Select Assignee dropdown");
		Thread.sleep(3000);
	}
	
	public void clickOnSiteHead() {
		siteHead.sendKeys(Keys.DOWN,Keys.ENTER);
		ExtentReportManager.logInfo("Assigned to site head option");
	}
	
	public void clickOnApproveBtnInPopUp() {
		ApproveBtnPopUp.click();
		ExtentReportManager.logInfo("Clicked on Approve button in popup");
	}
	
	public void approveSuccessMsgDisplayed() throws InterruptedException {
		if(successMsg.isDisplayed()==true) {
			Assert.assertTrue(true);
			Thread.sleep(3000);
		}else {
			Assert.assertTrue(false);
		}
	}
	
	
	
	
	
	

}
