package com.jquery.datatable;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import ReportConfig.ExtentTestManager;
import commons.BaseTest;
import pageObjects.jQuery.uploadFile.HomePageObject;
import pageObjects.jQuery.uploadFile.PageGenaratorMannager;

public class Level_11_Upload_File extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUlr) {
		driver = getBrowserDriver(browserName, appUlr);
		homePage = PageGenaratorMannager.getHomePage(driver);
	}

	@Test
	public void UpLoad_01_One_File_Per_time() {

	}

	@Test
	public void Upload_02_Multiple_File(Method method) {
		ExtentTestManager.startTest(method.getName(), "Upload mutiple");
		ExtentTestManager.getTest().log(Status.INFO, "Upload mutipile - Step 01 : Load mutipile Files");
		homePage.uploadMultipleFiles(driver, fileName);
		
		ExtentTestManager.getTest().log(Status.INFO," Upload mutipile - Step 02 : verify multiple files loaded success") ;
		Assert.assertTrue(homePage.isFileLoadByName(driver, "flower.jpg"));
		
		ExtentTestManager.getTest().log(Status.INFO," Upload mutipile - Step 03 : click to start button") ;
		homePage.clickToStartUploadFile();
		
		ExtentTestManager.getTest().log(Status.INFO," Upload mutipile - Step 03 : verify multiple files link uploaded success ") ;
		Assert.assertTrue(homePage.isFileLinkByName(driver, "flower.jpg"));
		
		ExtentTestManager.getTest().log(Status.INFO," Upload mutipile - Step 03 : verify multiple files image uploaded success ") ; 
		Assert.assertTrue(homePage.isImageUploadedByName(driver, "flower.jpg","moutain.jpg","river.jpg" ));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private String[] fileName = { "flower.jpg", "moutain.jpg", "river.jpg" };
	private WebDriver driver;
	private HomePageObject homePage;
}
