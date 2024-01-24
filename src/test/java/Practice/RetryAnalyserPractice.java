package Practice;

import org.testng.Assert;

import org.testng.annotations.Test;


public class RetryAnalyserPractice {
    @Test(retryAnalyzer=GenericUtilities.RetryAnalyserImplementation.class)
    public void sample()
    {
    	Assert.fail();
    	System.out.println("Hi");
    }
}
