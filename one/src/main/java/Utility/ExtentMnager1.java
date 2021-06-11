package Utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import com.relevantcodes.extentreports.ExtentReports;

import toolsqa.browsercommand;

public class ExtentMnager1 extends browsercommand{
	
    private static ExtentReports extent;
    public static String reportFolder ="";
    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
        reportFolder = workingDir+"\\ReportGenerator\\Screenshots\\html_report_"
		            + new SimpleDateFormat("yyyy_MM_dd_HHmmss").format(
		                    Calendar.getInstance().getTime()).toString();	 
			  new File(reportFolder).mkdir();
          
            //extent = new ExtentReports(workingDir+"\\lib\\ExtentReport\\ExtentReportResults.html", true,Locale.ENGLISH);
			  String s=new File(reportFolder+"/TestReport.html").getPath();
				 extent = new ExtentReports(s, true,Locale.ENGLISH);
   		 extent.addSystemInfo("Selenium Version", "3.12");
		 extent.addSystemInfo("Environment", "QA");
		extent.assignProject("Web Arena");
		
        System.out.println("A"+reportFolder );
        
      //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
        //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
        }
        return extent;
    }
    
 
    
}