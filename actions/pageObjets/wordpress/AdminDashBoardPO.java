package pageObjets.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminDashboardPageUI;

public class AdminDashBoardPO extends BasePage{
	private WebDriver driver;

	public AdminDashBoardPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostSearchPO clickToPostMenuLink() {
	waitForElementClickable(driver, AdminDashboardPageUI.POST_MENU_LINK);
	clickToElement(driver, AdminDashboardPageUI.POST_MENU_LINK);
	return PageGenaratorManager.getAdminPostSearchPO(driver);
	
	}

	public AdminUserPO clickToUsertMenuLink() {
		waitForElementClickable(driver,AdminDashboardPageUI.USER_MENU_LINK);
		clickToElement(driver, AdminDashboardPageUI.USER_MENU_LINK);
		return PageGenaratorManager.getAdminUserPageObject(driver);
	}

}
