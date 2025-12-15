//package pageclass;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public class registerpagepom extends baseclass {
//
//    public registerpagepom(WebDriver driver) {
//        super(driver);
//    }
//
//    By firstname = By.xpath("//input[@placeholder='First Name']");
//    By lastname = By.xpath("//input[@placeholder='Last Name']");
//    By emailid = By.xpath("//input[@placeholder='E-Mail']");
//    By telephone = By.xpath("//input[@placeholder='Telephone']");
//    By password = By.id("input-password");
//    By confirmpassword = By.id("input-confirm");
//    By newsletter = By.xpath("//label[@class='radio-inline']//input");
//    By privacy = By.xpath("//input[@type='checkbox']");
//    By btncontinue = By.xpath("//input[@value='Continue']");
//
//    public void firstname2(String name) {
//        driver.findElement(firstname).sendKeys(name);
//    }
//
//    public void lastname2(String namelast) {
//        driver.findElement(lastname).sendKeys(namelast);
//    }
//
//    public void emailid3(String emailid1) {
//        driver.findElement(emailid).sendKeys(emailid1);
//    }
//
//    public void telephone1(String phone) {
//        driver.findElement(telephone).sendKeys(phone);
//    }
//
//    public void password1(String passwd) {
//        driver.findElement(password).sendKeys(passwd);
//    }
//
//    public void confirmpassword1(String passwd) {
//        driver.findElement(confirmpassword).sendKeys(passwd);
//    }
//
//    public void newsletter1() {
//        driver.findElement(newsletter).click();
//    }
//
//    public void privacy1() {
//        driver.findElement(privacy).click();
//    }
//
//    public void continuing() {
//        driver.findElement(btncontinue).click();
//    }
//}

package pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class registerpagepom extends baseclass{
	
	public registerpagepom (WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	
	
	By firstname=By.xpath("//input[@placeholder='First Name']");
	By lastname=By.xpath("//input[@placeholder='Last Name']");
	By emailid=By.xpath("//input[@placeholder='E-Mail']");
	By telephone =By.xpath("//input[@placeholder='Telephone']");
	By password= By.id("input-password");
	
	By confirmpassword= By.id("input-confirm");
	By newsletter =By.xpath("//label[@class='radio-inline']//input");
	By privacy=By.xpath("//input[@type='checkbox']");
	By btncontinue=By.xpath("//input[@value='Continue']");
	

	
	
	//action methods 
	
	public void firstname2(String name)
	{
		driver.findElement(firstname).sendKeys(name);
	}
	
	public void lastname2(String namelast)
	{
		driver.findElement(lastname).sendKeys(namelast);
	}
	public void emailid3 (String emailid1)
	{
		driver.findElement(emailid).sendKeys(emailid1);
	}
	public void telephone1(String phone) {
		driver.findElement(telephone).sendKeys(phone);
			
		}
	
	public void password1(String passwd)
	{
		driver.findElement(password ).sendKeys(passwd);
	}
	public void confirmpassword1(String password)
	{
		driver.findElement(confirmpassword).sendKeys(password);
	}
	public void newsletter1()
	{
		driver.findElement(newsletter).click();;
	}
	public void privacy1()
	{
		driver.findElement(privacy ).click();;
	}
	public void continuing()
	{
		driver.findElement(btncontinue).click();
	}
	
	
	

}

