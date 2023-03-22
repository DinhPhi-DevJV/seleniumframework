package com.nopcommerce.user;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageFacroty.HomePageObject;
import pageFacroty.LoginPageObject;
import pageFacroty.RegisterPageObject;

public class Level_5_Page_Factory extends BaseTest {
	WebDriver driver;

	// Declare
	String projectPath = System.getProperty("user.dir");
	HomePageObject homePageObject;
	RegisterPageObject registerPageObject;
	String firstName, lastName, validPassWord, notFoundEmail, invalidEmail, incorrectPassword, exitingEmail;

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
		homePageObject = new HomePageObject(driver);
		homePageObject.clickToRegisterLink();
		registerPageObject = new RegisterPageObject(driver);
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
		homePageObject = new HomePageObject(driver);
	}

	@Test

	public void Login_01_Empty_Data() {
		System.out.println("Login 01 - Step-1: click to Login Link");
		homePageObject.clickToLoginLink();
		LoginPageObject loginPageObject = new LoginPageObject(driver);
		System.out.println("Login 01 - Step-2: click to Login button");
		loginPageObject.clickToLoginButton();
		System.out.println("Login 01 - Step-3: verify that the error message displayed with a true content");
		Assert.assertEquals(loginPageObject.getErrorMeassageAtEmailTexBox(), "Please enter your email");
		
	}

	@Test
	public void Login_02_Invalid_Email() {
		System.out.println("Login 01 - Step-1: click to Login Link");
		homePageObject.clickToLoginLink();
		LoginPageObject loginPageObject = new LoginPageObject(driver);
		System.out.println("Login 02 - step-2: input invalid email to email text box");
		loginPageObject.inputToEmailTextBox(invalidEmail);
		System.out.println("Login 02 - step-3: input valid passsword to email text box");
		loginPageObject.inputToPasswordTextBox("1234567");
		System.out.println("Login 02 - step-4: verify that error messsage dispalyed at email text box");
		Assert.assertEquals(loginPageObject.getErrorMeassageAtEmailTexBox(), "Wrong email");
	}

	@Test
	public void Loginr_03_Email_Not_Foud() {

	}

	@Test
	public void Register_04_Exiting_Email_And_Empty_PassWord() {

	}

	@Test
	public void Register_05_Exiting_Email_And_Incorrect_PassWord() {

	}

	@Test
	public void Register_05_Valid_Email_And_PassWord() {

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
