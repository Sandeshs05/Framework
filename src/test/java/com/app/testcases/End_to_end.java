package com.app.testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class End_to_end 
{

	@Test
	public void AddtoCart() 
	{
		// TODO Auto-generated method stub
		String Productname="ZARA COAT 3";
		System.setProperty("webdriver.chrome.driver", "Path");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("sandeshs417@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("8088866502San@");
		driver.findElement(By.id("login")).click();
		
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		for(int i=0;i<products.size();i++)
		{	
			if(products.get(i).getText().contains("ZARA"))
		{
				System.out.println(products.get(i).getText());
				driver.findElement(By.xpath("//button[.=' Add To Cart']")).click();
			}
				
		}
		
		

	}
}
