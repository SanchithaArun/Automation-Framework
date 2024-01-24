package Practice;

import java.io.IOException;

import GenericUtilities.ExelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PropertyFileUtility pUtil=new PropertyFileUtility();
		String value = pUtil.readDataFromPropertyFile("Password");
        System.out.println(value);
        ExelFileUtility eUtil=new ExelFileUtility();
        String value1 = eUtil.readTestDataFromExelFile("Contacts",1,2);
        System.out.println(value1);
        JavaUtility jUtil=new JavaUtility();
       
        System.out.println(jUtil.getSystemDate());
	}

}
