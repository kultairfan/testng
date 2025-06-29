package com.neotech.utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {
	
	private static Properties prop; 
	
	/**
	 * This method reads the configs properties file
	 * 
	 * @param filePath
	 */
	public static void readProperties(String filePath)
	{
		try 
		{
			FileInputStream fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This method returns a value based on a received key
	 * @param String key
	 * @return String value
	 */
	public static String getProperty(String key)
	{
		return prop.getProperty(key);
	}

}
