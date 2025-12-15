package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageclass.homepagepom;
import pageclass.loginpagepom;
import pageclass.myaccountpage;

public class loginTestcase  extends testbase{
	
	@Test (groups="Sanity")
	void logintest()
	{
		
		
		///
		homepagepom  hp1= new homepagepom (driver);
		hp1.clickmyname1();
		hp1.clickmylogin();
		
		
		// login page 
		
		 loginpagepom lp= new  loginpagepom(driver);
		 lp.loginname(P.getProperty("email"));
		 lp.passname(P.getProperty("password"));
		 lp.clickname();
		 
		 
		 // account page verification 
		 
		 myaccountpage  myacc=new myaccountpage(driver);
		 boolean targetpage = myacc.verifydisplay();
		 {
			 try
			 {
				 Assert.assertEquals(targetpage, true);
			 }
			 catch (Exception e)
			 {
				 Assert.fail();
			 }
		 }
		 
		
		 
		 
	}
	
	

}
