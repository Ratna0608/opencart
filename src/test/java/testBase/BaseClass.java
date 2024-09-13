package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
//import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@Parameters({"os","browser"})
	@BeforeClass(groups= {"sanity","regression","master"})
	public void setUp(String os,String br) throws IOException {
		logger= (Logger) LogManager.getLogger(this.getClass());
		//logger=LogManager.getLogger(this.getClass())
		FileReader file=new FileReader(".//src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap=new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("No Matching OS");
				return;
			}
			switch(br.toLowerCase()) {
			case "chrome":cap.setBrowserName("chrome");break;
			case "edge":cap.setBrowserName("MicrosoftEdge");break;
			default:System.out.println("No Matching browser");return;
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			
			
			
		}
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
		
		switch(br.toLowerCase()) {
		case "chrome":driver=new ChromeDriver();break;
		case "edge":driver=new EdgeDriver();break;
		case "firefox":driver=new FirefoxDriver();break;
		default:System.out.println("Invalid browser");return;
		}
		}
		
		
		
		
		
		
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//driver.get("https://demo.opencart.com/");	
		driver.get(p.getProperty("appUrl1"));//reading url from properties file
		
		driver.manage().window().maximize();
		
	}
	
	
	@AfterClass(groups= {"sanity","regression","master"})
	public void tearDown() {
		driver.quit();
		
	}
	
	public String RandomString() {
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
		
	}
	
	public String RandomNumeric() {
		String generatedNumber=RandomStringUtils.randomNumeric(6);
		return generatedNumber;
	}
	public String RandomAlphaNumeric()
	{
	    String generatedString=RandomStringUtils.randomAlphanumeric(6);
		return generatedString;
	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	
	 


}
