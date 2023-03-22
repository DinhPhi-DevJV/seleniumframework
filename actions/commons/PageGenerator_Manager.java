package commons;

import org.openqa.selenium.WebDriver;

import PageObject.nopCommerce.admin.AdminDashboardPageObject;
import PageObject.nopCommerce.admin.AdminLoginPageObject;
import PageObject.nopCommerce.user.UserAddressPageObject;
import PageObject.nopCommerce.user.UserCustomerinfoPageObject;
import PageObject.nopCommerce.user.UserHomePageObject;
import PageObject.nopCommerce.user.UserLoginPageObject;
import PageObject.nopCommerce.user.UserMyProductReviewPageObject;
import PageObject.nopCommerce.user.UserRegisterPageObject;
import PageObject.nopCommerce.user.UserRewardPointPageObject;

public class PageGenerator_Manager {
	public static UserHomePageObject getUserHomePageOject(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPageOject(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static UserRegisterPageObject getUserRegistrObject(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static UserCustomerinfoPageObject getUserCustomerinfoPageObject(WebDriver driver) {
		return new UserCustomerinfoPageObject(driver);
	}

	public static UserAddressPageObject getUserAddressPageObject(WebDriver driver) {
		return new UserAddressPageObject(driver);
	}

	public static UserMyProductReviewPageObject getUsertmyMyProductReviewPageObject(WebDriver driver) {
		return new UserMyProductReviewPageObject(driver);
	}

	public static UserRewardPointPageObject getUsermyreRewardPointPageObject(WebDriver driver) {
		return new UserRewardPointPageObject(driver);
	}

	public static AdminLoginPageObject getAdminLoginPageObject(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashboardPageObject getDashBoardPageObject(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}
	
}
