package pageFacroty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='FirstName']")
	private WebElement fristNameTextBox;
	@FindBy(how = How.XPATH, using = "//input[@id='LastName']")
	private WebElement lastNameTextBox;
	@FindBy(how = How.XPATH, using = "//input[@id='Email']")
	private WebElement emailTextBox;
	@FindBy(how = How.XPATH, using = "//input[@id='Password']")
	private WebElement passwordTexBox;
	@FindBy(how = How.XPATH, using = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTexBox;
	@CacheLookup // không tìm element nhiều lần khi gọi element 2 lần.
	@FindBy(how = How.XPATH, using = "//button[@id='register-button']")
	private WebElement registerButton;
	@FindBy(how = How.XPATH, using = "//div[@class='result']")
	private WebElement registerSuccesMeassage;
	@FindBy(how = How.XPATH, using = "//a[@class='ico-logout']")
	private WebElement loginOutLink;
	@FindBy(xpath="//span[@id='FirstName-error']")
	private WebElement firstNameErrorMessage;
	@FindBy(xpath="//span[@id='LastName-error']")
	private WebElement lastNameErrorMessage;
	@FindBy(xpath="//span[@id='Email-error']")
	private WebElement emailErrorMessge;
	@FindBy(xpath="// span[@id='Password-error']")
	private WebElement passWordErrorMessage;
	@FindBy(xpath="//li[text()='The specified email already exists']")
	private WebDriver exitingErrorMessage;

	public void inputToFirstNameTexBox(String firstName) {
		sendkeys(driver, fristNameTextBox, firstName);
	}

	public void inputToLastNameTexBox(String lastName) {
		sendkeys(driver, lastNameTextBox, lastName);
	}

	public void inputToEmailTexBox(String exitingEmail) {

		sendkeys(driver, emailTextBox, exitingEmail);

	}

	public void inputToPaswordTexBox(String validPassWord) {
		sendkeys(driver, passwordTexBox, validPassWord);
	}

	public void inputToConfirmPasswordTexBox(String validPassWord) {

		sendkeys(driver, confirmPasswordTexBox, validPassWord);
	}

	public void clickToRegisterButton() {
		clickToElement(driver, registerButton);
	}

	public String getSuccessRegisterTextBox() {
		return getTextElement(driver, registerSuccesMeassage);
	}

	public void clickToLogoutLink() {
		clickToElement(driver, loginOutLink);
	}

}

