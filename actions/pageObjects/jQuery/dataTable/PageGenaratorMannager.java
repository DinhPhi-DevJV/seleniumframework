package pageObjects.jQuery.dataTable;

import org.openqa.selenium.WebDriver;

public class PageGenaratorMannager {
	public static HomePageObject getHomePage (WebDriver driver) {
		return new HomePageObject(driver);
	}
}
