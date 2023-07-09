package com.app.pageobjects;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.app.utilities.BrowserFactory;
import com.app.utilities.ExcelDataProvider;
import com.app.utilities.Helper;
import com.app.utilities.configDataReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest
	{
		public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	}


	public void onTestFailure() 
	{
		// TODO Auto-generated method stub
		
		logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
	}
	

	public WebDriver driver;
	public configDataReader prop;
	public ExcelDataProvider excel;
	public ExtentReports report;
	public ExtentTest logger; 
	
	
	@BeforeSuite
	public void setUpSuite()
	{
		excel= new ExcelDataProvider();
		prop=new configDataReader();
		
		ExtentSparkReporter extent = new ExtentSparkReporter(new File("./Reports//"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		logger=report.createTest("Login");
	}

	
	@BeforeMethod(alwaysRun = true)
	public void startApplication()
	{
		driver = BrowserFactory.startApplication(prop.getBrowser(), prop.getURL());
		logger.info("Test Start");
	}
	@AfterMethod(alwaysRun = true)
	public void closeApplication(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath((Helper.captureScreenshot(driver))).build());
		}
		driver.close();
		report.flush();
	}

	
	public void login()
	{
		new LoginPage(driver).login(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
	}
}
