package pageObjets.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostSearchPageUI;

public class AdminPostSearchPO extends BasePage{
	private WebDriver driver;

	public AdminPostSearchPO(WebDriver driver) {
		this.driver = driver;

	}

	public AdminPostAddNewPO clickToAddNewButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		return PageGenaratorManager.getAdminPostAddNewPO(driver);
		
	}

	public void enterToSearchTextBox(String postTitle) {
		waitForElementVisible(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX);
		sendkeysToElement(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX, postTitle);
		
	}

	public boolean isPostSearchTableDisplayed(String headerNameID, String cellValue) {
		int headerIndex= getElementSize(driver,AdminPostSearchPageUI.TABLE_HEADER_INDEX_BY_HEADER_NAME,headerNameID)+1;
		waitForElementVisible(driver,AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX,String.valueOf(headerIndex), cellValue);
		return isElementDisplayed(driver,AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX,String.valueOf(headerIndex),cellValue);
	}

	public void clickToSearchPortButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.SEARCH_BUTTON);		
	}

	public AdminPostAddNewPO clickToPostTitleLink(String postTitle) {
		
		waitForElementClickable(driver, AdminPostSearchPageUI.ROW_TITLE_DETAIL_BBY_TITLE_NAME,postTitle);
		clickToElement(driver, AdminPostSearchPageUI.ROW_TITLE_DETAIL_BBY_TITLE_NAME,postTitle);		
		return PageGenaratorManager.getAdminPostAddNewPO(driver);
	}




	
}
