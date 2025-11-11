package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

	public String getDataFromExcelFile(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\Desktop\\ClassDocs\\SauceLab_testdata.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    String cell_value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
	    wb.close();
	    return cell_value;
	
	}
	
	
}
