package com.nopcommerce.user;

//import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
/*import com.relevantcodes.extentreports.LogStatus;*/
import PageObject.nopCommerce.user.UserCustomerinfoPageObject;
import PageObject.nopCommerce.user.UserHomePageObject;
import PageObject.nopCommerce.user.UserLoginPageObject;
import PageObject.nopCommerce.user.UserRegisterPageObject;
/*import ReportConfig.ExtentManager;*/
import commons.BaseTest;
import commons.PageGenerator_Manager;

public class Level_15_ExtentV2_ScreenShot extends BaseTest {
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

	/*
	 * @Test public void User_01_Register(Method method) {
	 * ExtentManager.startTest(method.getName(), "User_01_Register");
	 * ExtentManager.getTest().log(LogStatus.
	 * INFO,"Register - Step 1: Navigate to 'Rigisster' page"); cách viết log : 1-
	 * tên chức năng của test case. 2- thứ tự của step. 3- decription của step là gì
	 * 
	 * registerPageObject = homePageObject.openRegisterPage();
	 * 
	 * ExtentManager.getTest().log(LogStatus.
	 * INFO,"Register - Step 2: Enter to First name textbox with value is '"+
	 * firstName+"'"); registerPageObject.inputToFirstNameTexBox(firstName);
	 * 
	 * // nó sẽ log ra kèm theo ngày tháng năm. kèn theo đoạn log.info
	 * 
	 * ExtentManager.getTest().log(LogStatus.
	 * INFO,"Register - Step 3: Enter to Last name textbox with value is '"+
	 * firstName+"'"); registerPageObject.inputToLastNameTexBox(lastName);
	 * 
	 * ExtentManager.getTest().log(LogStatus.
	 * INFO,"Register - Step 4: Enter to Email textbox with value is '"+
	 * emailAdress+"'"); registerPageObject.inputToEmailTexBox(emailAdress);
	 * 
	 * ExtentManager.getTest().log(LogStatus.
	 * INFO,"Register - Step 5: Enter to Password textbox with value is '"+
	 * password+"'"); registerPageObject.inputToPaswordTexBox(password);
	 * 
	 * ExtentManager.getTest().log(LogStatus.
	 * INFO,"Register - Step 6: Enter to Confirm password textbox with value is '"+
	 * password+"'"+" "); registerPageObject.inputToConfirmPasswordTexBox(password);
	 * 
	 * ExtentManager.getTest().log(LogStatus.
	 * INFO,"Register - Step 7: Click to register button");
	 * registerPageObject.clickToRegisterButton();
	 * 
	 * ExtentManager.getTest().log(LogStatus.
	 * INFO,"Register - Step 8: Verify that the 'Your registration completed.' message is displayed '"
	 * ); verifyEquals(registerPageObject.getSuccessRegisterTextBox(),
	 * "Your registration completed");
	 * 
	 * ExtentManager.getTest().log(LogStatus.
	 * INFO,"Register - Step 9: Click to logout link"); homePageObject =
	 * registerPageObject.clickToLogoutLink(); ExtentManager.endTest(); }
	 * 
	 * @Test public void User_02_Login() { ExtentManager.getTest().log(LogStatus.
	 * INFO,"Login - Step 1: Navigate to login page"); loginPageObject =
	 * homePageObject.openLoginPage();
	 * 
	 * ExtentManager.getTest().log(LogStatus.
	 * INFO,"Login - Step 2: Enter to Email textbox with value is '"+
	 * emailAdress+"'"); loginPageObject.inputToEmailTextBox(emailAdress);
	 * 
	 * ExtentManager.getTest().log(LogStatus.
	 * INFO,"Login - Step 3: Enter to Password textbox with value is '"+
	 * password+"'"); loginPageObject.inputToPassWordTextBox(password);
	 * 
	 * ExtentManager.getTest().log(LogStatus.
	 * INFO,"Login - Step 4: click to Login button"); homePageObject =
	 * loginPageObject.clickToLoginButton();
	 * 
	 * ExtentManager.getTest().log(LogStatus.
	 * INFO,"Login - Step 5: click verify that 'My account link' is displayed");
	 * verifyTrue(loginPageObject.isMyAccountLinkIsDisplayed());
	 * 
	 * ExtentManager.getTest().log(LogStatus.
	 * INFO,"Login - Step 6: navigate to my account page"); customerinfoPageObject =
	 * homePageObject.openMyAccountPage();
	 * 
	 * ExtentManager.getTest().log(LogStatus.
	 * INFO,"Login - Step 7: verify that customer info is displayed");
	 * verifyTrue(customerinfoPageObject.isCustomerInfoDisplayed());
	 * ExtentManager.endTest(); }
	 */

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	 WebDriver driver;
	 UserHomePageObject homePageObject;
	 UserRegisterPageObject registerPageObject;
	 String firstName, lastName, password, emailAdress;
	 UserCustomerinfoPageObject customerinfoPageObject;
	 UserLoginPageObject loginPageObject;
}
