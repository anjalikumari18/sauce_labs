package Helper_Attribute;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class invocation_count {

	WebDriver driver;
	@Test (invocationCount = 5)
	public void Amazon() {
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Reporter.log("Amazon executed",true);
		driver.close();
	}
	
	
	@Test(invocationCount = 2)
	public void Myntra() {
		driver=new ChromeDriver();
		driver.get("https://www.myntra.com/");
		Reporter.log("Myntra executed",true);

		driver.close();

	}
	

	
	
	
}
