package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import PageObject.nopCommerce.user.UserHomePageObject;
import PageObject.nopCommerce.user.UserLoginPageObject;
import PageObject.nopCommerce.user.UserRegisterPageObject;
import commons.BaseTest;
import commons.PageGenerator_Manager;

public class Level_17_Custom_Close_Driver extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePageObject = PageGenerator_Manager.getUserHomePageOject(driver);
		firstName = "Automation";
		lastName = "FC";
		emailAdress = "AFC" + genarateFakeNumber() + "@mail.vn";
		password = "123456";
		log.info("pre-condition - Step 1: Navigate to 'Rigisster' page");
		registerPageObject = homePageObject.openRegisterPage();

		log.info("pre-condition - Step 2: Enter to First name textbox with value is '" + firstName + "'");
		registerPageObject.inputToFirstNameTexBox(firstName);

		log.info("pre-condition - Step 3: Enter to Last name textbox with value is '" + firstName + "'");
		registerPageObject.inputToLastNameTexBox(lastName);

		log.info("pre-condition - Step 4: Enter to Email textbox with value is '" + emailAdress + "'");
		registerPageObject.inputToEmailTexBox(emailAdress);

		log.info("pre-condition - Step 5: Enter to Password textbox with value is '" + password + "'");
		registerPageObject.inputToPaswordTexBox(password);

		log.info("pre-condition - Step 6: Enter to Confirm password textbox with value is '" + password + "'" + " ");
		registerPageObject.inputToConfirmPasswordTexBox(password);

		log.info("pre-condition - Step 7: Click to register button");
		registerPageObject.clickToRegisterButton();

		log.info("pre-condition - Step 8: Verify that the 'Your registration completed.' message is displayed '");
		Assert.assertEquals(registerPageObject.getSuccessRegisterTextBox(), "Your registration completed.....");

		log.info("pre-condition - Step 9: Navigate to login page");
		loginPageObject = homePageObject.openLoginPage();

		log.info("pre-condition - Step 10: Enter to Email textbox with value is '" + emailAdress + "'");
		loginPageObject.inputToEmailTextBox(emailAdress);

		log.info("pre-condition - Step 11: Enter to Password textbox with value is '" + password + "'");
		loginPageObject.inputToPassWordTextBox(password);

		log.info("pre-condition - Step 12: click to Login button");
		homePageObject = loginPageObject.clickToLoginButton();
	}

	@Test
	public void Search_01_Name() {

	}

	@Test
	public void Search_02_Adress() {
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		// ngoại lệ browser đã tắt
		closeBrowserDriver();
		
	}

	private WebDriver driver;
	private UserHomePageObject homePageObject;
	private UserRegisterPageObject registerPageObject;
	private String firstName, lastName, password, emailAdress;
	private UserLoginPageObject loginPageObject;
}
