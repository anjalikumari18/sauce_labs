package BaseClassUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import Utilities.PropertyFileUtility;
import Utilities.WebDriverUtility;

public class BaseClass {
	
	public WebDriver driver;	
	public PropertyFileUtility putil=new PropertyFileUtility();

	public HomePage hp;
	public LoginPage lp;
	
	
	@BeforeSuite (groups = { "smoke","regression" })
	public void configBS() {
		Reporter.log("DB Connectivity",true);
	}
	
	@BeforeTest (groups = { "smoke","regression" })
	public void configBT() {
		Reporter.log("Pre-condition if any",true);
	}
	
	//@Parameters("Browser") //cbt
	@BeforeClass (groups = { "smoke","regression" })
	public void configBC(/*String brow*/) throws IOException {
		
		String URL = putil.getDataFromPropertiesFile("url");
		//String BROWSER=brow; //cbt
		String BROWSER = putil.getDataFromPropertiesFile("browser");
        //System.out.println(BROWSER);
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else
		{
			driver=new ChromeDriver();
		}
		//driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		WebDriverUtility wutil=new WebDriverUtility();
		wutil.implicitWait(driver, 15);
		driver.get(URL);
		Reporter.log("Browser configuration done",true);
	}
	
	
	@BeforeMethod (groups = { "smoke","regression" })
	public void configBM() throws IOException {
		String USER = putil.getDataFromPropertiesFile("username");
		String PASSWORD = putil.getDataFromPropertiesFile("password");
		lp=new LoginPage(driver);
        lp.LoginAction(USER, PASSWORD);
		Reporter.log("Logged in",true);
	}
	
	@AfterMethod (groups = { "smoke","regression" })
	public void configAM() {
		hp=new HomePage(driver);
		hp.LogoutAction();
		Reporter.log("Logged out of the application",true);
	
	}
	
	
	@AfterClass (groups = { "smoke","regression" })
	public void configAC() {
		driver.quit();
	    Reporter.log("Browser closed successfully",true);

	}
	
	@AfterTest (groups = { "smoke","regression" })
	public void configAT() {
	    Reporter.log("Post-condition if any",true);

	}
	
	@AfterSuite (groups = { "smoke","regression" })
	public void configAS() {
		Reporter.log("DB Disconnected + Report Backed up", true);
	}
	

}
