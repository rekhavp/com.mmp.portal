package com.mmp.qa.base;
/*
 * Author:
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.mmp.qa.utilpackage.TestUtil;
import com.mmp.qa.utilpackage.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public BaseTest() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:/Users/awesomemaster/Downloads/Modding v2/eclipse/com.mmp.portal/src/main/java/com/mmp/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialization(){
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		if (browserName.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		} else if (browserName.equals("Firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			}
		
		
		e_driver=new EventFiringWebDriver(driver);
		eventListener=new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT_TIME,TimeUnit.SECONDS);
		System.out.println(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		//System.out.println(driver.getTitle());
		//boolean f=driver.findElement(By.xpath("//img[@src='images/Health Insurance Logo.png']")).isDisplayed();
		//System.out.println(f);
	}
	
}
