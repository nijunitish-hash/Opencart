package pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginpagepom extends baseclass
{// constructors
	
	public loginpagepom (WebDriver driver)
	{
		super(driver);
	}
	
	// locators 
	
	By loginpageid=By.xpath("//input[@placeholder='E-Mail Address']");
	By passwordid= By.xpath("//input[@placeholder='Password']");
	By clickid= By.xpath("//input[@value='Login']");
	
	
	
	
	// action methods
	
	public void loginname(String loginpagename)
	{
		driver.findElement(loginpageid).sendKeys(loginpagename);
	}
	
	public void passname(String passpagename)
	{
		driver.findElement(passwordid).sendKeys(passpagename);
	}
	
	public void clickname()
	{
		driver.findElement(clickid).click();
	}

}







