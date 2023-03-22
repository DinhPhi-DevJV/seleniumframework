package com.wordpress.admin;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import pageObjets.wordpress.AdminDashBoardPO;
import pageObjets.wordpress.AdminLoginPO;
import pageObjets.wordpress.AdminUserPO;
import pageObjets.wordpress.PageGenaratorManager;

public class User_01_View_User extends BaseTest {

	@Parameters({ "browser", "urlAdmin", "urlUser" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
		log.info("pre-conditon - Step 01: open browser and admin Url");
		this.adminUrl = adminUrl;
		this.endUserUrl = endUserUrl;
		driver = getBrowserDriver(browserName, this.adminUrl);
		adminloginPage = PageGenaratorManager.getAdminLoginPO(driver);

		log.info("pre-conditon - Step 02: Enter to Username textbox with value : " + adminUserName);
		adminloginPage.enterToUserName(adminUserName);

		log.info("pre-conditon - Step 03: Enter to Password textbox with value: " + adminPassWord);
		adminloginPage.enterToPassword(adminPassWord);

		log.info("pre-conditon - Step 04: Enter to Login button");
		adminDashboardPage = adminloginPage.clickToLogin();

	}

	@Test
	public void TC_01_View_User() throws SQLException {
		log.info(" View User - Step 01: Click to 'User' menu link");
		adminUserPO = adminDashboardPage.clickToUsertMenuLink();
		
		log.info("View User - Step 02: Get alls User from UI");
		int totalNumberUsersAtUI =adminUserPO.getUserNumberAtUI();
		log.info("View User - Step 03: Get alls User from DB");
		int totalNumberUserDB = adminUserPO.getUserNumberAtDB();
		log.info("View User - Step 04: Verify that the number of users displayed at UI with the database are equals");
		verifyEquals(totalNumberUsersAtUI, totalNumberUserDB);
		

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	String adminUserName = "automationfc";
	String adminPassWord = "automationfc";
	String adminUrl, endUserUrl;

	private WebDriver driver;
	AdminLoginPO adminloginPage;
	AdminDashBoardPO adminDashboardPage;
	AdminUserPO adminUserPO;
	
}
