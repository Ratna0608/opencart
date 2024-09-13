package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
	
	 public RegistrationPage(WebDriver driver) {
		 super(driver);
	 }
	 
	 @FindBy(xpath="//input[@id='input-firstname']")
	 WebElement Firstname;
	 
	 @FindBy(xpath="//input[@id='input-lastname']")
	 WebElement Lastname;
	 
	 @FindBy(xpath="//input[@id='input-email']")
	 WebElement Email;
	 
	 @FindBy(xpath="//input[@id='input-password']")
	 WebElement password;
	 
	 @FindBy(xpath="//input[@name='agree']")
	 WebElement rbtnpolicy;
	 
	 @FindBy(xpath="//button[normalize-space()='Continue']")
	 WebElement coutinuebtn;
	 

     @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']"	 )
     WebElement cnfmmsg;
     
     
     public void setFirstname(String fname) {
    	 Firstname.sendKeys(fname);
     }
     
     public void setLastname(String Lname) {
    	 Lastname.sendKeys(Lname);
     }
     
     public void setEmail(String E_mail) {
    	 Email.sendKeys(E_mail);
     }
     
     public void setPassword(String pswd) {
    	 password.sendKeys(pswd);
     }
     public void clickrbnt() {
    	 rbtnpolicy.click();
     }
     public void clickCountinue() {
    	 coutinuebtn.click();
    	 
     }
     
     public String getConfirmmsg() {
    	 try {
    	 
    	return cnfmmsg.getText();
    	
    	 
     }catch(Exception e) {
    	 return e.getMessage();
     }
	

}
}
