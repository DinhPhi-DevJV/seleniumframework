package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.notcommerce.data.UserDataMapper;

import PageObject.nopCommerce.user.UserCustomerinfoPageObject;
import PageObject.nopCommerce.user.UserHomePageObject;
import PageObject.nopCommerce.user.UserLoginPageObject;
import PageObject.nopCommerce.user.UserRegisterPageObject;
import commons.BaseTest;
import commons.PageGenerator_Manager;

public class Level_21_Fake_Data2 extends BaseTest {
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePageObject = PageGenerator_Manager.getUserHomePageOject(driver);
		userDataMapper= UserDataMapper.getUserData();
		
		firstName = userDataMapper.getFirstName();
		lastName = userDataMapper.getLastName();
		emailAdress = userDataMapper.getEmailAddress()+genarateFakeNumber()+"@gmail.com";
		password = userDataMapper.getPassWord();
		date = userDataMapper.getDate();
		month = userDataMapper.getMoth();
		year = userDataMapper.getYear();
	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 1: Navigate to 'Rigisster' page");
		/* cách viết log : 
		 * 1- tên chức năng của test case. 
		 * 2- thứ tự của step.
		 * 3- decription của step là gì 
		 * */
		registerPageObject = homePageObject.openRegisterPage();
		
		registerPageObject.clickToRadioButtonLabeName(driver,"Female");
		
		log.info("Register - Step 2: Enter to First name textbox with value is '"+ firstName+"'");
		// registerPageObject.inputToFirstNameTexBox(firstName);
		// nó sẽ log ra kèm theo ngày tháng năm. kèn theo đoạn log.info 
		registerPageObject.inputToTextboxByID(driver,"FirstName", firstName);
		
		log.info("Register - Step 3: Enter to Last name textbox with value is '"+ firstName+"'");
		// registerPageObject.inputToLastNameTexBox(lastName);
		registerPageObject.inputToTextboxByID(driver,"LastName", lastName);
		log.info("Rgister - step 3.1: choice in the day of birth day in the dropdown");
		registerPageObject.selectToDropdownByName(driver,"DateOfBirthDay",date);
		
		log.info("Rgister - step 3.2: choice in the month of birth month in the dropdown");
		registerPageObject.selectToDropdownByName(driver,"DateOfBirthMonth",month);

		log.info("Rgister - step 3.3: choice in the day of birth year in the dropdown");
		registerPageObject.selectToDropdownByName(driver,"DateOfBirthYear",year);
		
		//---------------------------------------------------------------------------------------------------------------------------
		
		registerPageObject.selectToDropdownByName(driver,"DateOfBirthYear",userDataMapper.getSubject().get(0).getName());
		
		//-------------------------------------------------------------------------------------------------------------------
		
		log.info("Register - Step 4: Enter to Email textbox with value is '"+ emailAdress+"'");
		// registerPageObject.inputToEmailTexBox(emailAdress);
		registerPageObject.inputToTextboxByID(driver,"Email", emailAdress);
		
		registerPageObject.clickToChekboxByLableName(driver, "Newsletter");
		
		log.info("Register - Step 5: Enter to Password textbox with value is '"+ password+"'");
		// registerPageObject.inputToPaswordTexBox(password);
		registerPageObject.inputToTextboxByID(driver,"Password", password);
		
		log.info("Register - Step 6: Enter to Confirm Password textbox with value is '"+ password+"'"+" ");
		// registerPageObject.inputToConfirmPasswordTexBox(password);
		registerPageObject.inputToTextboxByID(driver,"ConfirmPassword", password);
		
		log.info("Register - Step 7: Click to register button");
		registerPageObject.clickToRegisterButton();
		
		log.info("Register - Step 8: Verify that the 'Your registration completed.' message is displayed '");
		verifyEquals(registerPageObject.getSuccessRegisterTextBox(), "Your registration completed");
	}
	@Test
	public void User_02_Login() {
		log.info("Login - Step 1: Navigate to login page");
		loginPageObject = homePageObject.openLoginPage();
		
		log.info("Login - Step 2: Enter to Email textbox with value is '"+ emailAdress+"'");
		loginPageObject.inputToTextboxByID(driver,"Email", emailAdress);
		
		log.info("Login - Step 3: Enter to Password textbox with value is '"+ password+"'");
		registerPageObject.inputToTextboxByID(driver,"Password", password);
		
		log.info("Login - Step 4: click to Login button");
		loginPageObject.clickToButtonByText(driver,"Log in" );
		homePageObject = PageGenerator_Manager.getUserHomePageOject(driver);
		log.info("Login - Step 5: click verify that 'My account link' is displayed");
		verifyTrue(loginPageObject.isMyAccountLinkIsDisplayed());
		
		log.info("Login - Step 6: navigate to my account page");
		customerinfoPageObject = homePageObject.openMyAccountPage();
		
		log.info("Login - Step 7: verify that customer info is displayed");
		verifyTrue(customerinfoPageObject.isCustomerInfoDisplayed());
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
	private WebDriver driver;
	private UserHomePageObject homePageObject;
	private UserRegisterPageObject registerPageObject;
	private String firstName, lastName, password, emailAdress;
	private UserCustomerinfoPageObject customerinfoPageObject;
	private UserLoginPageObject loginPageObject;
	private String date,month,year;
	UserDataMapper userDataMapper ;
}
