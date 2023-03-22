package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject.nopCommerce.user.UserCustomerinfoPageObject;
import PageObject.nopCommerce.user.UserHomePageObject;
import PageObject.nopCommerce.user.UserLoginPageObject;
import PageObject.nopCommerce.user.UserRegisterPageObject;
import commons.BaseTest;
import commons.PageGenerator_Manager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Level_15_AllureReport extends BaseTest {
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
	@Description("Register to system")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void User_01_Register() {
	
		registerPageObject = homePageObject.openRegisterPage();

		registerPageObject.inputToFirstNameTexBox(firstName);

		registerPageObject.inputToLastNameTexBox(lastName);
		
		registerPageObject.inputToEmailTexBox(emailAdress);

		registerPageObject.inputToPaswordTexBox(password);

		registerPageObject.inputToConfirmPasswordTexBox(password);

		registerPageObject.clickToRegisterButton();

		Assert.assertEquals(registerPageObject.getSuccessRegisterTextBox(), "Your registration completed");

	}
	@Description("Login to system")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void User_02_Login() {
		
		homePageObject = registerPageObject.clickToLogoutLink();
		loginPageObject = homePageObject.openLoginPage();

		loginPageObject.inputToEmailTextBox(emailAdress);

		loginPageObject.inputToPassWordTextBox(password);

		homePageObject = loginPageObject.clickToLoginButton();

		Assert.assertFalse(loginPageObject.isMyAccountLinkIsDisplayed());

		customerinfoPageObject = homePageObject.openMyAccountPage();
		
		Assert.assertFalse(customerinfoPageObject.isCustomerInfoDisplayed());
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
