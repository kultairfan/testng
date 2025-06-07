package com.neotech.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
public void onTestStart(ITestResult result) 
{
	System.out.println(result.getName()+ " test just starting!");
		   
}
public void onTestSuccess(ITestResult result) 
{
	System.out.println(result.getName()+ " test just passed!");

  }
public void onTestFailure(ITestResult result) {
	System.out.println(result.getName()+ " test just failed!");

  }


public void onStart(ITestContext context) {
   System.out.println("Functionality test started!");
  }


public void onFinish(ITestContext context) {
	   System.out.println("Functionality test Finished!");
	  }
















}
