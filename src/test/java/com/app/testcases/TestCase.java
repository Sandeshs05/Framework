package com.app.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.app.pageobjects.BaseTest;
import com.app.pageobjects.LoginPage;
import com.app.utilities.BrowserFactory;
import com.app.utilities.ExcelDataProvider;
import com.app.utilities.Helper;

public class TestCase extends BaseTest {
	@Test
	public void loginApp()
	{
		login();
	}
	@Test
	public void loginApp1()
	{
		
	}
}
