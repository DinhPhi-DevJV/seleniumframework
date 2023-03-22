package pageObjets.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminLoginPageUI;

public class AdminLoginPO extends BasePage{
	private WebDriver driver;
	public AdminLoginPO(WebDriver driver) {
		this.driver = driver;
	}
	public void enterToUserName(String adminUserName) {
		waitForElementVisible(driver, AdminLoginPageUI.USERNAME_TEXTBOX);
		sendkeysToElement(driver,AdminLoginPageUI.USERNAME_TEXTBOX , adminUserName);

	}
	public void enterToPassword(String adminPassWord) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeysToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassWord);
		
	}
	public AdminDashBoardPO clickToLogin() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGenaratorManager.getAdminDashboardPO(driver);
		
	}
	

}
