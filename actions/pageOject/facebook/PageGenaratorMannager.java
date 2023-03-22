package pageOject.facebook;

import org.openqa.selenium.WebDriver;

public class PageGenaratorMannager {
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

}
