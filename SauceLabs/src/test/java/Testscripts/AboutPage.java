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

public class AboutPage {

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
		
		driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
		driver.findElement(By.linkText("About")).click();
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
		driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
		driver.findElement(By.linkText("Logout")).click();
		driver.close();

		
		
		
		
		
		


	}

}
