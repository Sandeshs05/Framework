package com.app.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="userEmail") WebElement usernamee;
	@FindBy(id="userPassword") WebElement passworde;
	@FindBy(id="login") WebElement loginButton;
	
	public void login(String uName, String password)
	{
		usernamee.sendKeys(uName);
		passworde.sendKeys(password);
		loginButton.click();
	}
}
