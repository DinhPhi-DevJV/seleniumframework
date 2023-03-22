package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import PageObject.nopCommerce.user.UserHomePageObject;
import PageObject.nopCommerce.user.UserLoginPageObject;
import PageObject.nopCommerce.user.UserRegisterPageObject;
import commons.BaseTest;
import commons.PageGenerator_Manager;

public class Common_01_Register_Cookie extends BaseTest {

	
	@Parameters("browser")
	@BeforeTest(description = "Create new common user for all class test")
	public void Register(String browserName) {
		
		driver = getBrowserDriver(browserName);
		homePageObject = PageGenerator_Manager.getUserHomePageOject(driver);
		firstName = "Automation";
		lastName = "FC";
		emailAdress = "AFC" + genarateFakeNumber() + "@mail.vn";
		password = "123456";
		
		log.info("Pre_condition - Step 1: Navigate to 'Rigisster' page");
		registerPageObject = homePageObject.openRegisterPage();
		
		log.info("Pre_condition - Step 2: Enter to First name textbox with value is '"+ firstName+"'");
		registerPageObject.inputToFirstNameTexBox(firstName);
		
		log.info("Pre_condition - Step 3: Enter to Last name textbox with value is '"+ firstName+"'");
		registerPageObject.inputToLastNameTexBox(lastName);
		
		log.info("Pre_condition - Step 4: Enter to Email textbox with value is '"+ emailAdress+"'");
		registerPageObject.inputToEmailTexBox(emailAdress);
		
		log.info("Pre_condition - Step 5: Enter to Password textbox with value is '"+ password+"'");
		registerPageObject.inputToPaswordTexBox(password);
		
		log.info("Pre_condition - Step 6: Enter to Confirm password textbox with value is '"+ password+"'"+" ");
		registerPageObject.inputToConfirmPasswordTexBox(password);
		
		log.info("Pre_condition - Step 7: Click to register button");
		registerPageObject.clickToRegisterButton();
		
		log.info("Pre_condition - Step 8: Verify that the 'Your registration completed.' message is displayed '");
		verifyEquals(registerPageObject.getSuccessRegisterTextBox(), "Your registration completed");
		
		log.info("Pre_condition - Step 9: Click to logout link");
		
		log.info("Pre_condition - Step 10: Navigate to login page");
		loginPageObject = homePageObject.openLoginPage();

		log.info("Pre_condition - Step 11: Enter to Email textbox with value is '" + emailAdress + "'");
		loginPageObject.inputToEmailTextBox(emailAdress);

		log.info("Pre_condition - Step 13: Enter to Password textbox with value is '" + password + "'");
		loginPageObject.inputToPassWordTextBox(password);

		log.info("Pre_condition - Step 14: click to Login button");
		homePageObject = loginPageObject.clickToLoginButton();
		loggedCookie = homePageObject.getAllCookie(driver);
	}
	

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	private WebDriver driver;
	private UserHomePageObject homePageObject;
	private UserRegisterPageObject registerPageObject;
	private String firstName, lastName;
	private String  password, emailAdress;
	private UserLoginPageObject loginPageObject;
	public static Set<Cookie> loggedCookie;

}
