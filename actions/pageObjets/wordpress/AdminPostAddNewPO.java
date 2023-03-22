package pageObjets.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostAddNewPageUI;

public class AdminPostAddNewPO extends BasePage {
	private WebDriver driver;

	public AdminPostAddNewPO(WebDriver driver) {
		this.driver = driver;

	}

	public void enterToAddNewPostTitle(String postTitleValue) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX);
		sendkeysToElement(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX, postTitleValue);
	}

	public void enterToAddNewPostBody(String postBodyValue) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.BODY_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.BODY_BUTTON);
		waitForElementVisible(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);
		sendkeysToElement(driver, AdminPostAddNewPageUI.BODY_TEXTBOX, postBodyValue);
	}
	public void enterToEditPostBody(String postBodyValue) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);
		clickToElement(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);
		waitForElementVisible(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);
		sendkeysToElement(driver, AdminPostAddNewPageUI.BODY_TEXTBOX, postBodyValue);
	}
	public void clickToPublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON_MENU);
		waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON_MENU);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON_MENU);
	}

	public boolean isPostPublishMessageDisplayed(String postPublishedMeassage) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.PUBLISHED_OR_UPDATE_MESSAGE, postPublishedMeassage);
		return isElementDisplayed(driver, AdminPostAddNewPageUI.PUBLISHED_OR_UPDATE_MESSAGE, postPublishedMeassage);
	}

	public AdminPostSearchPO openSearchPostPageUrl(String searchPostUrl) {
		openPageUlr(driver, searchPostUrl);
		return PageGenaratorManager.getAdminPostSearchPO(driver);
	}
}
