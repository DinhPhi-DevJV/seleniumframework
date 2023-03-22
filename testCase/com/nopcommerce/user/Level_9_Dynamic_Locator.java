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

public class Level_9_Dynamic_Locator extends BaseTest {

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
		registerPageObject = homePageObject.openRegisterPage();
		registerPageObject.inputToFirstNameTexBox(firstName);
		registerPageObject.inputToLastNameTexBox(lastName);
		registerPageObject.inputToEmailTexBox(emailAdress);
		registerPageObject.inputToPaswordTexBox(password);
		registerPageObject.inputToConfirmPasswordTexBox(password);
		registerPageObject.clickToRegisterButton();
		Assert.assertEquals(registerPageObject.getSuccessRegisterTextBox(), "Your registration completed");
		homePageObject = registerPageObject.clickToLogoutLink();
		loginPageObject = homePageObject.openLoginPage();
		loginPageObject.inputToEmailTextBox(emailAdress);
		loginPageObject.inputToPassWordTextBox(password);
		homePageObject = loginPageObject.clickToLoginButton();
		Assert.assertTrue(loginPageObject.isMyAccountLinkIsDisplayed());
		customerinfoPageObject = homePageObject.openMyAccountPage();
	}

	@Test
	public void User_02_Dynamic_Page() {
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

	@Test
	public void User_03_Dynamic_Page_01() {
//		knowledge của page object :
//		một page a khi chuyển qua page b phải viết một hàm để mở page b lên (action , click, open)/link....
		// customer info -> address
		addressPageObject = (UserAddressPageObject) customerinfoPageObject.openPagesAtMyAccountByName(driver,
				"Addresses");
		// address -> My Product review
		myProductReviewPageObject = (UserMyProductReviewPageObject) addressPageObject.openPagesAtMyAccountByName(driver,
				"My product reviews");
		// My Product review-> RewardPoint
		rewardPointPageObject = (UserRewardPointPageObject) myProductReviewPageObject.openPagesAtMyAccountByName(driver,
				"Reward points");
		// RewardPoint-> Address
		addressPageObject = (UserAddressPageObject) rewardPointPageObject.openPagesAtMyAccountByName(driver,
				"Addresses");
		// Address -> RewardPoint
		rewardPointPageObject = (UserRewardPointPageObject) addressPageObject.openPagesAtMyAccountByName(driver,
				"My product reviews");
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
	private String firstName, lastName, password, emailAdress;
	private UserCustomerinfoPageObject customerinfoPageObject;
	private UserAddressPageObject addressPageObject;
	private UserMyProductReviewPageObject myProductReviewPageObject;
	private UserRewardPointPageObject rewardPointPageObject;
	private UserLoginPageObject loginPageObject;
}
