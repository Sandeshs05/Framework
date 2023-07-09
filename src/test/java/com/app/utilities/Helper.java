package com.app.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver)
	{
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenShotPath= "./Screenshots//"+Helper.getCurrentDateTime()+".png";
		try {
			Files.copy(src, new File(screenShotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to capture screenshot" +e.getMessage());
		}
		return screenShotPath;
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date curretDate=new Date();
		return customFormat.format(curretDate);
		
	}
	public void handleFrames()
	{
		
	}

}
