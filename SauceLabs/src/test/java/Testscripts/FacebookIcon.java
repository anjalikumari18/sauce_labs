package Testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import BaseClassUtility.BaseClass;

public class FacebookIcon extends BaseClass{

	@Test(groups = "regression")
	public void FacebookTest() throws InterruptedException {
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Facebook")).click();
		String parent_id = driver.getWindowHandle();
		Set<String> allIds = driver.getWindowHandles();
		allIds.remove(parent_id);
		for(String id: allIds ) {
			driver.switchTo().window(id);
			driver.findElement(By.name("email")).sendKeys("Anjali");
		}
		
		driver.switchTo().window(parent_id);
		driver.navigate().to("https://www.saucedemo.com/inventory.html");					
	}
	}
