package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	@Test
	public void sample()
	{
		String s="sample";
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals(0,1);
		Assert.assertTrue(s.contains("a"));
		System.out.println("Step3");
		System.out.println("Step4");
	}
	@Test
	public void sample1()
	{
		SoftAssert sa= new SoftAssert();
		
		System.out.println("Step1");
		System.out.println("Step2");
		sa.assertEquals(0,1);
		sa.assertTrue(false);
		System.out.println("Step3");
		System.out.println("Step4");
		sa.assertAll();
	}

}
