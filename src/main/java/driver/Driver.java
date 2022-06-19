package driver;


import java.util.Objects;

import org.openqa.selenium.WebDriver;

public class Driver {
	
	
	private Driver()
	{
		
		
	}

	

	
	public static void initDriver(String browser, String url) throws InterruptedException
	{
		if(Objects.isNull(DriverManager.getDriver()))
		{
			DriverManager.setDriver(DriverFactory.getDriver(browser));
		}
		
		DriverManager.getDriver().get(url);
		Thread.sleep(9000);
	}
	
	
	public static void  quitDriver()
	{
		if(Objects.nonNull(DriverManager.getDriver()))
		{
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
