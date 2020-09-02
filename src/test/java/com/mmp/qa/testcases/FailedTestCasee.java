package com.mmp.qa.testcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class FailedTestCasee {

	public void failedTestCases() {
		
		TestNG runner=new TestNG();
		List<String> cases=new ArrayList<String>();
		cases.add("C:\\Users\\awesomemaster\\Downloads\\Modding v2\\eclipse\\com.mmp.portal\\test-output\\testng-failed.xml");
		
		runner.setTestSuites(cases);
		runner.run();
		
		
	}
}
