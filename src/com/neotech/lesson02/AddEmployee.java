package com.neotech.lesson02;

import org.testng.annotations.Test;

public class AddEmployee {

	@Test(priority = 2)
	public void test5() {
		System.out.println("test1");
	}

	@Test(priority = 0)
	public void test2() {
		System.out.println("test2");

	}

	@Test(priority = 2)
	public void test3() {
		System.out.println("test3");

	}
}