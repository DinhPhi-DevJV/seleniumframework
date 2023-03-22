package PageObject.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGenerator_Manager;
import io.qameta.allure.Step;
import pageUIs.nopComerce.user.RegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String getErrorMessageAtFistNameTextBox() {
		return getTextElement(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtLastNameTextBox() {
		return getTextElement(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailTextBox() {
		return getTextElement(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPaswordTextBox() {
		return getTextElement(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPasswordTextBox() {
		return getTextElement(driver, RegisterPageUI.CONFIRM_PASS_WORD_ERROR_MESSAGE);
	}
	@Step("Enter to First Name textbox with value is {0}")
	public void inputToFirstNameTexBox(String firstName) {
		sendkeysToElement(driver, RegisterPageUI.INPUT_FIRST_NAME_TEXT_BOX, firstName);
	}
	@Step("Enter to Last Name textbox with value is {0}")
	public void inputToLastNameTexBox(String lastName) {
		sendkeysToElement(driver, RegisterPageUI.INPUT_LAST_NAME_TEXT_BOX, lastName);

	}
	@Step("Enter to Password textbox with value is {0}")
	public void inputToPaswordTexBox(String passWord) {
		sendkeysToElement(driver, RegisterPageUI.INPUT_PASS_WORD_TEXT_BOX, passWord);

	}
	@Step("Enter to Email textbox with value is {0}")
	public void inputToEmailTexBox(String email) {
		sendkeysToElement(driver, RegisterPageUI.INPUT_EMAIL_TEXT_BOX, email);

	}
	@Step("Enter to Confirm password textbox with value is {0}")
	public void inputToConfirmPasswordTexBox(String confrmPassWord) {
		sendkeysToElement(driver, RegisterPageUI.INPUT_CONFIRM_PASS_WORD_TEXT_BOX, confrmPassWord);

	}
	@Step("Click to register button")
	public void clickToRegisterButton() {
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);

	}
	public String getErrorAtEmailTextBox() {
		return getTextElement(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorExtingEmailMessge() {
		return getTextElement(driver, RegisterPageUI.EXITING_EMAIL_ERROR_MESSAGE);
	}
	@Step("Verify register success massage is displayed")
	public String getSuccessRegisterTextBox() {
		return getTextElement(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}
	@Step("Click to logout link")
	public UserHomePageObject clickToLogoutLink() {
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		// return new HomePageObject(driver);
		return PageGenerator_Manager.getUserHomePageOject(driver);
	}


	

	

}
