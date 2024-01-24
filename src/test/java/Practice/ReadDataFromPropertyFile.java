package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		//Open the document in java readable format

			FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
			
	//create object of properties class from Java.util
			Properties p= new Properties();
		
			//Load the file input stream into properties
	p.load(fis);
	//provide the key and read the value
	String value = p.getProperty("UserName");
	System.out.println(value);
	
	}
	

}
