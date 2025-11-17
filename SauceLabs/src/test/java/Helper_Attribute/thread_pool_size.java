package Helper_Attribute;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class thread_pool_size {
	WebDriver driver;
	
	
	@Test(invocationCount = 14, threadPoolSize = 3)
	public void Insta() throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("https://www.instagram.com/");
		Reporter.log("Insta executed",true);
		Thread.sleep(1000);
		driver.close();

	}

	
	

}
