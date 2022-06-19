package com.LMAUTOmation.APMAutomation.cases;


import java.lang.reflect.Method;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Common.BaseTest;
import driver.DriverManager;
import pages.LoginPage;


public class TestCase1 extends BaseTest {
	
	
	private static	Logger logger = LogManager.getLogger(TestCase1.class);

	WebDriver driver=null;
	
	LoginPage page;

	
	
	
	@BeforeClass
	public void setup()
	
	{
		driver= DriverManager.getDriver();
		System.out.println(Objects.isNull(driver));
		System.out.println("value of driver is" +driver);
		page = new LoginPage(driver);
	}
	
	@Test
	public void test1(Method method)	
	{
		page.login();
		takeScreenShot(driver, this, method.getName(), "loginPage");

	}
	

	
	
	
	
	
}
