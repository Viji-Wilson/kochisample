package pagesGoogle;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import toolsqa.browsercommand;

public class homepage extends browsercommand {
	
	public homepage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//input[@value='Google Search'])[2]")
	private WebElement google_search_btn;
	
	@FindBy(xpath="(//input[@name='btnI'])[2]")
	private WebElement lucky_search_btn;
	
	public luckyPage click_luckysearch() throws InterruptedException {
		Thread.sleep(10000);
		lucky_search_btn.click();
		return new luckyPage();
	}
	
	
	
}
