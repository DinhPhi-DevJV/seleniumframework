package com.saurcelab.sort;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import PageObject.sauceLab.LoginPageObject;
import PageObject.sauceLab.PageGeneratorManager;
import PageObject.sauceLab.ProductPageObject;
import commons.BaseTest;

public class Level_19_Sort_Asc_Desc extends BaseTest {
	@Parameters({ "browser", "appUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String sauceLadUrl) {
		String userName = "standard_user";
		String passWord = "secret_sauce";
		driver = getBrowserDriver(browserName, sauceLadUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToUserNameTexBox(userName);
		loginPage.enterToPassWordTexBox(passWord);
		productPage = loginPage.clickToLoginButton();

	}

	@Test
	public void Sort_01_Name() {
		//Ascending
		productPage.selectItemInProductSortDropdown("az");
		Assert.assertTrue(productPage.isProductNameSortByAscending());
		
		// Descending
		productPage.selectItemInProductSortDropdown("za");
		Assert.assertTrue(productPage.isProductNameSortByDescending());

	}

	@Test
	public void Sort_02_Price() {
		//Ascending
		productPage.selectItemInProductSortDropdown("lohi");
		Assert.assertTrue(productPage.isProductPriceSortByAscending());
		
		// Descending
		productPage.selectItemInProductSortDropdown("hilo");
		Assert.assertTrue(productPage.isProductPriceSortByDescending());


	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	LoginPageObject loginPage;
	ProductPageObject productPage;

}
