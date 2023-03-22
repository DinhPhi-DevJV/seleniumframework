package pageOject.facebook;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.facebook.LoginPageUI;

public class LoginPageObject extends BasePage {
	protected WebDriver drvier;

	public LoginPageObject(WebDriver driver) {
		this.drvier = driver;
	}

	public void clickToCreateNewAccount() {
		waitForElementClickable(drvier, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(drvier, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public boolean isEmailAddressTextboxDisplayed() {
		waitForElementVisible(drvier, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		return isElementDisplayed(drvier, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
	}

	public void enterToEmailAddressTextBox(String emailAddress) {
		waitForElementVisible(drvier, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeysToElement(drvier, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public boolean isConfirmEmailTextBoxDisplayed() {
		return isElementDisplayed(drvier, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}

	public void closePopupLogin() {
		waitForElementClickable(drvier, LoginPageUI.CLOSE_LOGIN_POPUP);
		clickToElement(drvier, LoginPageUI.CLOSE_LOGIN_POPUP);

	}

	public boolean isConfirmEmailAddressTextboxUndisplayed() {
		return isElementUndisplayed(drvier, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}

}
