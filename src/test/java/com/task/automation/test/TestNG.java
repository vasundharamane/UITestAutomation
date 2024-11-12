package com.task.automation.test;

import org.testng.annotations.*;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;

public class TestNG {


	  @Test(dataProvider = "dp")
	  public void f(Integer n, String s) {
	   System.out.println(n + s);
	  }
	  @BeforeMethod
	  public void beforeMethod() {
	   System.out.println("Beforemethod:");
	  }
	  @AfterMethod
	  public void afterMethod() {
	   System.out.println("Aftermethod:");
	  }
	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { 1, "a" },
	      new Object[] { 2, "b" }
	    };
	  }
	  @BeforeClass
	  public void beforeClass() {
	   System.out.println("Beforeclass:");
	  }

	  @AfterClass
	  public void afterClass() {
	   System.out.println("AfterClass");
	  }

	  @BeforeTest
	  public void beforeTest() {
	   System.out.println("BeforeTest:");
	  }

	  @AfterTest
	  public void afterTest() {
	   System.out.println("AfterTest");
	  }

	  @BeforeSuite
	  public void beforeSuite() {
	   System.out.println("BeforeSuite");
	  }

	  @AfterSuite
	  public void afterSuite() {
	   System.out.println("AfterSuite");
	  }

	}