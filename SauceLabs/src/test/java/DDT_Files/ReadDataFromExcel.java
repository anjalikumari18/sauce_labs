package DDT_Files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/register");

		FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\Desktop\\ClassDocs\\DemoWebShop.xlsx");
		
		//Open workbook in read mode
	     Workbook wb = WorkbookFactory.create(fis);
		//Get access of entire sheet
		 Sheet sh = wb.getSheet("Sheet3");
		
		//get access of entire row
		 Row r = sh.getRow(0);
		
		//get access of cell
		Cell cell = r.getCell(1);
		
		
		
		//cellwrite.setCellValue("PASS");
		
		FileOutputStream fos=new FileOutputStream("C:\\Users\\DELL\\Desktop\\ClassDocs\\DemoWebShop.xlsx");
		
		wb.write(fos);
		
		//capture value in string type
		String firstname = cell.getStringCellValue();
		
		//method chaining
		String lastname = wb.getSheet("Sheet3").getRow(1).getCell(1).getStringCellValue();
		String email = wb.getSheet("Sheet3").getRow(2).getCell(1).getStringCellValue();
		String password = wb.getSheet("Sheet3").getRow(3).getCell(1).getStringCellValue();
		String confpassword = wb.getSheet("Sheet3").getRow(4).getCell(1).getStringCellValue();

		
		driver.findElement(By.id("FirstName")).sendKeys(firstname);
		driver.findElement(By.id("LastName")).sendKeys(lastname);
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(confpassword);
		
       //closing the workbook
		wb.close();
		
		
		
	}

}
