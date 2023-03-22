package PageObject.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGenerator_Manager;
import io.qameta.allure.Step;
import pageUIs.nopComerce.user.LoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	@Step("Enter to email text box")
	public void inputToEmailTextBox(String invalidEmail) {
		sendkeysToElement(driver, LoginPageUI.INPUT_TO_EMAIL_TEXT_BOX, invalidEmail);
	}
	@Step("Enter to password text box")
	public void inputToPassWordTextBox(String string) {
		sendkeysToElement(driver, LoginPageUI.INPUT_TO_PASSWORD_TEXT_BOX, string);
	}
	@Step("Click to login button")
	public UserHomePageObject clickToLoginButton() {
		clickToElement(driver, LoginPageUI.CLICK_TO_LOGIN_BUTTON);
		// return new HomePageObject(driver);
		return PageGenerator_Manager.getUserHomePageOject(driver);
	}

	public String getErrorMessageAtEmailTextBox() {
		return getTextElement(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageUnsuccessfull() {
		return getTextElement(driver, LoginPageUI.UNSUCCESS_ERROR_MESSAGE);
	}
	@Step("Verify that my account link is displayed")
	public boolean isMyAccountLinkIsDisplayed() {
		return isElementDisplayed(driver, LoginPageUI.MY_ACCOUNT_IS_DISPLAYED);
	}

	public UserHomePageObject loginAsUser(String emailAddress, String password) {
		inputToEmailTextBox(emailAddress);
		inputToPassWordTextBox(password);
		return clickToLoginButton();
	}

}
