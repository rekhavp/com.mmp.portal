package com.mmp.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mmp.qa.base.BaseTest;

public class PatientScheduleApptProviderPage1 extends BaseTest {

	@FindBy(xpath = "//span[@id='ui-id-2']")
	WebElement headerCheck;
	@FindBy(id = "datepicker")
	@CacheLookup
	WebElement datefield;
	@FindBy(id = "ChangeHeatName")
	@CacheLookup
	WebElement continueBtn;
	
	
	@FindBy(xpath="//textarea[@id='sym']")
	@CacheLookup
	WebElement sympDescript;

	@FindBy(xpath = "//input[@value='Submit']")
	@CacheLookup
	WebElement submitBtn;


	public PatientScheduleApptProviderPage1() {
		PageFactory.initElements(driver, this);
	}

	public void bookApptBtnClick(String name) {

		driver.findElement(By
				.xpath("//h4[contains(text(),'Dr." + name + "')]/ancestor::ul/following-sibling::button[@id='opener']"))
				.click();

		driver.switchTo().frame("myframe");
	}

	public String pageTitleCheck() {

		// return headerCheck.getText();
		return driver.getTitle();
	}

	public void dateSelectionMethod(String date) {
		datefield.sendKeys(date);
	}

	public void timeSelect(String time) {
		WebElement wElem = driver.findElement(By.id("time"));
		Select sel = new Select(wElem);
		sel.selectByValue(time);
	}

	public PatientScheduleApptPage2 clickTocontinueBtn() {
		continueBtn.click();
		return new PatientScheduleApptPage2();
	}
	
	public void writeSymp(String symptoms) {
		sympDescript.sendKeys(symptoms);
	}

	public PatientPortalHomePage clickSubmitBtn(){
		submitBtn.click();
		return new PatientPortalHomePage();
	}

	public PatientPortalHomePage inputInfoClickToContinue(String date, String time,String symptoms) {
		datefield.sendKeys(date);
		WebElement wElem = driver.findElement(By.id("time"));
		Select sel = new Select(wElem);
		sel.selectByValue(time);
		continueBtn.click();
		sympDescript.sendKeys(symptoms);
		
		//return new PatientScheduleApptPage2();
		
		return new PatientPortalHomePage();
	}

}
