package testcase;

import org.testng.annotations.Test;

import pageclass.homepagepom;
import pageclass.registerpagepom;

public class tc__001 extends testbase {

	

	// grid // http://10.201.139.119:4444
	
	@Test (groups={"Regression", "Sanity"})
	void testregister()
	{
		homepagepom hp= new homepagepom(driver);
		hp.clickmyname1();
		hp.clickmyregister1();
		
		
		
		registerpagepom rp=new registerpagepom (driver);
		rp.firstname2( RandomString().toLowerCase());
		rp.lastname2(RandomString().toLowerCase());
		rp.emailid3(RandomString().toLowerCase()+"@gmail.com");
		rp.telephone1( Randomnumber());
		
		
		
		String pwd=Randomnumber1();
		rp.password1(pwd);
		rp.confirmpassword1(pwd);
		rp.newsletter1();
		rp.privacy1();
		rp.continuing();
		
		
		
	}
	
}
	
