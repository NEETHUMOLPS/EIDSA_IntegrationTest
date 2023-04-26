package com.EIDSA.testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EIDSA.pageObjects.PatientLogin;

import Base.BaseClassTest;

public class TC_025_PatientLogin_Negative extends BaseClassTest{
	
	@Test(priority=1)
	public void PatientLogin_Negative() throws IOException, InterruptedException
	{
		PatientLogin pl = new PatientLogin(driver);
		pl.clickPatientLogin();
		pl.SearchSiteCode("Demo01");
		pl.Search();
		Thread.sleep(3000);
		pl.findSubId("demo03");
		Thread.sleep(2000);
		pl.Submit();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(pl.error1(), "Please enter email");
		softAssert.assertAll();
        logger.info("Negative test1 passed");	
		Thread.sleep(2000);
		
		pl.exsEmail("abc@yopmail.com");
		pl.Submit();
		Thread.sleep(2000);
		softAssert.assertEquals(pl.error2(), "Email already exist");
		softAssert.assertAll();
        logger.info("Negative test2 passed");
        
        pl.exsEmail("++");
        pl.Submit();
		Thread.sleep(2000);
		softAssert.assertEquals(pl.error3(), "Invalid email");
		softAssert.assertAll();
        logger.info("Negative test3 passed");
		
	}

}
