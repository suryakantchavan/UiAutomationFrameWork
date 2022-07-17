package pages;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	private static final Logger logger = LogManager.getLogger(LoginPage.class);
	WebDriver driver;
	

	
	@FindBy(xpath="//input[@name='email']")
	WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwd;
	

	
	public LoginPage(WebDriver driver){
		
		
		this.driver=driver;
		System.out.println("value of driver is from login page" +driver);
		PageFactory.initElements(driver, this);

	}
	
	
	public void login()
	{
		userName.sendKeys("hiii");
	
	}
	
}
