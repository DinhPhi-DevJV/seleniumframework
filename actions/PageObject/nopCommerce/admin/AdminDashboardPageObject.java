package PageObject.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.admin.DashboardPageUI;

public class AdminDashboardPageObject extends BasePage {
	WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashBoardHeaderDisplayed() {
		waitForElementVisible(driver, DashboardPageUI.HEADER_OF_DASHBOARD_PAGE);
		return isElementDisplayed(driver, DashboardPageUI.HEADER_OF_DASHBOARD_PAGE);
	}
}
