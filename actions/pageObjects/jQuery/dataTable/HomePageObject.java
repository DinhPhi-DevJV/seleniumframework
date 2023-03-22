package pageObjects.jQuery.dataTable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import commons.BasePage;
import pageUIs.jQuery.dataTable.HomePageUIs;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUIs.PAGINGNATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUIs.PAGINGNATION_PAGE_BY_NUMBER, pageNumber);
	}

	public void enterToHeaderTextboxByLable(String keys, String lable) {
		waitForElementVisible(driver, HomePageUIs.ENTER_TO_HEADER_TEXTBOX_BY_LABLE, lable);
		sendkeysToElement(driver, HomePageUIs.ENTER_TO_HEADER_TEXTBOX_BY_LABLE, keys, lable);
		presskeyToElement(driver, HomePageUIs.ENTER_TO_HEADER_TEXTBOX_BY_LABLE, Keys.ENTER, lable);

	}

	public boolean isPageNumberActive(String pageNumber) {
		waitForElementVisible(driver, HomePageUIs.PAGINGNATION_PAGE_AVTIVED_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUIs.PAGINGNATION_PAGE_AVTIVED_BY_NUMBER, pageNumber);
	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage =getElementSize(driver, HomePageUIs.TOTAL_PAGINGNATION);
		System.out.println("tatal size" + totalPage);
		List<String> allRowValuesAllPage = new ArrayList<String>();
		// nếu muốn lấy không trùng thì thay list bằng set
		//duyệt qua tất cả các page  number (pagin)
		for(int index = 1; index<=totalPage;index++) {
			clickToElement(driver,HomePageUIs.PAGINATION_PAGE_INDEX, String.valueOf(index));
			sleepInsecond(1); 
			List<WebElement> allRowElementEachPage = getListWebElements(driver, HomePageUIs.ALL_ROW_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValuesAllPage.add(eachRow.getText());
			}
			
		}
		// in tất cả giá trị row của tất cả cá page
		for (String value : allRowValuesAllPage) {
			System.out.println("-----------------");
			System.out.println(value);
		}
		return allRowValuesAllPage;
		
	}

	public void enterToTextBoxAtRowNumberByColumName(String columnName, String rowNumber, String valueToEnter) {
		// lấy ra column index dựa vào tên cột
		int columIndex = getElementSize(driver,  HomePageUIs.COLUMN_INDEX_BY_NAME, columnName)+1;
		// sendkey vào dòng nào.
		waitForAllElementsVisible(driver, HomePageUIs.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columIndex));
		sendkeysToElement(driver, HomePageUIs.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToEnter, rowNumber,String.valueOf(columIndex));
	}

	public void selectDropDownByColumnNameAtRowNumber(String columnName, String rowNumber, String valueToSelect) {
		int columnIndex = getElementSize(driver, HomePageUIs.COLUMN_INDEX_BY_NAME, columnName)+1;
		waitForElementClickable(driver, HomePageUIs.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex));
		selectItemInDefaultDropDown(driver, HomePageUIs.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToSelect, rowNumber,String.valueOf(columnIndex));
	}

	public void clickToLoadButton() {
		waitForElementClickable(driver,HomePageUIs.LOAD_BUTTON);
		clickToElement(driver, HomePageUIs.LOAD_BUTTON);
	}

	public void checkToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUIs.COLUMN_INDEX_BY_NAME, columnName)+1;
		waitForElementClickable(driver, HomePageUIs.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex));
		checkToDefaultCheckBoxOrRadio(driver, HomePageUIs.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex));
	}

	public void unckeckToCheckboxByColumNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUIs.COLUMN_INDEX_BY_NAME, columnName)+1;
		waitForElementClickable(driver, HomePageUIs.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex));
		unchekToDefaultCheckbox(driver, HomePageUIs.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex));
	}

	public void clickToIconByRowNumber(String rowNumber, String action) {
		waitForElementClickable(driver, HomePageUIs.ICON_BY_ROW_INDEX_AND_TYPE_ACTION, action);
		clickToElement(driver, HomePageUIs.ICON_BY_ROW_INDEX_AND_TYPE_ACTION, action);
		
		
	}
}
