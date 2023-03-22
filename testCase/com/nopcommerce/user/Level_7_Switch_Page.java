package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGenerator_Manager;
import PageObject.nopCommerce.user.UserAddressPageObject;
import PageObject.nopCommerce.user.UserCustomerinfoPageObject;
import PageObject.nopCommerce.user.UserHomePageObject;
import PageObject.nopCommerce.user.UserLoginPageObject;
import PageObject.nopCommerce.user.UserMyProductReviewPageObject;
import PageObject.nopCommerce.user.UserRegisterPageObject;
import PageObject.nopCommerce.user.UserRewardPointPageObject;

public class Level_7_Switch_Page extends BaseTest {

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
	public void User_01_Register() {

		registerPageObject = homePageObject.openRegisterPage();
		registerPageObject.inputToFirstNameTexBox(firstName);
		registerPageObject.inputToLastNameTexBox(lastName);
		registerPageObject.inputToEmailTexBox(emailAdress);
		registerPageObject.inputToPaswordTexBox(password);
		registerPageObject.inputToConfirmPasswordTexBox(password);
		registerPageObject.clickToRegisterButton();
		Assert.assertEquals(registerPageObject.getSuccessRegisterTextBox(), "Your registration completed");
		homePageObject = registerPageObject.clickToLogoutLink();

	}

	@Test
	public void User_02_Login() {
		loginPageObject = homePageObject.openLoginPage();
		loginPageObject.inputToEmailTextBox(emailAdress);
		loginPageObject.inputToPassWordTextBox(password);
		homePageObject = loginPageObject.clickToLoginButton();
		Assert.assertTrue(loginPageObject.isMyAccountLinkIsDisplayed());
	}

	@Test
	public void User_03_My_Account() {
		customerinfoPageObject = homePageObject.openMyAccountPage();
		Assert.assertTrue(customerinfoPageObject.isMyAccountPageDisplayed());

	}

	@Test
	public void User_04_Switch_Page() {
//		knowledge của page object :
//		một page a khi chuyển qua page b phải viết một hàm để mở page b lên (action , click, open)/link....
		// customer info -> address
		addressPageObject = customerinfoPageObject.openAddressPage(driver);
		// address -> My Product review
		myProductReviewPageObject = addressPageObject.openMyProductReviewPage(driver);
		// My Product review-> RewardPoint
		rewardPointPageObject = myProductReviewPageObject.openRewardPointPage(driver);
		// RewardPoint-> Address
		addressPageObject = rewardPointPageObject.openAddressPage(driver);
		// Address -> RewardPoint
		rewardPointPageObject = addressPageObject.openRewardPointPage(driver);
		// RewardPoint- > My product review
		myProductReviewPageObject = rewardPointPageObject.openMyProductReviewPage(driver);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private UserHomePageObject homePageObject;
	private UserRegisterPageObject registerPageObject;
	private UserLoginPageObject loginPageObject;
	private String firstName, lastName, password, emailAdress;
	private UserCustomerinfoPageObject customerinfoPageObject;
	private UserAddressPageObject addressPageObject;
	private UserMyProductReviewPageObject myProductReviewPageObject;
	private UserRewardPointPageObject rewardPointPageObject;

}
