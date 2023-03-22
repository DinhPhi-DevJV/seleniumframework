package com.nopcommerce.user;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import PageObject.nopCommerce.user.UserHomePageObject;
import PageObject.nopCommerce.user.UserRegisterPageObject;

public class Level_4_Mutipl_Browser extends BaseTest {
	private WebDriver driver;
	private String emailAdress;
	private UserHomePageObject homePageObject;
	private UserRegisterPageObject registerPageObject;
	private String firstName, lastName, passWord;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePageObject = new UserHomePageObject(driver);
		firstName = "Automation";
		lastName = "FC";
		passWord = "123456";
	}

	@Test
	public void Register_01_Empty_Data() {
		System.out.println("Register_01 - Step 01 : Click to Register link");
		homePageObject.openRegisterPage();
		registerPageObject = new UserRegisterPageObject(driver);
		System.out.println("Register_01 - Step 02 : Click to Register button");
		registerPageObject.clickRegisterButton();
		System.out.println("Register_01 - Step 03 : Verify error messsage displayed");
		Assert.assertEquals(registerPageObject.getErrorMessageAtFistNameTextBox(), "First name is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtLastNameTextBox(), "Last name is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtEmailTextBox(), "Email is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtPaswordTextBox(), "Password is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtConfirmPasswordTextBox(), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		System.out.println("Register_02 - Step 01 : Click to Register link");
		homePageObject.openRegisterPage();
		System.out.println("Register_02 - Step 02 : Click to required fields");
		registerPageObject.inputToFirstNameTexBox("Automation");
		registerPageObject.inputToLastNameTexBox("FC");
		registerPageObject.inputToEmailTexBox("123@456#%*");
		registerPageObject.inputToPaswordTexBox("123456");
		registerPageObject.inputToConfirmPasswordTexBox("123456");
		System.out.println("Register_02 - Step 03 : Click to register button ");
		registerPageObject.clickToRegisterButton();
		System.out.println("Register_02 - Step 04 : Verify error message displayed");
		Assert.assertEquals(registerPageObject.getErrorAtEmailTextBox(), "Wrong email");
	}

	@Test
	public void Register_03_Success() {
		System.out.println("Register_03 - Step 01 : Click to Register link");
		homePageObject.openRegisterPage();
		System.out.println("Register_03 - Step 02 : Click to required fields");
		registerPageObject.inputToFirstNameTexBox(firstName);
		registerPageObject.inputToLastNameTexBox(lastName);
		registerPageObject.inputToEmailTexBox(emailAdress);
		registerPageObject.inputToPaswordTexBox(passWord);
		registerPageObject.inputToConfirmPasswordTexBox(passWord);
		System.out.println("Register_03 - Step 03 : Click to register button");
		registerPageObject.clickToRegisterButton();
		System.out.println("Register_03 - Step 04 : Verify success massge displayed");
		Assert.assertEquals(registerPageObject.getSuccessRegisterTextBox(), "Your registration completed");
		System.out.println("Register_03 - Step 05 : Click to logout link ");
		registerPageObject.clickToLogoutLink();
	}

	@Test
	public void Register_04_Existing_Email() {
		System.out.println("Register_04 - Step 01 : Click to Register link");
		homePageObject.openRegisterPage();
		System.out.println("Register_04 - Step 02 : Click to required fields");
		registerPageObject.inputToFirstNameTexBox(firstName);
		registerPageObject.inputToLastNameTexBox(lastName);
		registerPageObject.inputToEmailTexBox(emailAdress);
		registerPageObject.inputToPaswordTexBox(passWord);
		registerPageObject.inputToConfirmPasswordTexBox(passWord);
		System.out.println("Register_04 - Step 03 : Click to register button");
		registerPageObject.clickToRegisterButton();
		System.out.println("Register_04 - Step 04 : Verify success massge displayed");
		Assert.assertEquals(registerPageObject.getErrorExtingEmailMessge(), "The specified email already exists");
	}

	@Test
	public void Register_05_PassWord_Less_Than_6_Chars() {
		System.out.println("Register_05 - Step 01 : Click to Register link");
		homePageObject.openRegisterPage();
		System.out.println("Register_05 - Step 02 : Click to required fields");
		registerPageObject.inputToFirstNameTexBox(firstName);
		registerPageObject.inputToLastNameTexBox(lastName);
		registerPageObject.inputToEmailTexBox(emailAdress);
		registerPageObject.inputToPaswordTexBox("12345");
		registerPageObject.inputToConfirmPasswordTexBox("12345");
		System.out.println("Register_05 - Step 03 : Click to register button");
		registerPageObject.clickToRegisterButton();
		System.out.println("Register_05 - Step 04 : Verify error massge displayed");
		Assert.assertEquals(registerPageObject.getErrorMessageAtPaswordTextBox(),
				"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_06_Invalid_Comfirm_PassWord() {
		System.out.println("Register_06 - Step 01 : Click to Register link");
		homePageObject.openRegisterPage();
		System.out.println("Register_06 - Step 02 : Click to required fields");
		registerPageObject.inputToFirstNameTexBox(firstName);
		registerPageObject.inputToLastNameTexBox(lastName);
		registerPageObject.inputToEmailTexBox(emailAdress);
		registerPageObject.inputToPaswordTexBox("123456");
		registerPageObject.inputToConfirmPasswordTexBox("1235");
		System.out.println("Register_06 - Step 03 : Click to register button");
		registerPageObject.clickToRegisterButton();
		Assert.assertEquals(registerPageObject.getErrorMessageAtConfirmPasswordTextBox(),
				"The password and confirmation password do not match.");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int genarateFakeNumber() {
		Random random = new Random();
		return random.nextInt(9999);
	}
}
