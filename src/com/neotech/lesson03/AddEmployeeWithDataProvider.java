package com.neotech.lesson03;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.io.Files;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class AddEmployeeWithDataProvider extends CommonMethods {
	
//	Open chrome browser
//	Go to "https://hrm.neotechacademy.com/"
//	Login to the application
//	Add 3 different Employees and Create Login Details by providing:
//	First Name
//	Last Name
//	Username
//	Password
//	Verify Employee has been added successfully and take screenshot (you must have 3 different screenshots)
//	Close the browser
//	Specify a group for this test case, add it into specific suite and execute from the xml file.
	@Test(dataProvider = "employees")
	public void addEmployee(String firstName, String lastName,String userName,String password) 
	{
		//System.out.println(firstName+ " "+ lastName);
		
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));

		click(driver.findElement(By.xpath("//button")));
		
		wait(3);
		click(driver.findElement(By.id("menu_pim_viewPimModule")));
		
		click(driver.findElement(By.id("menu_pim_addEmployee")));
		waitForVisibility(By.id("first-name-box"));
		
		sendText(driver.findElement(By.id("first-name-box")), firstName);
		sendText(driver.findElement(By.id("last-name-box")), lastName);
		selectDropdown(driver.findElement(By.id("location")), 4);
		
		//Create Login Details
		click(driver.findElement(By.xpath("//div[@class='custom-control custom-switch']")));
		
		sendText(driver.findElement(By.id("username")), userName);
		sendText(driver.findElement(By.id("password")), password);
		
		sendText(driver.findElement(By.id("confirmPassword")), password);
		
		click(driver.findElement(By.id("modal-save-button")));
		
		waitForVisibility(By.xpath("//*[@id='personal_details_tab']/h4"));
		
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			Files.copy(source, new File("screenshots/"+firstName+"_"+lastName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
	@DataProvider(name="employees")
	public Object[][] employeeData()
	{
		Object[][] data = {
				{"John","Doe","khurliman","12341ad2415"},
				{"Jane","Doe","elifaaa","41441af24151"},
				{"Emrah","Sezer","Aselaaaa","8121541asd248"}
		
		
		};
		
		
		
		return data;
	}
}
