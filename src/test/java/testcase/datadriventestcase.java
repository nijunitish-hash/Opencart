package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageclass.homepagepom;
import pageclass.loginpagepom;
import pageclass.myaccountpage;
import utilities.Dataproviders;

public class datadriventestcase extends testbase {

    @Test(dataProvider = "loginData",
          dataProviderClass = Dataproviders.class,
          groups = {"functionalTesting"})
    public void verifylogindata(String email, String pwd, String exp) {

        homepagepom hp = new homepagepom(driver);
        hp.clickmyname1();
        hp.clickmylogin();

        loginpagepom lp = new loginpagepom(driver);
        lp.loginname(email);
        lp.passname(pwd);
        lp.clickname();

        myaccountpage myacc = new myaccountpage(driver);
        boolean targetpage = myacc.verifydisplay();

        if (exp.equalsIgnoreCase("valid")) {
            Assert.assertTrue(targetpage, "Valid login failed");
            myacc.logoutfrom();
        } else {
            Assert.assertFalse(targetpage, "Invalid login passed");
        }
    }
}
