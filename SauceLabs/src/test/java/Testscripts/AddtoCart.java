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

public class AddtoCart {

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

		driver.findElement(By.xpath("(//button[text()='Add to cart'])[1]")).click();
		driver.findElement(By.xpath("(//button[text()='Add to cart'])[2]")).click();
		driver.findElement(By.xpath("(//button[text()='Add to cart'])[3]")).click();
		
		driver.findElement(By.id("shopping_cart_container")).click();
		driver.findElement(By.id("checkout")).click();
		
		FileInputStream fis2=new FileInputStream("C:\\Users\\DELL\\Desktop\\ClassDocs\\SauceLab_testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		String fn = wb.getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
		String ln= wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String pin = wb.getSheet("Sheet1").getRow(2).getCell(1).getStringCellValue().toString();
		
		wb.close();

		
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
		
		String expected_confmsg = "Thank you for your order!";
		WebElement conf_msg = driver.findElement(By.xpath("//h2[text()='Thank you for your order!']"));
		String actual_confmsg = conf_msg.getText();
		System.out.println(actual_confmsg);
		
		if(actual_confmsg.contains(expected_confmsg)) {
			System.out.println("Product added to cart successfully");
		}else
		{
			System.out.println("Product could not be added. Failure detected");
		}
		
		
		//Logout code
		driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
		driver.findElement(By.linkText("Logout")).click();
		driver.close();
		
	}

}
