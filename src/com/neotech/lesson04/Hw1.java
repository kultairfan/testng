package com.neotech.lesson04;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.ExcelUtility;

public class Hw1 extends CommonMethods {
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

	@Test(dataProvider = "getData",groups = {"homework","smoke"})
	public void addEmployee(String firstName, String lastName, String userName, String password) {
		// Login
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));

		click(driver.findElement(By.xpath("//button")));
		// Pım and add employee
		wait(3);
		click(driver.findElement(By.id("menu_pim_viewPimModule")));

		click(driver.findElement(By.id("menu_pim_addEmployee")));
		waitForVisibility(By.id("first-name-box"));
		// enter new employee data
		sendText(driver.findElement(By.id("first-name-box")), firstName);
		sendText(driver.findElement(By.id("last-name-box")), lastName);

		// employe ıd
		String empId = driver.findElement(By.id("employeeId")).getDomProperty("value");

		selectDropdown(driver.findElement(By.id("location")), "Chinese Development Center");

		// activate and enter the login details --> Create Login Details
		click(driver.findElement(By.cssSelector("div[class='custom-control custom-switch']")));

		// add
		sendText(driver.findElement(By.id("username")), userName);
		sendText(driver.findElement(By.id("password")), password);

		sendText(driver.findElement(By.id("confirmPassword")), password);

		// save the employee data

		wait(2);
		click(driver.findElement(By.id("modal-save-button")));

		// Verify employee Details !!!!!!!!!!!!
		// make sure the employee details are visible/displayed
		waitForVisibility(By.id("firstName"));

		// Let's assert the actual employee firstName with expected employee firstName
		String actualFirstName = driver.findElement(By.id("firstName")).getDomProperty("value");

		Assert.assertEquals(actualFirstName, firstName, "Employee firstName does not match!");

		// take a screenshot

		// First wy:
		// we do all step here

		/*
		 * TakesScreenshot ts = (TakesScreenshot) driver;
		 * 
		 * File source = ts.getScreenshotAs(OutputType.FILE);
		 * 
		 * try { Files.copy(source, new
		 * File("screenshots/"+firstName+"_"+lastName+".png")); 
		 * } catch (IOException e)
		 * { e.printStackTrace(); }
		 * 
		 */

//		Or --> more professional style --> we create a takeScreenshot() method in CommonMethods

		String fullName = firstName + "_"+ lastName;
		takeScreenshot(fullName);

	}

	@DataProvider(name = "getData")
	public Object[][] createData() {
		Object[][] data = { { "AliEmp0001211", "L_Emp000114488", "emloyee00011", "!emP00011" },
				{ "ErenEmp00232", "L_Emp0402255", "emloyee002299", "!emP000022" }, 
				{ "OmerEmp00423", "L_Emp0402312", "emloyee002377", "!emP000023" }, };

		return data;

	}
	@DataProvider(name="excelData")
	public Object [][] getExcelData()
	{
		String filePath = System.getProperty("user.dir")+ "testdata/Excel.xlsx";
		
		String sheetName = "Employee";
		return ExcelUtility.excelIntoArray(filePath, sheetName);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
