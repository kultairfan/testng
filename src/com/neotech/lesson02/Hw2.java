package com.neotech.lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class Hw2 extends CommonMethods {
//	HW2: OrangeHRM Add Employee:
//
//	    Open chrome browser
//	    Go to "https://hrm.neotechacademy.com/"
//	    Login into the application
//	    Click on Add Employee
//	    Verify labels: Employee Full Name*, Employee Id, Location* are displayed
//	    Provide Employee First and Last Name
//	    Select a Location
//	    Verify Employee has been added successfully
//	    Close the browser

	@BeforeMethod
	public void open()
	{
		setUp();
	}
	
	@AfterMethod
	public void close()
	{
		tearDown();
	}
	
	@Test(priority =1)
	public void loginValidation()
	{
		
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		click(driver.findElement(By.xpath("//button")));
		
		wait(4);
	
	}
	
	@Test(priority =2)
	public void AddEmployee()
	{
		click(driver.findElement(By.id("menu_pim_viewPimModule")));
		wait(5);
		click(driver.findElement(By.id("menu_pim_addEmployee")));
		
		
	}
	@Test(priority = 3)
	public void verify()
	{
		WebElement labels = driver.findElement(By.xpath("//div[@class='input-group']"));
		if(labels.isDisplayed())
		{
			System.out.println("Labels are displayed");
		}
		else
		{
			System.out.println("Labels are Not displayed");
		}
	}
	
//    Provide Employee First and Last Name
	@Test(priority = 4)
	public void add()
	{
		sendText(driver.findElement(By.id("first-name-box")), "irfan");
		
		sendText(driver.findElement(By.id("last-name-box")), "kulta");
		
		selectDropdown(driver.findElement(By.id("location")), "Canadian Development Center");
		
		click(driver.findElement(By.id("modal-save-button")));
		
		waitForVisibility(By.id("pimPersonalDetailsForm"));
		
		WebElement name = driver.findElement(By.id("pim.navbar.employeeName"));
		
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(name.isDisplayed(), "Employee not added succesfully");
		
		wait(3);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
