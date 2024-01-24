package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromTestDataFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		//open the document in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
    
		//Create a workbook
	Workbook wb=WorkbookFactory.create(fis);
	//Navigate to required sheet
   Sheet sh = wb.getSheet("Contacts");
   //Navigate to required row
   Row rw = sh.getRow(1);
   //Navigate to required cell
   Cell c1 = rw.getCell(2);
   //Capture the data in the cell
   String value = c1.getStringCellValue();
    
   System.out.println(value);
	}

}
