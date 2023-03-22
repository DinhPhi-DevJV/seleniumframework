package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_Cookie;

import PageObject.nopCommerce.user.UserHomePageObject;
import PageObject.nopCommerce.user.UserLoginPageObject;
import commons.BaseTest;
import commons.PageGenerator_Manager;

public class Level_16_Share_Data_C extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void BeforeClas(String browserName) {
		driver = getBrowserDriver(browserName);
		homePageObject = PageGenerator_Manager.getUserHomePageOject(driver);
	
		
		log.info("Pre - condition - Step 1: Navigate to login page");
		loginPageObject = homePageObject.openLoginPage();
		
		log.info("Pre - condition - Step 02: set cookies and reload page");
		loginPageObject.setCookies(driver, Common_01_Register_Cookie.loggedCookie);
		loginPageObject.refreshToPage(driver);
		
		log.info("Pre - condition - Step 03:verify that 'My account link' is displayed");
		verifyTrue(loginPageObject.isMyAccountLinkIsDisplayed());
	
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
}
