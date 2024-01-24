package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1WithDataDrivenTesting {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fise);
		String URL = p.getProperty("url");
		String UN = p.getProperty("UserName");
		String PWD = p.getProperty("Password");
		FileInputStream fis=new FileInputStream("C:\\Users\\asanc\\OneDrive\\Desktop\\sanchi\\qspiders\\adv selinium\\TestData.xlsx");
       Workbook wb = WorkbookFactory.create(fis);
       String LASTNAME = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
	 //  Step1: Launch the browser
       WebDriver driver=new EdgeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   //Step2:Load the URL
	   driver.get(URL);
	   //step3: Login to the application
	   driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		//step4:Click on Contacts link
		driver.findElement(By.linkText("Contacts")).click();
		//step5:Click on create contact look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		//step6:Enter mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		//step7:Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//step8:Validate
		//Create new contact with mandatory details
		//contact is successfully creates or not
		String CName = driver.findElement(By.className("dvHeaderText")).getText();
		System.out.println(CName);
		if(CName.contains(LASTNAME))
		{
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
	//step9: Logout of Application
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		//Step10:Close the browser
		driver.quit();
		
	
	}

}
