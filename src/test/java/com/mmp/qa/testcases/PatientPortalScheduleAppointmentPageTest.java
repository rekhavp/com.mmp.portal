package com.mmp.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mmp.qa.base.BaseTest;
import com.mmp.qa.pages.PatientLoginHomePage;
import com.mmp.qa.pages.PatientLoginPage;
import com.mmp.qa.pages.PatientPortalHomePage;
import com.mmp.qa.pages.PatientPortalScheduleAppointmentPage;
import com.mmp.qa.pages.PatientScheduleApptProviderPage1;

public class PatientPortalScheduleAppointmentPageTest extends BaseTest {
	
	PatientLoginHomePage patientLoginHomePage;
	PatientLoginPage patientLoginPage;
	PatientPortalHomePage patientPortalHomePage;
	PatientPortalScheduleAppointmentPage patientPortalScheduleAppointmentPage;
	PatientScheduleApptProviderPage1 patientScheduleApptProviderPage;
	
	public PatientPortalScheduleAppointmentPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		patientLoginHomePage =new PatientLoginHomePage();
		patientLoginPage=new PatientLoginPage();
		patientPortalHomePage =new PatientPortalHomePage();
		patientPortalScheduleAppointmentPage=new PatientPortalScheduleAppointmentPage();
		patientScheduleApptProviderPage=new PatientScheduleApptProviderPage1();
		
		patientLoginPage=patientLoginHomePage.patLoginInMainPage();
		patientPortalHomePage=patientLoginPage.loginPatient(prop.getProperty("username"), prop.getProperty("password"));
		patientPortalScheduleAppointmentPage=patientPortalHomePage.scheduleApptPageLink();
	}
	
	//@Test
	public void createNewApptClickBtnTest(){
		patientScheduleApptProviderPage=patientPortalScheduleAppointmentPage.createNewApptClickOnBtnlink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
