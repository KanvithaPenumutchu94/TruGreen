package com.framework.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



import coreUtilities.ConfiguratorReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger; //For Logging 
	
	@BeforeMethod
	public void beforeMethod() throws IOException
	{
		//Logging
		logger = LogManager.getLogger(this.getClass());
		
		launchBrowser(ConfiguratorReader.getConfigValue("browser"));
		logger.info("Browser opened");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().deleteAllCookies();
		driver.get(ConfiguratorReader.getConfigValue("url"));
		logger.info("Opened the application");
		}
	
	public static void launchBrowser(String browsername)
	{
		if(browsername.equalsIgnoreCase("chrome"))
		{
			
			  ChromeOptions options=new ChromeOptions();
			  options.addArguments("--remote-allow-origins=*");
			  options.addArguments("--disable-notifications");
			  options.addArguments("--use-fake-ui-for-media-stream");
			  //WebDriverManager.chromedriver().setup(); 
			  driver=new ChromeDriver(options);
			  driver.manage().deleteAllCookies();
			  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
			
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
			EdgeOptions options = new EdgeOptions();
			options.addArguments("remote-allow-origin=*");

			options.addArguments("--disable-notifications");

			options.addArguments("--use-fake-ui-for-media-stream");
			
			driver=new EdgeDriver(options);
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
	}
	
	
	//Screenshot
	public static String takeScreenShot() throws IOException
	{
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		String SrcFile=scrShot.getScreenshotAs(OutputType.BASE64);
		return SrcFile;
	}
	
	@AfterMethod
	public void afterMethod()
	{
		//driver.quit();
	}
}
