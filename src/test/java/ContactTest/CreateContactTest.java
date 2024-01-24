package ContactTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import GenericUtilities.ExelFileUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.SeleniumUtility;
import ObjectRepository.ContactInfoPage;
import ObjectRepository.ContactPage;
import ObjectRepository.CreatingNewContactPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class CreateContactTest {

	public static void main(String[] args) throws InterruptedException, IOException {
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
	   LoginPage lp=new LoginPage(driver);
	   lp.loginToApp(USERNAME, PASSWORD);
	
		//step4:Click on Contacts link
	   HomePage hp=new HomePage(driver);
		hp.clickOnContactsLink();
		
		//step5:Click on create contact lookup image
		ContactPage cp=new ContactPage(driver);
		cp.CreateContactLookUpImg();
		
		//step6:create new contacts with mandatory fields
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
		
		//step8:Validate
		//Create new contact with mandatory details
		//contact is successfully creates or not
		ContactInfoPage cip=new ContactInfoPage(driver);
		String CName = cip.captureheaderText();
		System.out.println(CName);
		if(CName.contains(LASTNAME))
		{
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
	//step9: Logout of Application
		hp.logoutOfApp(driver);
		
	
		//Step10:Close the browser
		driver.quit();
		
	

	}

}
