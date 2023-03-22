package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import pageOject.facebook.LoginPageObject;
import pageOject.facebook.PageGenaratorMannager;

public class Level_13_Element_Undisplayed extends BaseTest {
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUlr) {
		driver = getBrowserDriver(browserName, appUlr);
		loginPage = PageGenaratorMannager.getLoginPage(driver);
	}

	@Test
	public void TC_01_VerifyElement_Displayed() {
		loginPage.clickToCreateNewAccount();

		// nếu một cái hàm chỉ mong đợi để verifry element displayed - kết hợp cả wait +
		// isdisplayed .
		verifyTrue(loginPage.isEmailAddressTextboxDisplayed());
	}

	@Test
	public void TC_02_VerifyElement_unDisplayed_In_Dom() {
		// Nếu như mình mong đợi một cái hàm vừa verify displayed/ undisplayed thì không
		// được kết hợp wait.
		// waitforElementVisible.
		// isElementDisplayed.

		// verify true - mong đợi confirm email text box displayed.
		loginPage.enterToEmailAddressTextBox(emailAddress);
		loginPage.sleepInsecond(2);
		verifyTrue(loginPage.isConfirmEmailTextBoxDisplayed());
	
		// verify flase - monng đợi confirm email undisplayed (false)
		loginPage.enterToEmailAddressTextBox("");
		loginPage.sleepInsecond(2);
		//verifyFalse(loginPage.isConfirmEmailTextBoxDisplayed());
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
		
	}

	@Test
	public void TC_03_VerifyElement_unDisplayed_Not_In_DOM() {
		loginPage.closePopupLogin();
		loginPage.sleepInsecond(3);
		// khi close cáo form register đi thì cái confirm emial không ocnf trong dom nữa.
		//nên hàm find element bị false
		// vì không timg thấy element
		//- 1 nó sẽ chờ hết 30 s
		//- 2 nó đánh false test case tại đúng step.
		//- 3 nó sẽ không chạy các step còn lại.
		// verify  False - mong đọi confirmEmail undisplayed (false).
		// is displayed : bản chất không kiểm tra 1 element không có trong DOM được.
		// verifyFalse(loginPage.isConfirmEmailTextBoxDisplayed());
		// niếu dùng try cath cho hàm isdisplayed thì để kiểm tra element hiển thị rất mất thời gian.
		// chạy được, chạy đúng nhưng không tối ưu. vd: 50 element.???
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
		
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

	private WebDriver driver;
	private LoginPageObject loginPage;
	private String emailAddress = "automationfc@gmail.com";

}
