package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement Registerbtn;
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement Loginbtn;
	
	public void clickMyAccount() {
		lnkMyAccount.click();
	}
	
	public void clickRegister() {
		Registerbtn.click();
	}
	public void clickLogin() {
		Loginbtn.click();
	}

}
