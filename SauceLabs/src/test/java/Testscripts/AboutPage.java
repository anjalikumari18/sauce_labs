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
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseClassUtility.BaseClass;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import Utilities.PropertyFileUtility;
import Utilities.WebDriverUtility;

public class AboutPage extends BaseClass
{
	@Test(groups = "smoke")
	public void AboutPageTest() throws InterruptedException, IOException {
		Thread.sleep(3000);
		HomePage hp=new HomePage(driver);
		
		hp.getOpen_menu_button().click();
     	hp.getAbout_page_link().click();
		
		//Take ss of About Page
		TakesScreenshot tks=(TakesScreenshot)driver;
		File temp = tks.getScreenshotAs(OutputType.FILE);
		File perm=new File("./Errorshots/aboutus.png");
		FileHandler.copy(temp, perm);
			
		String expected_text = "Build apps users love with AI-driven qual";
		WebElement main_title = driver.findElement(By.xpath("//h1[text()='Build apps users love with AI-driven quality']"));
		String title_text = main_title.getText();
		System.out.println(title_text);
		
		//verification
		/*if(title_text.contains(expected_text)) {
			System.out.println("About us page is navigated successfully");
		}else
			System.out.println("We are not on correct page");
		
		*/
		//Hard Assert
		//Assert.assertEquals(title_text, expected_text,"incorrect page");
		
		//Soft assert implementation
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(title_text, expected_text,"Incorrect page");
		driver.navigate().back();

		soft.assertAll();
	}

	}
