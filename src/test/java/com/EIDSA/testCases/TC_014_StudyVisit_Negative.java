package com.EIDSA.testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EIDSA.pageObjects.StudyVisit;

import Base.BaseClassTest;

public class TC_014_StudyVisit_Negative extends BaseClassTest {

	@Test(priority=1)
	public void visitCreation_negative1() throws IOException, InterruptedException
	{
		StudyVisit sp = new StudyVisit(driver);
		sp.clickStudy();
		sp.StudyNameOrIdSearch("Clinical 1");
		sp.searchStudy();
		sp.visitIcon("Clinical 1");
		sp.VisitAdd();
		sp.ClickSave();
		Thread.sleep(3000);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(sp.ErrorMsg1(), "Please enter visit no");
		softAssert.assertEquals(sp.ErrorMsg2(), "Please enter visit/form name");
		softAssert.assertEquals(sp.ErrorMsg3(), "Please select a visit type");
		softAssert.assertAll();
        logger.info("Negative test1 passed");
	}

	@Test(priority=2)
	public void negative2() throws IOException, InterruptedException
	{
		StudyVisit sp = new StudyVisit(driver);
		sp.clickStudy();
		sp.StudyNameOrIdSearch("Clinical 1");
		sp.searchStudy();
		sp.visitIcon("Clinical 1");
		sp.searchVisitNo("visit01");
		sp.search();
		sp.assignTemplate("visit01");
		sp.AssignClick();
		sp.Alert5();
		logger.info("Negative test2 passed");
	}
	
	@Test(priority=3)
	public void visitCreation_negative() throws IOException, InterruptedException
	{
		StudyVisit sp = new StudyVisit(driver);
		sp.clickStudy();
		sp.StudyNameOrIdSearch("Clinical 1");
		sp.searchStudy();
		sp.visitIcon("Clinical 1");
		sp.createVisit("visit01", "visit01", "Home Visit");
		sp.Alert6();
		logger.info("Negative test3 passed");
	}

}