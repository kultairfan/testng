package com.neotech.lesson01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class TestNGHW1 extends CommonMethods{
//	url=https://hrm.neotechacademy.com

	@BeforeMethod
	public void OpenandNavigate()
	{
		setUp();
	}
	
	@AfterMethod
	public void quitBrowser()
	{
		tearDown();
	}
	
	@Test
	public void LoginInfo()
	{
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), "");
	click(driver.findElement(By.xpath("//button")));
		
		WebElement error = driver.findElement(By.xpath("//div[@class='input-field']/span"));
		if(error.isDisplayed())
		{
			System.out.println("Test Passed!");
			
		}
		else
		{
			System.out.println("Test Failed!");
		}
	}
	
	

}
