package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import PageObject.nopCommerce.user.UserHomePageObject;
import PageObject.nopCommerce.user.UserLoginPageObject;
import PageObject.nopCommerce.user.UserRegisterPageObject;

public class Level_6_Page_Generator_Manager_I extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePageObject;
	private UserRegisterPageObject registerPageObject;
	private UserLoginPageObject loginPageObject;
	private String firstName, lastName, validPassWord, notFoundEmail, invalidEmail, incorrectPassword, exitingEmail;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		firstName = "Automation";
		lastName = "FC";
		invalidEmail = "afc@afc.com@.vn";
		exitingEmail = "AFC" + genarateFakeNumber() + "@mail.vn";
		notFoundEmail = "AFC" + genarateFakeNumber() + "@mail.vn";
		validPassWord = "123456";
		incorrectPassword = "1232111";
		System.out.println("Pre-conditon - Step 01 : Click to Register link");
		// 1
		homePageObject = new UserHomePageObject(driver);
		homePageObject.openRegisterPage();
		// 2
		registerPageObject = new UserRegisterPageObject(driver);
		System.out.println("Pre-conditon  - Step 02 : Click to required fields");
		registerPageObject.inputToFirstNameTexBox(firstName);
		registerPageObject.inputToLastNameTexBox(lastName);
		registerPageObject.inputToEmailTexBox(exitingEmail);
		registerPageObject.inputToPaswordTexBox(validPassWord);
		registerPageObject.inputToConfirmPasswordTexBox(validPassWord);
		System.out.println("Pre-conditon  - Step 03 : Click to register button");
		registerPageObject.clickToRegisterButton();
		System.out.println("Pre-conditon  - Step 04 : Verify success massge displayed");
		Assert.assertEquals(registerPageObject.getSuccessRegisterTextBox(), "Your registration completed");
		System.out.println("Pre-conditon  - Step 05 : Click to logout link ");
		registerPageObject.clickToLogoutLink();
		// 3
		homePageObject = new UserHomePageObject(driver);
	}

	@Test
	public void Login_01_Empty_Data() {
		System.out.println("Login_01_Empty_Data - Step 01: click to login link");
		// 4
		homePageObject.openLoginPage();
		loginPageObject = new UserLoginPageObject(driver);
		System.out.println("Login_01_Empty_Data - Step 02: click to login button");
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getErrorMessageAtEmailTextBox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		homePageObject.openLoginPage();
		// 5
		loginPageObject = new UserLoginPageObject(driver);
		loginPageObject.inputToEmailTextBox(invalidEmail);
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getErrorMessageAtEmailTextBox(), "Wrong email");
	}

	@Test
	public void Loginr_03_Email_Not_Foud() {
		homePageObject.openLoginPage();
		// 6
		loginPageObject = new UserLoginPageObject(driver);
		loginPageObject.inputToEmailTextBox(notFoundEmail);
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getErrorMessageUnsuccessfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Register_04_Exiting_Email_And_Empty_PassWord() {
		homePageObject.openLoginPage();
		// 7
		loginPageObject = new UserLoginPageObject(driver);
		loginPageObject.inputToEmailTextBox(exitingEmail);
		loginPageObject.inputToPassWordTextBox("");
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getErrorMessageUnsuccessfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Register_05_Exiting_Email_And_Incorrect_PassWord() {
		homePageObject.openLoginPage();
		// 8
		loginPageObject = new UserLoginPageObject(driver);
		loginPageObject.inputToEmailTextBox(exitingEmail);
		loginPageObject.inputToPassWordTextBox(incorrectPassword);
		loginPageObject.clickToLoginButton();
		Assert.assertEquals(loginPageObject.getErrorMessageUnsuccessfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Register_06_Valid_Email_And_PassWord() {
		homePageObject.openLoginPage();
		// 9
		loginPageObject = new UserLoginPageObject(driver);
		loginPageObject.inputToEmailTextBox(exitingEmail);
		loginPageObject.inputToPassWordTextBox(validPassWord);
		loginPageObject.clickToLoginButton();
		// 10
		homePageObject = new UserHomePageObject(driver);
		Assert.assertTrue(loginPageObject.isMyAccountLinkIsDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	
}
