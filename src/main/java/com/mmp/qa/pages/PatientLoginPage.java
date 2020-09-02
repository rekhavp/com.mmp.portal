package com.mmp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmp.qa.base.BaseTest;

public class PatientLoginPage extends BaseTest {
	
	@FindBy(xpath="//span[@id='h12']")
	WebElement loginPageTitle;
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(name="submit")
	WebElement signInBtn;

	@FindBy(xpath="//input[@value='Register']")
	WebElement regsiterBtn;
	
	@FindBy(xpath="//a[contains(text(),'forgot Username / Password')]")
	WebElement forgotUser;
	
	public PatientLoginPage(){
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateLoginPageHeader(){
		boolean flag=loginPageTitle.isDisplayed();
		return flag;
	}
	
	public PatientPortalHomePage loginPatient(String user,String pass){
		username.sendKeys(user);
		password.sendKeys(pass);
		signInBtn.click();
		
		return new PatientPortalHomePage();
	}

	public void patientRegistration(){
		
	}

	public PatientLoginForgotPasswordLink patientForgotPassword(){
		forgotUser.click();
		return new PatientLoginForgotPasswordLink();
	}


}
