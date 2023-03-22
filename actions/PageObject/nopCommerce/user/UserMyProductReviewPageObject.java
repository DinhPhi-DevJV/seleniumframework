package PageObject.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class UserMyProductReviewPageObject extends BasePage {
	private WebDriver driver;

	public UserMyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMyAcountPageDisplayed() {
		return isElementDisplayed(driver, null); 
	}

}
