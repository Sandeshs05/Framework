package com.app.testcases;

import java.time.Duration;
import java.util.List;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class End_to_end 
{

	@Test
	public void TC_001_isPSPfunctionality() throws InterruptedException {
		// TODO Auto-generated method stub
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://157.241.30.5:3005/#/login");
		driver.findElement(By.name("userName")).sendKeys("mtsadmin@mts.com");
		driver.findElement(By.name("password")).sendKeys("12345678");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='Merchant Onboarding']")).click();
		driver.findElement(By.xpath("//a[.='Merchant']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[.='Add Merchant']")).click();
		WebElement setting_Tab=driver.findElement(By.id("react-tabs-2"));
		WebElement mapping_Tab=driver.findElement(By.id("react-tabs-4"));
		WebElement is_psp_checkbox=driver.findElement(By.id("txnCountEnableCheckbox"));
		is_psp_checkbox.click();
        Assert.assertTrue(is_psp_checkbox.isEnabled());
		Assert.assertFalse(setting_Tab.isDisplayed(), "Tab is not displayed");
		Assert.assertFalse(mapping_Tab.isDisplayed(),"Tab is not displayed");
		driver.quit();
	}
}
