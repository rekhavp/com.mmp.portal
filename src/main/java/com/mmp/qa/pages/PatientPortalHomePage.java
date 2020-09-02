package com.mmp.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmp.qa.base.BaseTest;

import junit.framework.Assert;

public class PatientPortalHomePage extends BaseTest {

	@FindBy(xpath = "//span[contains(text(),'Profile')]")
	WebElement profilepageLink;

	@FindBy(xpath = "//span[contains(text(),'Schedule Appointment')]")
	WebElement schedApptLsink;

	@FindBy(xpath = "//span[contains(text(),'Information')]")
	WebElement informationLink;

	@FindBy(xpath = "//span[contains(text(),'Fees')]")
	WebElement feesLink;

	@FindBy(xpath = "//span[contains(text(),'Search Symptoms')]")
	WebElement searchSympLink;

	@FindBy(xpath = "//span[contains(text(),'Messages')]")
	WebElement messagesLink;

	@FindBy(xpath = "//span[contains(text(),'Logout')]")
	WebElement logoutLink;

	@FindBy(xpath = "//span[@class='username']")
	WebElement userNameCheck;

	@FindBy(xpath = "//a[contains(text(),'HOME')]")
	WebElement pageCheck;
	

	public PatientPortalHomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validateUsernameCheck() {
		return userNameCheck.getText();
	}

	public String validatePageCheck() {
		return pageCheck.getText();
	}

	public String validatePageTitle() {
		return driver.getTitle();
	}

	public PatientPortalProfilePage profilePageLink() {
		profilepageLink.click();
		return new PatientPortalProfilePage();
	}

	public PatientPortalScheduleAppointmentPage scheduleApptPageLink() {
		schedApptLsink.click();
		return new PatientPortalScheduleAppointmentPage();
	}

	public PatientPortalFeePage feesPageLink() {
		feesLink.click();
		return new PatientPortalFeePage();
	}

	public PatientPortalSearchSymptomsPage searchSymptPageLink() {
		searchSympLink.click();
		return new PatientPortalSearchSymptomsPage();
	}
	public PatientPortalMessagesPage messagesPageLink(){
		messagesLink.click();
		return new PatientPortalMessagesPage();
	}
	public PatientLoginHomePage logoutPageLink(){
		logoutLink.click();
		return new PatientLoginHomePage();
	}
	public String[] patPortalApptTablecheck(){
		boolean flag;
		
		String[] result=new String[4];
		for (int i=0;i<4;i++)
		{
		flag=driver.findElement(By.xpath("//thead/tr/th["+(i+1)+"]")).isDisplayed();
			if (flag)
			{
				result[i]= (driver.findElement(By.xpath("//thead/tr/th["+(i+1)+"]")).getText());
			}
		}

	return result;
	}
	
	public String[] docApptFirstEntryCheck(){
		/*String res[]=new String[4];
		for (int k=0;k<4;k++)
		{
			res[(k)]=driver.findElement(By.xpath("//table[@class='table']//tbody/tr[1]/td["+(k+1)+"]")).getText();
			System.out.println(res[(k+1)]);
		}
		
		return res;*/
		String actDate=driver.findElement(By.xpath("//table[@class='table']//tbody/tr[1]/td[1]")).getText();
		String actTime=driver.findElement(By.xpath("//table[@class='table']//tbody/tr[1]/td[2]")).getText();
		String actSym=driver.findElement(By.xpath("//table[@class='table']//tbody/tr[1]/td[3]")).getText();
		String actDoc=driver.findElement(By.xpath("//table[@class='table']//tbody/tr[1]/td[4]")).getText();

		 String res[]={actDoc,actDate,actTime,actSym};
		return res;
	}

}
