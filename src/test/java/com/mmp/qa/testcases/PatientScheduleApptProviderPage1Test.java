package com.mmp.qa.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mmp.qa.base.BaseTest;
import com.mmp.qa.pages.PatientLoginHomePage;
import com.mmp.qa.pages.PatientLoginPage;
import com.mmp.qa.pages.PatientPortalHomePage;
import com.mmp.qa.pages.PatientPortalScheduleAppointmentPage;
import com.mmp.qa.pages.PatientScheduleApptPage2;
import com.mmp.qa.pages.PatientScheduleApptProviderPage1;
import com.mmp.qa.utilpackage.TestUtil;

public class PatientScheduleApptProviderPage1Test extends BaseTest {
	
	
	//String sheetName = "Doc Appointment";
	String sheetName="sheet1";

	PatientLoginHomePage patientLoginHomePage;
	PatientLoginPage patientLoginPage;
	PatientPortalHomePage patientPortalHomePage;
	PatientPortalScheduleAppointmentPage patientPortalScheduleAppointmentPage;
	PatientScheduleApptProviderPage1 patientScheduleApptProviderPage1;
	PatientScheduleApptPage2 patientScheduleApptPage2;

	public PatientScheduleApptProviderPage1Test() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		patientLoginHomePage = new PatientLoginHomePage();
		patientLoginPage = new PatientLoginPage();
		patientPortalHomePage = new PatientPortalHomePage();

		patientPortalScheduleAppointmentPage = new PatientPortalScheduleAppointmentPage();
		patientScheduleApptProviderPage1 = new PatientScheduleApptProviderPage1();

		patientLoginPage = patientLoginHomePage.patLoginInMainPage();
		patientPortalHomePage = patientLoginPage.loginPatient(prop.getProperty("username"),
				prop.getProperty("password"));
		patientPortalScheduleAppointmentPage = patientPortalHomePage.scheduleApptPageLink();
		patientPortalScheduleAppointmentPage.createNewApptClickOnBtnlink();
		// patientScheduleApptProviderPage1.bookApptBtnClick("Beth");
		// patientScheduleApptProviderPage1.switchToFrame();

	}

	@Test(priority = 1)
	public void pageTitleCheckTest() {
		// String actual=patientScheduleApptProviderPage1.frameHeaderCheck();
		String actual = patientScheduleApptProviderPage1.pageTitleCheck();
		String expected = "Providers";
		Assert.assertEquals(actual, expected);
	}

	//@DataProvider
	public Object[][] getPatientTestData() throws InvalidFormatException, IOException {

		Object data[][] = TestUtil.readExcel(sheetName);

		return data;

	}

	//@Test(priority = 2, dataProvider = "getPatientTestData")
	public void schedApptInputTest(String docName, String date, String time,String symptom) {
		patientScheduleApptProviderPage1.bookApptBtnClick(docName);
		patientScheduleApptProviderPage1.inputInfoClickToContinue(date, time, symptom);
		// patientScheduleApptProviderPage1.dateSelectionMethod(date);
		// patientScheduleApptProviderPage1.timeSelect(time);
		// patientScheduleApptPage2=patientScheduleApptProviderPage1.clickTocontinueBtn();
	}

		
		

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
