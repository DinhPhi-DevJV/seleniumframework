package PageObject.sauceLab;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.SauceLad.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUserNameTexBox(String userName) {
		waitForElementVisible(driver, LoginPageUI.USERNAME_TEXT_BOX);
		sendkeysToElement(driver, LoginPageUI.USERNAME_TEXT_BOX, userName);
	}

	public void enterToPassWordTexBox(String passWord) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXT_BOX);
		sendkeysToElement(driver, LoginPageUI.PASSWORD_TEXT_BOX, passWord);
	}

	public ProductPageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver,  LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getproductPage(driver);
	}

}
