package com.framework.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.testCases.BaseClass;

import coreUtilities.ExtentReportManager;

public class HomePageSH extends BaseClass {
	
	public HomePageSH() {
		PageFactory.initElements(driver, this);
	}
	HomePageSE homepagese=new HomePageSE();
	
	@FindBy(xpath="//span[text()='Approve']/../..")
	WebElement ApproveBtnPopupSH;
	
	public void enterCredentialsSH() throws IOException, InterruptedException {
		Thread.sleep(2000);
		homepagese.usernameTxt.sendKeys("siteHead");
		ExtentReportManager.logInfo("entered the sh username");
		homepagese.passwordTxt.sendKeys("password");
		ExtentReportManager.logInfo("entered the sh password");
	}
	
	public void clickOnApproveBtnPopupSH() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Approve']")).click();
		ExtentReportManager.logInfo("Clicked on Approve button in popup");
	}

}
