package Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import GenericUtilities.ExelFileUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.SeleniumUtility;
import ObjectRepository.ContactPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.CreatingNewContactPage;
import ObjectRepository.LoginPage;

public class Scenario1withDDTanGU {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExelFileUtility eUtil=new ExelFileUtility();
		SeleniumUtility sUtil=new SeleniumUtility();
		//Read all the required data
		/*Read the common Data from Property File*/
	   String URL = pUtil.readDataFromPropertyFile("url");
	  String USERNAME = pUtil.readDataFromPropertyFile("UserName");
	   String PASSWORD = pUtil.readDataFromPropertyFile("Password");
	   /*read the test data from Excel File*/
       String LASTNAME = eUtil.readTestDataFromExelFile("Contacts", 1, 2);
	 //  Step1: Launch the browser
       WebDriver driver=new EdgeDriver();
	 
       sUtil.maximizeWindow(driver);
       sUtil.implicitWait(driver);
	   //Step2:Load the URL
	   driver.get(URL);
	   //step3: Login to the application
	  // driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
	   LoginPage lp=new LoginPage(driver);
	  // lp.getUsernameEdt().sendKeys(USERNAME);
	  // lp.getPasswordEdt().sendKeys(PASSWORD);
	   lp.loginToApp(USERNAME, PASSWORD);
	 //  lp.getLoginBtn().click();
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
		
		sUtil.mouseOverAction(driver, ele);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		//Step10:Close the browser
		driver.quit();
		
	

	}

	

}
