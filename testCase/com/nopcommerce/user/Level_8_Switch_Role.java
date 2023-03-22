package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject.nopCommerce.admin.AdminDashboardPageObject;
import PageObject.nopCommerce.admin.AdminLoginPageObject;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGenerator_Manager;
import PageObject.nopCommerce.user.UserCustomerinfoPageObject;
import PageObject.nopCommerce.user.UserHomePageObject;
import PageObject.nopCommerce.user.UserLoginPageObject;

public class Level_8_Switch_Role extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePageObject = PageGenerator_Manager.getUserHomePageOject(driver);
		userEmailAdress = "automationfc0811@mail.vn";
		userPassword = "123456";
		adminEmailAdress = "admin@yourstore.com";
		adminPassword = "admin";
	}

	@Test
	public void Role_01_User_To_Admin() {
		// login as user role

		userLoginPageObject = userHomePageObject.openLoginPage();
		userHomePageObject = userLoginPageObject.loginAsUser(userEmailAdress, userPassword);
		Assert.assertTrue(userLoginPageObject.isMyAccountLinkIsDisplayed());
		// home page chuyển sang customer info
		userCustomerinfoPageObject = userHomePageObject.openMyAccountPage();
		// customer info click logout link -> home
		userHomePageObject = userCustomerinfoPageObject.clickToLogoutLinkAtUserPage(driver);
		// user home page -> open admin page -> login page (Admin)
		userHomePageObject.openPageUlr(driver, GlobalConstants.ADMIN_PAGE_ULR);
		adminLoginPageObject = PageGenerator_Manager.getAdminLoginPageObject(driver);
		// login as Admin role
		adminDashboardPageObject = adminLoginPageObject.loginAsAdmin(adminEmailAdress, adminPassword);
		Assert.assertTrue(adminDashboardPageObject.isDashBoardHeaderDisplayed());
		// dashboard page -> click logout -> login page Admin
		adminLoginPageObject = adminDashboardPageObject.clickToLogoutLinkAtAdminPage(driver);
	}

	@Test
	public void Role_02_Admin_To_User() {
		// login page admin -> open ulr -> home page user
		adminLoginPageObject.openPageUlr(driver, GlobalConstants.PORTAL_PAGE_ULR);
		userHomePageObject = PageGenerator_Manager.getUserHomePageOject(driver);
		// home page - > login page user
		userLoginPageObject = userHomePageObject.openLoginPage();
		// login page user.
		userHomePageObject = userLoginPageObject.loginAsUser(userEmailAdress, userPassword);
		Assert.assertTrue(userLoginPageObject.isMyAccountLinkIsDisplayed());

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

	private WebDriver driver;
	private UserHomePageObject userHomePageObject;
	private UserCustomerinfoPageObject userCustomerinfoPageObject;
	private String userPassword, userEmailAdress;
	private String adminPassword, adminEmailAdress;
	private UserLoginPageObject userLoginPageObject;
	private AdminLoginPageObject adminLoginPageObject;
	private AdminDashboardPageObject adminDashboardPageObject;

}