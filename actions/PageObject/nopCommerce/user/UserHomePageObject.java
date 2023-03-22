package PageObject.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGenerator_Manager;
import io.qameta.allure.Step;
import pageUIs.nopComerce.user.HomePageUI;

public class UserHomePageObject extends BasePage {
	private WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	@Step("Navigate to Register Page")
	public  UserRegisterPageObject openRegisterPage() {
		clickToElement(driver, HomePageUI.REGISTER_ULR);
		// return new RegisterPageObject(driver);
		return PageGenerator_Manager.getUserRegistrObject(driver);
	}
	@Step("Navigate to Login Page")
	public UserLoginPageObject openLoginPage() {
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		//return  new LoginPageObject(driver);
		return PageGenerator_Manager.getUserLoginPageOject(driver);
	}
	@Step("Navigate to Myaccount Page")
	public UserCustomerinfoPageObject openMyAccountPage() {
		clickToElement(driver,HomePageUI.CLICK_MY_ACCOUNT_LINK );
		return PageGenerator_Manager.getUserCustomerinfoPageObject(driver);
	}
	

}
