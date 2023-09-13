package com.framework.pages;

import java.io.IOException;
import java.util.List;

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
	
	@FindBy(xpath="(//table)[1]//tbody/tr[1]/td[9]")
	WebElement ActionDD;
	
	public void enterCredentialsSM() throws IOException, InterruptedException {
		Thread.sleep(2000);
		homepagese.usernameTxt.sendKeys(ConfiguratorReader.getConfigValue("usernamesm"));
		ExtentReportManager.logInfo("entered the usernamesm");
		homepagese.passwordTxt.sendKeys(ConfiguratorReader.getConfigValue("passwordsm"));
		ExtentReportManager.logInfo("entered the passwordsm");
	}
	
	public void approveRFP() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("all ref nos are");
		for(WebElement refno:refnos) {
			Thread.sleep(3000);
			String refValue=refno.getText();
			Thread.sleep(3000);
			System.out.println(refValue);
			if(refValue.contains(homepagese.refNo)){
				ActionDD.click();
				Thread.sleep(2000);
				break;
			}
		}
	}
	
	public void test() throws InterruptedException {
		Thread.sleep(5000);
		ActionDD.click();
		Thread.sleep(2000);
	}
	
	
	
	
	
	

}
