package Common;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import driver.Driver;




public class BaseTest {
	
	
	String pathForTakingScreenShot=null;
	private static File directory=null;
	
	private static Logger logger = LogManager.getLogger(BaseTest.class);
	
	
	@BeforeSuite
	public void createScreenshotfolder(ITestContext context)
	{
		try
		{
			pathForTakingScreenShot=System.getProperty("user.home")+"/Screenshot/"+context.getSuite().getName()+"/";
			if(!(pathForTakingScreenShot.contains("null")))
			{
				directory= new File(pathForTakingScreenShot);
				if(directory.exists())
				{
					logger.info("screenshot dir already exists ..deleting it");
					FileUtils.cleanDirectory(directory);
					FileUtils.forceDelete(directory);
					logger.info("screenshot directory deleted");
				}
				
				FileUtils.forceMkdir(directory);
				logger.info("screenshot diretrcory created at path " +directory);
			}
			else
			{
				logger.info("screenshot diretrcory returned null");
			}
			
		}
		
		catch(Exception e)
		{
			logger.error("exception while trying to create screnshot  directory ");
		}
	}
	

	@BeforeClass
	public void initializeBrowser() throws InterruptedException
	{
		String browser="chrome";
		System.out.println("browser name is" +browser);
		String url="https://ui.freecrm.com/";

		Driver.initDriver(browser, url);
	}
	
	
	public void takeScreenShot(WebDriver driver, Object classCalled, String methodName, String custMsg)
	{
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
			String destination="./ScreenshotsFailure/"+classCalled.getClass().getSimpleName()+"/"+methodName+"/"+custMsg+".png";
			logger.info("screen shot captured" +destination);
			
			FileUtils.copyFile(src, new File(destination));
		}
		catch (Exception e) {
		 logger.error("Unable to save the screenshot due to error");
		}
		
		logger.info("screen shot captured");
		
	}
	
	

}
