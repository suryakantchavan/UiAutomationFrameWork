package driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
	private DriverManager()
	{
		
	}
	
	
	private static ThreadLocal<WebDriver> dr= new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver()
	{
		return dr.get();
	}
	
	
	static void setDriver(WebDriver driverRef)
	{
		if(Objects.nonNull(driverRef))
		{
			dr.set(driverRef);
		}
	}
	
	static void unload()
	{
		dr.remove();
	}

}
