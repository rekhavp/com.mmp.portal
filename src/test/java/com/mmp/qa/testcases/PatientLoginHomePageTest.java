package com.mmp.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mmp.qa.base.BaseTest;
import com.mmp.qa.pages.PatientLoginHomePage;
import com.mmp.qa.pages.PatientLoginPage;

public class PatientLoginHomePageTest extends BaseTest {

	PatientLoginHomePage pateintLoginHomePage;
	PatientLoginPage pateintLoginPage;
	
	public PatientLoginHomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		pateintLoginHomePage=new PatientLoginHomePage();
	}
	//@Test(priority=1)
	public void pateintLoginHomePageTitleTest(){
		String actualTitle=pateintLoginHomePage.validateTitleOfPage();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle,"NAMTG");
	}
	@Test(priority=2)
	public void pateintLoginHomePageLogoTest(){
		boolean flag=pateintLoginHomePage.validateLogo();
		//System.out.println(flag);
		Assert.assertTrue(flag);
	}
	//@Test(priority=3)
	public void pateintLoginHomePageLoginMainpageTest(){
		pateintLoginPage=pateintLoginHomePage.patLoginInMainPage();
	}	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
