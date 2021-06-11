package Utility;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import toolsqa.browsercommand;



	
	public class ExtentTestMnager11 extends browsercommand {
		
	    static Map extentTestMap = new HashMap();
	    static ExtentReports extent = ExtentMnager1.getReporter();

	 
	    public static synchronized ExtentTest getTest() {
	        return (ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	    }
	 
	    public static synchronized void endTest() {
	        extent.endTest((ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId())));

	        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	        ExtentTestMnager11.getTest().log(LogStatus.PASS,"Test Pass",
	        		ExtentTestMnager11.getTest().addBase64ScreenShot(base64Screenshot));
	    }
	 
	    public static synchronized ExtentTest startTest(String testName, String desc) {
	        ExtentTest test = extent.startTest(testName, desc);
	        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
	        return test;
	    }
	    
		 
}


