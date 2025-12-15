package testcase;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageclass.homepagepom;
import pageclass.loginpagepom;
import pageclass.myaccountpage;
import utilities.Dataproviders;

public class datadriventestcase extends testbase {
	
	@Test(dataProvider = "loginData", dataProviderClass = Dataproviders.class, groups= {"functionalTesting"})

	public void verifylogindata(String email, String pwd, String exp )
	
	
	{
		try	
	
	{
		homepagepom  hp1= new homepagepom (driver);
		hp1.clickmyname1();
		hp1.clickmylogin();
		
		
		// login page 
		
		 loginpagepom lp= new  loginpagepom(driver);
		 lp.loginname(email);
		 lp.passname(pwd);
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
		 
		// ✅ VALID data case
         if (exp.equalsIgnoreCase("valid"))
         {
             if (targetpage)
             {
                 myacc.logoutfrom();
                 Assert.assertTrue(true, "Valid login passed as expected.");
             }
             else
             {
                 Assert.fail("Valid login failed – My Account page not displayed.");
             }
         }
         // ✅ INVALID data case
         else if (exp.equalsIgnoreCase("invalid"))
         {
             if (!targetpage)
             {
                 Assert.assertTrue(true, "Invalid login correctly rejected.");
             }
             else
             {
                 myacc.logoutfrom();
                 Assert.fail("Invalid login was accepted – this is a bug.");
             }
         }
         else
         {
             Assert.fail("Test data error: exp must be 'valid' or 'invalid'");
         }
     }
     catch (Exception e)
     {
         Assert.fail("Test execution failed with exception: " + e.getMessage());
     }
 }
}
