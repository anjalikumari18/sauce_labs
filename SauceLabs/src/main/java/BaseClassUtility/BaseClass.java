package BaseClassUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import Utilities.PropertyFileUtility;
import Utilities.WebDriverUtility;

public class BaseClass {
	
	public WebDriver driver;
	public HomePage hp;
	public LoginPage lp;
	public PropertyFileUtility putil=new PropertyFileUtility();
	
	
	@BeforeSuite
	public void configBS() {
		Reporter.log("DB Connectivity",true);
	}
	
	@BeforeTest
	public void configBT() {
		Reporter.log("Pre-condition if any",true);
	}
	
	
	@BeforeClass
	public void configBC() throws IOException {
		
		PropertyFileUtility putil=new PropertyFileUtility();
		String URL = putil.getDataFromPropertiesFile("url");						
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverUtility wutil=new WebDriverUtility();
		wutil.implicitWait(driver, 15);
		driver.get(URL);
		Reporter.log("Browser configuration done",true);
	}
	
	
	@BeforeMethod
	public void configBM() throws IOException {
		//Applied webelelements from Object Repo : LoginPage
		String USER = putil.getDataFromPropertiesFile("username");
		String PASSWORD = putil.getDataFromPropertiesFile("password");
		LoginPage lp=new LoginPage(driver);
        lp.LoginAction(USER, PASSWORD);
		Reporter.log("Logged in",true);
	}
	
	@AfterMethod
	public void configAM() {
		HomePage hp=new HomePage(driver);
		hp.LogoutAction();
		Reporter.log("Logged out of the application",true);
	
	}
	
	
	@AfterClass
	public void configAC() {
		driver.close();
	    Reporter.log("Browser closed successfully",true);

	}
	
	@AfterTest
	public void configAT() {
	    Reporter.log("Post-condition if any",true);

	}
	
	@AfterSuite
	public void configAS() {
		Reporter.log("DB Disconnected + Report Backed up", true);
	}
	

}
