package Testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import Utilities.PropertyFileUtility;
import Utilities.WebDriverUtility;

public class AboutPage {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		PropertyFileUtility putil=new PropertyFileUtility();
		String URL = putil.getDataFromPropertiesFile("url");
		String USER = putil.getDataFromPropertiesFile("username");
		String PASSWORD = putil.getDataFromPropertiesFile("password");
						
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverUtility wutil=new WebDriverUtility();
		wutil.implicitWait(driver, 15);
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		
		//Applied webelelements from Object Repo : LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.LoginAction(USER, PASSWORD);
		
		
		/*
		lp.getUsernametf().sendKeys(USER);
		lp.getPasswordtf().sendKeys(PASSWORD);
		lp.getLoginbutton().click();
		*/
		
	
		Thread.sleep(3000);
		HomePage hp=new HomePage(driver);
		
		hp.getOpen_menu_button().click();
     	hp.getAbout_page_link().click();
		
		//Take ss of About Page
		TakesScreenshot tks=(TakesScreenshot)driver;
		File temp = tks.getScreenshotAs(OutputType.FILE);
		File perm=new File("./Errorshots/aboutus.png");
		FileHandler.copy(temp, perm);
		
		
		String expected_text = "Build apps users love with AI-driven quality";
		WebElement main_title = driver.findElement(By.xpath("//h1[text()='Build apps users love with AI-driven quality']"));
		String title_text = main_title.getText();
		System.out.println(title_text);
		
		//verification
		if(title_text.contains(expected_text)) {
			System.out.println("About us page is navigated successfully");
		}else
			System.out.println("We are not on coorect page");
		driver.navigate().back();
		
		//Logout code
		hp.LogoutAction();
		driver.close();

		
		
		
		
		
		


	}

}
