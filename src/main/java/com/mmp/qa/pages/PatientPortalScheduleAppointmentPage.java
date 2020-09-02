package com.mmp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmp.qa.base.BaseTest;

public class PatientPortalScheduleAppointmentPage extends BaseTest{
	PatientScheduleApptProviderPage1 patientScheduleApptProviderPage;
	
	@FindBy(xpath="//input[@value='Create new appointment']")
	WebElement createNewApptClickBtn;
	
	public PatientPortalScheduleAppointmentPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public String validatePageTitleCheck(){
		return driver.getTitle();
	}
	public PatientScheduleApptProviderPage1 createNewApptClickOnBtnlink()
	{
		createNewApptClickBtn.click();
		return new PatientScheduleApptProviderPage1();
	}
}
