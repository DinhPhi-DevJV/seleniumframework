package PageObject.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGenerator_Manager;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToUserPassWord(String password) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXT_BOX);
		sendkeysToElement(driver, AdminLoginPageUI.PASSWORD_TEXT_BOX, password);
	}

	public void inputToUserName(String email) {
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXT_BOX);
		sendkeysToElement(driver, AdminLoginPageUI.EMAIL_TEXT_BOX, email);
	}

	public AdminDashboardPageObject clickToLoginButton() {
		waitForElementVisible(driver, AdminLoginPageUI.BUTTON_LOGIN);
		clickToElement(driver, AdminLoginPageUI.BUTTON_LOGIN);
		return PageGenerator_Manager.getDashBoardPageObject(driver);
	}

	public AdminDashboardPageObject loginAsAdmin(String email, String password) {
		inputToUserName(email);
		inputToUserPassWord(password);
		return clickToLoginButton();
	}
}
