package pagesGoogle;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import toolsqa.browsercommand;

public class luckyPage extends browsercommand{
	
	public luckyPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#searchform div #searchinput")
	private WebElement doodle_search_box;

	@FindBy(css="#searchbtn")
	private WebElement search_button;
	
	@FindBy(css=".title a[title~='Jeanne']")
	private WebElement ele_to_click;
	
	
	public luckyPage searchdoodle() throws InterruptedException {
		
		Thread.sleep(10000);
		doodle_search_box.sendKeys("plant");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		search_button.click();
		
		return this;
	}
	
	public luckyPage clickbirthday() throws InterruptedException {
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ele_to_click.click();
		return this;
		
		
	}
	
}
