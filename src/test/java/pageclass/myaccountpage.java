package pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class myaccountpage  extends baseclass{
	
	public myaccountpage (WebDriver driver)
	{
		super(driver);
	}
	
	
	
	By displaymyaccount =By.xpath("//div//h2[contains(.,'My Account')]");
	By logout= By.xpath("//div[@class='list-group']//a[text()='Logout']");
	
	
	 public boolean verifydisplay()
	{
		try
		{
			boolean status=driver.findElement(displaymyaccount).isDisplayed();
			return status; 
		}
		catch(Exception e) 
		{
			return false;
		}
		
	}
	 
	 
	 public void logoutfrom()
	 {
		 driver.findElement(logout).click();
	 }

}
