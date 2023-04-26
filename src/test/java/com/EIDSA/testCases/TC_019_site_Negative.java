package com.EIDSA.testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EIDSA.pageObjects.SitePage;

import Base.BaseClassTest;

public class TC_019_site_Negative  extends BaseClassTest {

	@Test(priority=1)
	public void siteCreationNegative() throws IOException, InterruptedException
	{
		SitePage sp = new SitePage(driver);
		Thread.sleep(4000);
		sp.clickSite();
		sp.clickCreateSite();
		sp.invalidEmail("dd");
		sp.clickSave();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(sp.siteCodeErrorMsg(), "Please enter site code");
		softAssert.assertEquals(sp.emaileErrorMsg(), "Please enter a valid email");
		softAssert.assertAll();
        logger.info("Negative test passed");	
	}

}