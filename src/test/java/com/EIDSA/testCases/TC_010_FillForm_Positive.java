package com.EIDSA.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.EIDSA.pageObjects.FillForm;
import com.EIDSA.pageObjects.LoginPage;
import com.EIDSA.pageObjects.SubmittedForm;

import Base.BaseClass;

public class TC_010_FillForm_Positive extends BaseClass {
	
	@Test(priority=1, description = "Save the form")
	public void SaveForm() throws IOException, InterruptedException
	{
		FillForm fp = new FillForm(driver);
		LoginPage lp=new LoginPage(driver);
		lp.login("sujis","sujis@yopmail.com","Neethu@8");
		fp.selectStudy1("DMS11");
		fp.clickFillForm();
		fp.selectForm2();
		fp.fillFormSave("Neethu");
		fp.Alert1();
		logger.info("Form saved successfully");		
	}
		
	@Test(priority=2, description = "Submit the form")
	public void ReviewandSubmitForm() throws IOException, InterruptedException
	{
		FillForm fp = new FillForm(driver);
		fp.partiallyFilledForms();
		fp.Alert3();
		logger.info("Form submitted successfully");	
	}
	
	@Test(priority=3, description = "Fill the form through data entry")
	public void DataEntry() throws IOException, InterruptedException
	{
		FillForm fp = new FillForm(driver);
		fp.dataEntry("Neethu");
		fp.Alert2();
		logger.info("Form submitted successfully");	
	}
	
	@Test(priority=4, description = "Map the unassigned forms")
	public void MapUassignedForms() throws IOException, InterruptedException
	{
		FillForm fp = new FillForm(driver);
		fp.unassignedForms("S01", "P01");
		fp.Alert5();
	}
	
	@Test(priority=5, description = "Open the submitted form")
	public void clickView() throws IOException, InterruptedException
	{
		SubmittedForm fs = new SubmittedForm(driver);
		fs.clickOnSubmittedForm();
		fs.viewForm();
		logger.info("Form opened");
	}
	
	@Test(priority=6, description = "Generate new query against the form")
	public void FormQuery() throws IOException, InterruptedException
	{
		SubmittedForm fs = new SubmittedForm(driver);
		fs.formQuery("Subject", "Message");
		fs.queryGenerationAlert();
	}
	
	@Test(priority=7, description = "Verify the submitted form")
	public void FormVerify() throws IOException, InterruptedException
	{
		SubmittedForm fs = new SubmittedForm(driver);
		fs.verifyForm();
		fs.verifyFormAlert();
	}
	
	@Test(priority=8, description = "Sign the submitted form")
	public void sign() throws IOException, InterruptedException
	{
		SubmittedForm fs = new SubmittedForm(driver);
		LoginPage lp=new LoginPage(driver);
		fs.sign("sujis@yopmail.com", "Neethu@8");
		lp.logout();
		
	}


}
