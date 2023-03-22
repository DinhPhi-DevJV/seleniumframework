package pageFacroty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Email")
	private WebElement emailTextBox;
	@FindBy(id = "Password")
	private WebElement paswordTextBox;
	@FindBy(xpath = "//button[contains(@class,'login-button')]")
	private WebElement loginButton;
	@FindBy(id = "Email-error")
	private WebElement emailErrorMessage;
	@FindBy(xpath = "//div[contains(@class,'validation-summary-errors')]")
	private WebElement unsuccessErrorMessage;

	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}

	public String getErrorMeassageAtEmailTexBox() {
		return getTextElement(driver, emailErrorMessage);
	}

	public void inputToEmailTextBox(String invalidEmail) {
		waitForElementVisible(driver, emailTextBox);
		sendkeys(driver, emailTextBox, invalidEmail);
	}

	public String getErrorMeassageUnSuccessfull() {
		return getTextElement(driver, unsuccessErrorMessage);
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver, paswordTextBox);
		sendkeys(driver, paswordTextBox, password);
	}

}
