package com.mmp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mmp.qa.base.BaseTest;

public class PatientPortalProfilePage extends BaseTest {

	@FindBy(id="fname")
	WebElement firstName;
	
	@FindBy(id="lname")
	WebElement lastName;

	@FindBy(id="licn")
	WebElement licence;
	
	@FindBy(id="ssn")
	WebElement ssn;
	
	@FindBy(id="addr")
	WebElement address;
	
	@FindBy(id="age")
	WebElement age;
	
	@FindBy(id="weight")
	WebElement weight;
	
	@FindBy(id="height")
	WebElement height;
	
	@FindBy(id="city")
	WebElement city;
	@FindBy(id="state")
	WebElement state;

	@FindBy(id="zip")
	WebElement zip;
	
	@FindBy(id="proinfo")
	WebElement providerInfo;
	
	@FindBy(id="Insinfo")
	WebElement insuranceInfo;
	
	@FindBy(id="Ebtn")
	WebElement editBtn;
	
	@FindBy(xpath="//button[contains(text(),'View History')]")
	WebElement viewHistortBtn;
	
	@FindBy(xpath="//button[contains(text(),'View Reports')]")
	WebElement viewReportsBtn;
	
	
	
	
	

}
