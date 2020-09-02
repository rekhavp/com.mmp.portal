package com.mmp.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mmp.qa.base.BaseTest;
import com.mmp.qa.pages.PatientLoginForgotPasswordLink;
import com.mmp.qa.pages.PatientLoginHomePage;
import com.mmp.qa.pages.PatientLoginPage;
import com.mmp.qa.pages.PatientPortalHomePage;



public class PateintLoginPageTest extends BaseTest {
	
	PatientLoginHomePage pateintLoginHomePage;
	PatientLoginPage pateintLoginPage;
	PatientPortalHomePage patientPortalHomePage;
	PatientLoginForgotPasswordLink patientLoginForgotPasswordLink;
	
	public PateintLoginPageTest(){
		
		super();
	}
	

	@BeforeMethod
	public void setUp()
	{
		initialization();
		pateintLoginHomePage=new PatientLoginHomePage();
		pateintLoginPage=pateintLoginHomePage.patLoginInMainPage();
		
	}
	
//	@Test(priority=1)
	public void loginPageTitleTest(){
		String actual=pateintLoginPage.validateLoginPageTitle();
		System.out.println(actual);
		
		Assert.assertEquals(actual,"Login");
	}
	//@Test(priority=2)
	public void loginpatienceTest(){
		pateintLoginPage.loginPatient(prop.getProperty("username"),prop.getProperty("password"));	
	
	}
	
	@Test(priority=3)
	public void forgotpasswdLinkTest(){
		pateintLoginPage.patientForgotPassword();
	
		
	}
	
    @AfterMethod
	public void tearDown()
	{
 //   	log.info("CLOSING DRIVER");
		driver.quit();
	}
}
