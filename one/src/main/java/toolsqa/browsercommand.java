package toolsqa;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class browsercommand {
	
	public static WebDriver driver;
	@BeforeTest
	public void openurl() throws InterruptedException, IOException
	{
		try {
		 
		 String driverExecutablePath = "lib\\chromedriver.exe";
		 System.setProperty("webdriver.chrome.driver", driverExecutablePath);
		 // Create a new instance of the FireFox driver 
		  driver = new ChromeDriver(); 
		driver.get("https://www.google.com/");
		
		driver.manage().window().maximize();
		System.out.println("url : "+driver.getCurrentUrl());
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		}catch (Exception e) {
	        e.printStackTrace();
			
		}}
		
		@AfterTest
		public void closewindows() {
			
			driver.close();
		}
		
		
		}

