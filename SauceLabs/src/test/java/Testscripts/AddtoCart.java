package Testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClassUtility.BaseClass;
import ObjectRepository.CheckOutPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import Utilities.ExcelFileUtility;

public class AddtoCart extends BaseClass{

	@Test (groups = {"smoke","regression"})
	public void AddToCartTest() throws IOException, InterruptedException
	{
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//button[text()='Add to cart'])[1]")).click();
		driver.findElement(By.xpath("(//button[text()='Add to cart'])[2]")).click();
		driver.findElement(By.xpath("(//button[text()='Add to cart'])[3]")).click();
		
		driver.findElement(By.id("shopping_cart_container")).click();
		CheckOutPage cp=new CheckOutPage(driver);
		cp.getCheckout_button().click();
		//driver.findElement(By.id("checkout")).click();
		
		ExcelFileUtility eutil=new ExcelFileUtility();
		String fn = eutil.getDataFromExcelFile("Sheet1", 0, 1);
		String ln = eutil.getDataFromExcelFile("Sheet1", 1, 1);
		String pin = eutil.getDataFromExcelFile("Sheet1", 2, 1);

		//Test data
		driver.findElement(By.id("first-name")).sendKeys(fn);
		driver.findElement(By.id("last-name")).sendKeys(ln);
		driver.findElement(By.id("postal-code")).sendKeys(pin);
		driver.findElement(By.id("continue")).click();
		
		driver.findElement(By.id("finish")).click();
		
		WebElement checkout_image = driver.findElement(By.id("checkout_complete_container"));
		File temp = checkout_image.getScreenshotAs(OutputType.FILE);
		File perm=new File("./Errorshots/orderconfirm.png");
		FileHandler.copy(temp, perm);
		
		String expected_confmsg = "Thank you for your order";
		WebElement conf_msg = driver.findElement(By.xpath("//h2[text()='Thank you for your order!']"));
		String actual_confmsg = conf_msg.getText();
		System.out.println(actual_confmsg);
		/*
		if(actual_confmsg.contains(expected_confmsg)) {
			System.out.println("Product added to cart successfully");
		}else
		{
			System.out.println("Product could not be added. Failure detected");
		}
		*/
		
		Assert.assertEquals(actual_confmsg, expected_confmsg,"Product not added");
		
		}

}
