package com.mmp.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmp.qa.base.BaseTest;

public class PatientLoginHomePage extends BaseTest{

	//Page factory:OR
	@FindBy(xpath="//a[contains(text(),'Patient Login')]")
	WebElement mainPatientLogin;
	
	@FindBy(xpath="//img[@src='images/Health Insurance Logo.png']")
	WebElement mmpLogo;
	
	@FindBy(xpath="//a[contains(text(),'Login')][(@href='portal/login.php')]")
	WebElement patLoginBtn;
	
	@FindBy(xpath="//table//tbody/tr[1]")
	WebElement appointmentEntry;
	
	//initialize page objects
	public PatientLoginHomePage(){
		PageFactory.initElements(driver,this);
	}
	//actions or methods
	public String validateTitleOfPage(){
	 return driver.getTitle();
	}
	
	public boolean validateLogo(){
		return mmpLogo.isDisplayed();
	}
	
	public PatientLoginPage patLoginInMainPage(){
		//mainPatientLogin.click();
		patLoginBtn.click();
		
		return new PatientLoginPage();
	}
	
	public void patientPortalFirstApptDetailsCheck(){
		String actDate=driver.findElement(By.xpath("//table//tbody/tr[1]/td[1]")).getText();
		String actTime=driver.findElement(By.xpath("//table//tbody/tr[1]/td[2]")).getText();
		String actAppt=driver.findElement(By.xpath("//table//tbody/tr[1]/td[3]")).getText();
		String actdoc=driver.findElement(By.xpath("//table//tbody/tr[1]/td[4]")).getText();
	}
}
