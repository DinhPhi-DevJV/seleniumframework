package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_User;

import PageObject.nopCommerce.user.UserHomePageObject;
import PageObject.nopCommerce.user.UserLoginPageObject;
import commons.BaseTest;
import commons.PageGenerator_Manager;

public class Level_16_Share_Data extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void BeforeClas(String browserName) {
		driver = getBrowserDriver(browserName);
		homePageObject = PageGenerator_Manager.getUserHomePageOject(driver);
		emailAdress =  Common_01_Register_End_User.emailAdress;
		password =  Common_01_Register_End_User.password;
		
		log.info("Login - Step 1: Navigate to login page");
		loginPageObject = homePageObject.openLoginPage();

		log.info("Login - Step 2: Enter to Email textbox with value is '" + emailAdress + "'");
		loginPageObject.inputToEmailTextBox(emailAdress);

		log.info("Login - Step 3: Enter to Password textbox with value is '" + password + "'");
		loginPageObject.inputToPassWordTextBox(password);

		log.info("Login - Step 4: click to Login button");
		homePageObject = loginPageObject.clickToLoginButton();

	}

	@Test
	public void Search_01_Empty_Data() {

	}

	@Test
	public void Search_02_Relative_Product_Name() {

	}

	@Test
	public void Search_03_Absolute_Product_Name() {

	}

	@Test
	public void Search_04_Parent_Category() {

	}

	@Test
	public void Search_05_Incorrect_ManuFacturer() {

	}

	@Test
	public void Search_06_Correct_ManuFacturer() {

	}

	@AfterClass
	public void afterTest() {
		driver.quit();
	}

	private WebDriver driver;
	private UserHomePageObject homePageObject;
	private UserLoginPageObject loginPageObject;
	private String emailAdress, password;
}
