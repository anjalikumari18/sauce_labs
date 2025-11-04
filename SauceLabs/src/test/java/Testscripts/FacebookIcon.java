package Testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookIcon {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\Desktop\\ClassDocs\\saucelab_credentials.properties");

		Properties prop=new Properties();
		prop.load(fis);
		String URL = prop.getProperty("url");
		String USER = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		
		driver.findElement(By.id("user-name")).sendKeys(USER);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		
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
		
		//Logout code
		driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
		driver.findElement(By.linkText("Logout")).click();
		driver.quit();

		
		
		
		
		
		
		
		
		
	}

}
