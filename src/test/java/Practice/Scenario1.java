package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		//Step1: Launch the Browser
		WebDriver driver= new EdgeDriver();
		//Step2:Load the URL
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("Vinay");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String CName = driver.findElement(By.className("dvHeaderText")).getText();
		System.out.println(CName);
		if(CName.contains("Vinay"))
		{
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		/*driver.findElement(By.xpath("//a[.='Organizations']/../..//td[6]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("SaktiMaan");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//Step 8:Validate
		//Create new contact with mandatory details
		//Contact is  successfully created
		String OHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 System.out.println(OHeader);
		 if(OHeader.contains("SaktiMaan"))
		 {
			 System.out.println("PASS");
		 }
		 else
		 {
			 System.out.println("FAIL");
		 }*/
		 //Step 9: Logout of Application
	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act=new Actions(driver);
	act.moveToElement(ele).perform();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	//Step10:Close the browser
	driver.quit();
	
	}
	

}
