package Utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.relevantcodes.extentreports.LogStatus;

import toolsqa.browsercommand;


	
	
	
	public class Listener extends browsercommand implements ITestListener {
		 
	    private static String getTestMethodName(ITestResult iTestResult) {
	        return iTestResult.getMethod().getConstructorOrMethod().getName();
	    }
	    
	    //Before starting all tests, below method runs.
	    @Override
	    public void onStart(ITestContext iTestContext) {
	        System.out.println("Start " + iTestContext.getName());
	       iTestContext.setAttribute("WebDriver", this.driver);
	    }
	 
	    //After ending all tests, below method runs.
	    @Override
	    public void onFinish(ITestContext iTestContext) {
	        System.out.println("Finish method " + iTestContext.getName());
	        
	     
	        //ExtentTestManager.endTest();
	       // ExtentManager.getReporter().flush();
	    }
	 
	    @Override
	    public void onTestStart(ITestResult iTestResult) {
	        System.out.println("Method " +  getTestMethodName(iTestResult) + " start");
	        //Start operation for extentreports.
	      //  ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(),"");
	    }
	 
	    @Override
	    public void onTestSuccess(ITestResult iTestResult) {
	        System.out.println("Method " +  getTestMethodName(iTestResult) + " succeed");
	        //Extentreports log operation for passed tests.
	       // ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
	    }
	 
	    @Override
	    public void onTestFailure(ITestResult iTestResult) {
	        System.out.println("Method " +  getTestMethodName(iTestResult) + " failed");
	 
	        //Get driver from BaseTest and assign to local webdriver variable.
	        //Object testClass = iTestResult.getInstance();
	        //WebDriver webDriver = ((Base) testClass).initializeDriverandLogin("chrome");
	 
	        //Take base64Screenshot screenshot.
	        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).
	                getScreenshotAs(OutputType.BASE64);
	 
	        //Extentreports log and screenshot operations for failed tests.
	     //   ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",
	       //         ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
	    }

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTestSkipped(ITestResult arg0) {
			// TODO Auto-generated method stub
			
		}
	
	 
}
	



