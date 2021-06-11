package test;



import org.testng.annotations.Test;

import pagesGoogle.homepage;
import toolsqa.browsercommand;

public class testcaseno1 extends browsercommand{
	
	
	@Test
	public void testone() throws InterruptedException {
		
		new homepage().click_luckysearch()
		.searchdoodle()
		.clickbirthday();
	}

}
