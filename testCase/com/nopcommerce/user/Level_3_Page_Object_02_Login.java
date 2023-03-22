package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObject.nopCommerce.user.UserHomePageObject;
import PageObject.nopCommerce.user.UserRegisterPageObject;

public class Level_3_Page_Object_02_Login {
	WebDriver driver;
	String emailAdress;
	// Declare
	String projectPath = System.getProperty("user.dir");
	UserHomePageObject homePageObject;
	UserRegisterPageObject registerPageObject;
	String firstName, lastName, passWord;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\BrowserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		// Initial

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com");
		homePageObject = new UserHomePageObject(driver);
		firstName = "Automation";
		lastName = "FC";
		passWord = "123456";
		emailAdress = "AFC" + genarateFakeNumber() + "@mail.vn";

		System.out.println("Pre-conditon - Step 01 : Click to Register link");
		homePageObject.openRegisterPage();
		registerPageObject = new UserRegisterPageObject(driver);
		System.out.println("Pre-conditon  - Step 02 : Click to required fields");
		registerPageObject.inputToFirstNameTexBox(firstName);
		registerPageObject.inputToLastNameTexBox(lastName);
		registerPageObject.inputToEmailTexBox(emailAdress);
		registerPageObject.inputToPaswordTexBox(passWord);
		registerPageObject.inputToConfirmPasswordTexBox(passWord);
		System.out.println("Pre-conditon  - Step 03 : Click to register button");
		registerPageObject.clickToRegisterButton();
		System.out.println("Pre-conditon  - Step 04 : Verify success massge displayed");
		Assert.assertEquals(registerPageObject.getSuccessRegisterTextBox(), "Your registration completed");
		System.out.println("Pre-conditon  - Step 05 : Click to logout link ");
		registerPageObject.clickToLogoutLink();
		homePageObject = new UserHomePageObject(driver);

	}

	@Test
	public void Login_01_Empty_Data() {

	}

	@Test
	public void Login_02_Invalid_Email() {

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
	}

	public int genarateFakeNumber() {
		Random random = new Random();
		return random.nextInt(9999);
	}
}
