package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	
	//getting dataprovider from different class
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_LoginDDT(String email,String pswd,String exp) {
		logger.info("******Starting TC003_Login test***********");

	try {	
		//Home Page
		HomePage hp1=new HomePage(driver);
		hp1.clickMyAccount();
		hp1.clickLogin();
		
		//Login Page
		LoginPage lp=new LoginPage(driver);
	//	lp.setEmail(p.getProperty("email"));
		lp.setEmail(email);
	//	lp.setPassword(p.getProperty("password"));
		lp.setPassword(pswd);

		lp.clickLogin();
		
		//MyAccount Page
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExist();
	//	Assert.assertEquals(targetPage,true,"Login failed");
		Assert.assertTrue(targetPage);
		
		
		
		
		/*Data is valid-login success-testpass-logout
		                login failed-test fail
		  Data is invalid- login success - test fail  -logout
		                   login failed-     test pass*/
		
		
		if(exp.equalsIgnoreCase("Valid")){
			if(targetPage==true) {
				macc.clickLogout();

				Assert.assertTrue(true);
				macc.clickLogout();
			}else {
				Assert.assertTrue(false);
			}
			
		}
		
		
		if(exp.equalsIgnoreCase("Invalid")) {
			if(targetPage==true) {
				macc.clickLogout();
				Assert.assertTrue(false);

				
			}else {
				Assert.assertTrue(true);

			}
				
		}
		
		
		
		
		
		
	}catch(Exception e) {
		Assert.fail();
		
	}
	
	
	
	
	logger.info("************Finished TC003_LoginDDT************" );
		
		

}
}

	
	


