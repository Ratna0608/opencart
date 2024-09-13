package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	WebDriver driver ;

		
	@Test(groups={"regression","master"})
	public void verify_Account_registration()
	
	{
		logger.info("*********Starts Tc001_Accountregistration*********");
		try {
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on Account");
		hp.clickRegister();
		logger.info("Clicked on register");
		
		RegistrationPage regpag=new RegistrationPage(driver) ;
		logger.info("Providing customer details");
		
		regpag.setFirstname("Ratna");
		
//		regpag.setFirstname(RandomString().toUpperCase());
		
		
		regpag.setLastname("Naru");
		
//		regpag.setLastname(RandomString().toUpperCase());
		
		
		regpag.setEmail("ratna@gmail.com");
		
		
		
		
//		regpag.setEmail(RandomString()+"@gmail.com");
		
		
		
	//	String paswd=RandomAlphaNumeric();
		//regpag.setPassword(paswd);
		
		regpag.setPassword("Ratna123");
		
		regpag.clickrbnt();
		regpag.clickCountinue();
		
		logger.info("Validating expected message");
		
		
		String msg=regpag.getConfirmmsg();
		if(msg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}else {
			logger.error("Test failed");
			logger.debug("Debug logs...");
		}
		}
		catch(Exception e) {
		//	logger.error("Test failed");
			//logger.debug("Debug logs...");
			Assert.fail();
		}
		
			
		logger.info("******Finished TC00l_accountregistrationTest");
		
	}

	
	
	

}
