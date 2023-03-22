package pageObjects.jQuery.uploadFile;

import org.openqa.selenium.WebDriver;

public class PageGenaratorMannager  {
	WebDriver driver;
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
		
		
	}

}
