package driver;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverUtils {

	public static final String BROWSER_FIREFOX="firefox";

	public static final String BROWSER_CHROME="chrome";
	
	public static WebDriver getWebDriver(String browser)
	{
		switch(browser)
		{
		
		case BROWSER_CHROME:
			
			return new ChromeDriver();
		default:
			throw new IllegalArgumentException(String.format("browser % not found", browser));
		
		}
	
	}
	
}
