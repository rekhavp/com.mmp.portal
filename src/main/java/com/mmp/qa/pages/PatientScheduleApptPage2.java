package com.mmp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmp.qa.base.BaseTest;

public class PatientScheduleApptPage2 extends BaseTest {

	@FindBy(xpath="//textarea[@id='sym']")
	WebElement sympDescript;

	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submitBtn;

	public PatientScheduleApptPage2() {

		PageFactory.initElements(driver, this);
	}

	public String pageTitleCheck() {

		return driver.getTitle();
	}

	public void writeSymp(String symptoms) {
		sympDescript.sendKeys(symptoms);
	}

	public PatientPortalHomePage clickSubmitBtn(){
		submitBtn.click();
		return new PatientPortalHomePage();
	}
}
