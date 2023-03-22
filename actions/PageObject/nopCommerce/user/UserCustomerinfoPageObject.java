package PageObject.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopComerce.user.CustomerPageUI;

public class UserCustomerinfoPageObject extends BasePage {
	private WebDriver driver;

	public UserCustomerinfoPageObject(WebDriver driver) {
		this.driver = driver;
	}
	@Step("Verify that customer info is displayed ")
	public boolean isCustomerInfoDisplayed() {
		waitForElementVisible(driver, CustomerPageUI.CUSTOMER_INFO_HEADER);
		return isElementDisplayed(driver, CustomerPageUI.CUSTOMER_INFO_HEADER);
	}

	public boolean isMyAccountPageDisplayed() {
		waitForElementVisible(driver, CustomerPageUI.CUSTOMER_INFO_HEADER);
		return isElementDisplayed(driver, CustomerPageUI.CUSTOMER_INFO_HEADER);
	}

}