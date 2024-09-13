package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"sanity","master"})
	public void verify_Login() {
		logger.info("******Starting TC002 Login test***********");
		try {
		
		//Home Page
		HomePage hp1=new HomePage(driver);
		hp1.clickMyAccount();
		hp1.clickLogin();
		
		//Login Page
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccount Page
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExist();
	//	Assert.assertEquals(targetPage,true,"Login failed");
		Assert.assertTrue(targetPage);
		
	}
		
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("****************Finished TC_002_LoginTest*************");
	

}
}
