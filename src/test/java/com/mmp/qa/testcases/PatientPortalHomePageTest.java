package com.mmp.qa.testcases;

import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mmp.qa.base.BaseTest;
import com.mmp.qa.pages.PatientLoginHomePage;
import com.mmp.qa.pages.PatientLoginPage;
import com.mmp.qa.pages.PatientPortalFeePage;
import com.mmp.qa.pages.PatientPortalHomePage;
import com.mmp.qa.pages.PatientPortalMessagesPage;
import com.mmp.qa.pages.PatientPortalProfilePage;
import com.mmp.qa.pages.PatientPortalScheduleAppointmentPage;
import com.mmp.qa.pages.PatientPortalSearchSymptomsPage;
import com.mmp.qa.utilpackage.TestUtil;

public class PatientPortalHomePageTest extends BaseTest {
	
	String sheetName="sheet1";
	
	PatientLoginHomePage patientLoginHomePage;
	PatientLoginPage patientLoginPage;
	PatientPortalHomePage patientPortalHomePage;
	PatientPortalProfilePage patientPortalProfilePage;
	PatientPortalScheduleAppointmentPage patientPortalScheduleAppointmentPage;
	PatientPortalFeePage patientPortalFeePage;
	PatientPortalSearchSymptomsPage patientPortalSearchSymptomsPage;
	PatientPortalMessagesPage patientPortalMessagesPage;
	
	
	public PatientPortalHomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		patientPortalFeePage=new PatientPortalFeePage();
		patientPortalProfilePage =new PatientPortalProfilePage();
		patientPortalScheduleAppointmentPage=new PatientPortalScheduleAppointmentPage();
		patientLoginHomePage = new PatientLoginHomePage();
		patientPortalSearchSymptomsPage=new PatientPortalSearchSymptomsPage();
		patientPortalMessagesPage=new PatientPortalMessagesPage();
		
		patientLoginPage = patientLoginHomePage.patLoginInMainPage();
		patientPortalHomePage = patientLoginPage.loginPatient(prop.getProperty("username"),prop.getProperty("password"));
		
		
	}

	//@Test(priority = 1)
	public void validatePatientPortalUsernameCheckTest() {
		String actual = patientPortalHomePage.validateUsernameCheck();
		System.out.println(actual);
		Assert.assertEquals(actual, prop.getProperty("username"));
	}

	//@Test(priority = 2)
	public void validatePatientPortalPageTitleTest() {
		String actual = patientPortalHomePage.validatePageTitle();
		Assert.assertEquals(actual, "home");
	}
	@Test(priority=3)
	public void validatePatientPortalPageLogoTest() {

		String result = patientPortalHomePage.validatePageCheck();
		Assert.assertEquals(result, "HOME");
	}
	//@Test(priority=4)
	public void patientPoralProfilePageLinkTest(){
		patientPortalProfilePage=patientPortalHomePage.profilePageLink();
	}

	//@Test(priority=5)
	public void patientPortalScheduleApptPageLinkTest(){
		patientPortalScheduleAppointmentPage=patientPortalHomePage.scheduleApptPageLink();
	}
	//@Test(priority=6)
	public void patientPoralFeesPageLinkTest()
	{
		patientPortalFeePage=patientPortalHomePage.feesPageLink();
	}
	//@Test(priority=7)
	public void patientPortalSearchSymptPageLinkTest(){
		patientPortalSearchSymptomsPage=patientPortalHomePage.searchSymptPageLink();
	}
	
	//@Test(priority=8)
	public void patientPortalMessagesPageLinkTest(){
		patientPortalMessagesPage=patientPortalHomePage.messagesPageLink();
	}
	//@Test(priority=9)
	public void patientPortalLogoutLinkTest(){
		patientLoginHomePage=patientPortalHomePage.logoutPageLink();
	}
	//@Test(priority=10)
	public void verifyPatientPortalTableEntryTest(){
		String[] res=patientPortalHomePage.patPortalApptTablecheck();
		String[] expec=new String[]{"Date","Time","Appointment","Doctor"};
		for(String col:res)
		{
			System.out.println(col);
		}
		for(String e:expec)
		{
			System.out.println(e);
		}
		if (Arrays.equals(res,expec))
		//if (res==expec)
			System.out.println("expected matchs actual");
		else
			System.out.println("table fields dont match");
		
		Assert.assertEquals(res, expec);
		
	}
	//@Test(priority=11)
	public void verifyPatientPortalTablelDocApptEntryTest() throws InvalidFormatException, IOException{
	String[] expec=TestUtil.readLastRowEntryExcel(sheetName);
	String[] result=patientPortalHomePage.docApptFirstEntryCheck();
	for(String res: result)
	{
		System.out.println(res);
	}
	Assert.assertEquals(result, expec);
	
	  
	}	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
