package com.mmp.qa.utilpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.*;

import com.mmp.qa.base.BaseTest;

public class TestUtil extends BaseTest {
	
	 static Workbook book,wBook;
	 static Sheet sheet,sSheet;
	 
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICITLY_WAIT_TIME = 10;

	
	public void switchToFrame() {
		driver.switchTo().frame("myframe");

	}

	public static String[][] readExcel(String sheetName) throws InvalidFormatException, IOException {

		FileInputStream f = new FileInputStream(
				"C:/Users/awesomemaster/Downloads/Modding v2/eclipse/com.mmp.portal/src/main/java/com/mmp/qa/testdata/MMP_Test_data.xlsx");
		book = WorkbookFactory.create(f);

		sheet = book.getSheet(sheetName);
		int rowNum=sheet.getLastRowNum();
		int colNum=sheet.getRow(0).getLastCellNum();
		String data[][]=new String[rowNum][colNum];
		
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				System.out.println(data[i][j]);
			}
		}
		return data;
	}
	
	public static String[] readLastRowEntryExcel(String sheetName) throws InvalidFormatException, IOException{
		FileInputStream f=new FileInputStream("C:/Users/awesomemaster/Downloads/Modding v2/eclipse/com.mmp.portal/src/main/java/com/mmp/qa/testdata/MMP_Test_data.xlsx");
		 wBook=WorkbookFactory.create(f);
		 sSheet=wBook.getSheet(sheetName);
		 int rNum=sSheet.getLastRowNum();
		 int cNum=sSheet.getRow(0).getLastCellNum();
		 System.out.println(cNum);

		 String[] data=new String[cNum];
		 for (int i=0;i<cNum;i++){
			 data[i]=sSheet.getRow(rNum).getCell(i).toString();
			 System.out.println(data[i]);
		 }
		 System.out.println("end of data from excel last row"+data);
		 return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException{
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir=System.getProperty("user.dir");
		FileUtils.copyFile(srcFile,new File(currentDir +"/screenshots/" +System.currentTimeMillis() + ".png"));
		
	}

}
