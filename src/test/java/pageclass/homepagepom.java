package pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homepagepom extends baseclass{
	
	// constructor
	public homepagepom ( WebDriver driver)
	{
	super(driver);	
	}
	
	
	// with page factory
	
	//locators


By clickmyname=By.xpath("//a[@title='My Account']//span[1]");
By clickmyregister=By.xpath("//a[normalize-space()='Register']");

By clickmylogin=By.xpath("//a[normalize-space()='Login']");

//action methods

public void clickmyname1() {
	driver.findElement(clickmyname).click();
}

public void clickmyregister1() {
	driver.findElement(clickmyregister).click();
}

public void clickmylogin()
{
	driver.findElement(clickmylogin).click();
}




}










