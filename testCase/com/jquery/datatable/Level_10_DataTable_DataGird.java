package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import pageObjects.jQuery.dataTable.HomePageObject;
import pageObjects.jQuery.dataTable.PageGenaratorMannager;

public class Level_10_DataTable_DataGird extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUlr) {
		driver = getBrowserDriver(browserName, appUlr);
		homePage = PageGenaratorMannager.getHomePage(driver);

	}

	//@Test
	public void Table_01_Paging() {

		for (Integer i = 1; i <= 24; i++) {
			String number = i.toString();
			homePage.openPagingByPageNumber(number);
			homePage.sleepInsecond(1);
			Assert.assertTrue(homePage.isPageNumberActive(number));
		}
	}

	//@Test
	public void Table_02_Ennter_To_Header() {
		homePage.enterToHeaderTextboxByLable("764956", "Females");
		homePage.enterToHeaderTextboxByLable("Arab Rep of Egypt", "Country"); 
		homePage.enterToHeaderTextboxByLable("802948", "Males"); 
		homePage.enterToHeaderTextboxByLable("1567904", "Total");
		homePage.sleepInsecond(3);

	}

	//@Test
	public void Table_03_Enter_To_Header() {
		// đọc dữ liệu của file country.txt ra 
		// lưu vào 1 List <String> = expected value  = expectedAllCountryValues
		// actual value
		
		homePage.getValueEachRowAtAllPage();

	}
	@Test
	public void Table_04_Action_At_AnnyRow() {
		homePage.clickToLoadButton();
		homePage.sleepInsecond(5);
		// value để nhập liệu - tham số1
		// row number : tại row nào
		// Ex: nhập vào textbox tại dòng 2/3/5 ...
		// colum name : Album, Artist, Year
		homePage.enterToTextBoxAtRowNumberByColumName("Album","1","Michael 97");
		homePage.selectDropDownByColumnNameAtRowNumber("Origin","1","Japan");
		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?","3");
		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?","5");
		homePage.unckeckToCheckboxByColumNameAtRowNumber("With Poster?","1");
		homePage.unckeckToCheckboxByColumNameAtRowNumber("With Poster?","2");
		homePage.unckeckToCheckboxByColumNameAtRowNumber("With Poster?","4");
		homePage.clickToIconByRowNumber("1","Remove Current Row");
		homePage.clickToIconByRowNumber("1","Insert Row Above");
		homePage.clickToIconByRowNumber("3","Move Up");
		homePage.clickToIconByRowNumber("5","Remove Current Row");
		homePage.clickToIconByRowNumber("4","Remove Current Row");
		homePage.clickToIconByRowNumber("3","Remove Current Row");
		homePage.clickToIconByRowNumber("2","Remove Current Row");
		homePage.clickToIconByRowNumber("1","Remove Current Row");
		
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	HomePageObject homePage;
}
