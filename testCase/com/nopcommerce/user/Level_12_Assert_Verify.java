package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGenerator_Manager;
import PageObject.nopCommerce.user.UserCustomerinfoPageObject;
import PageObject.nopCommerce.user.UserHomePageObject;
import PageObject.nopCommerce.user.UserLoginPageObject;
import PageObject.nopCommerce.user.UserRegisterPageObject;

public class Level_12_Assert_Verify extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePageObject = PageGenerator_Manager.getUserHomePageOject(driver);
		firstName = "Automation";
		lastName = "FC";
		emailAdress = "AFC" + genarateFakeNumber() + "@mail.vn";
		password = "123456";
	}

	@Test
	public void User_01_Register_Login() {
		log.info(" ");
		registerPageObject = homePageObject.openRegisterPage();
		registerPageObject.inputToFirstNameTexBox(firstName);
		registerPageObject.inputToLastNameTexBox(lastName);
		registerPageObject.inputToEmailTexBox(emailAdress);
		registerPageObject.inputToPaswordTexBox(password);
		registerPageObject.inputToConfirmPasswordTexBox(password);
		registerPageObject.clickToRegisterButton();
		verifyEquals(registerPageObject.getSuccessRegisterTextBox(), "Your registration completed...");

		homePageObject = registerPageObject.clickToLogoutLink();
		loginPageObject = homePageObject.openLoginPage();
		loginPageObject.inputToEmailTextBox(emailAdress);
		loginPageObject.inputToPassWordTextBox(password);
		homePageObject = loginPageObject.clickToLoginButton();
		verifyFalse(loginPageObject.isMyAccountLinkIsDisplayed());
		
		customerinfoPageObject = homePageObject.openMyAccountPage();
		verifyFalse(customerinfoPageObject.isCustomerInfoDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private UserHomePageObject homePageObject;
	private UserRegisterPageObject registerPageObject;
	private String firstName, lastName, password, emailAdress;
	private UserCustomerinfoPageObject customerinfoPageObject;
	private UserLoginPageObject loginPageObject;
}
