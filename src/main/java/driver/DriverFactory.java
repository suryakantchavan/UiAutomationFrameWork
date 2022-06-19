package driver;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	private DriverFactory()
	{
		
	}
	
	public static WebDriver getDriver(String browser)
	{
		
		WebDriver driver = null;
		switch(browser)
		{
		case DriverUtils.BROWSER_CHROME:
			WebDriverManager.chromedriver().setup();
			driver=DriverUtils.getWebDriver(DriverUtils.BROWSER_CHROME);
			driver.manage().window().maximize();
		
		}
		
		return driver;
		
	}

}
