package com.app.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configDataReader {
	Properties prop;
	
	public configDataReader()
	{
		File src= new File("./Config//confg.properties");
		try {
			FileInputStream fis= new FileInputStream(src);
			prop= new Properties();
			prop.load(fis);
		} catch (Exception e)
		{
			System.out.println("Not able to read config file "+e.getMessage());
		}
	}


	public String getBrowser()
	{
		return prop.getProperty("Browser");
	}
	
	public String getURL()
	{
		return prop.getProperty("qaURL");
		
	}
}