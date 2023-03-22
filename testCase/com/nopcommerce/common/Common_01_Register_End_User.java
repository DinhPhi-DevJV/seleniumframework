package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import PageObject.nopCommerce.user.UserHomePageObject;
import PageObject.nopCommerce.user.UserRegisterPageObject;
import commons.BaseTest;
import commons.PageGenerator_Manager;

public class Common_01_Register_End_User extends BaseTest {

	
	@Parameters("browser")
	@BeforeTest(description = "Create new common user for all class test")
	public void Register(String browserName) {
		
		driver = getBrowserDriver(browserName);
		homePageObject = PageGenerator_Manager.getUserHomePageOject(driver);
		firstName = "Automation";
		lastName = "FC";
		emailAdress = "AFC" + genarateFakeNumber() + "@mail.vn";
		password = "123456";
		
		log.info("Register - Step 1: Navigate to 'Rigisster' page");
		registerPageObject = homePageObject.openRegisterPage();
		
		log.info("Register - Step 2: Enter to First name textbox with value is '"+ firstName+"'");
		registerPageObject.inputToFirstNameTexBox(firstName);
		
		log.info("Register - Step 3: Enter to Last name textbox with value is '"+ firstName+"'");
		registerPageObject.inputToLastNameTexBox(lastName);
		
		log.info("Register - Step 4: Enter to Email textbox with value is '"+ emailAdress+"'");
		registerPageObject.inputToEmailTexBox(emailAdress);
		
		log.info("Register - Step 5: Enter to Password textbox with value is '"+ password+"'");
		registerPageObject.inputToPaswordTexBox(password);
		
		log.info("Register - Step 6: Enter to Confirm password textbox with value is '"+ password+"'"+" ");
		registerPageObject.inputToConfirmPasswordTexBox(password);
		
		log.info("Register - Step 7: Click to register button");
		registerPageObject.clickToRegisterButton();
		
		log.info("Register - Step 8: Verify that the 'Your registration completed.' message is displayed '");
		verifyEquals(registerPageObject.getSuccessRegisterTextBox(), "Your registration completed");
		
		log.info("Register - Step 9: Click to logout link");
	//	homePageObject = registerPageObject.clickToLogoutLink();

	}
	

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	private WebDriver driver;
	private UserHomePageObject homePageObject;
	private UserRegisterPageObject registerPageObject;
	private String firstName, lastName;
	public static String  password, emailAdress;

}
