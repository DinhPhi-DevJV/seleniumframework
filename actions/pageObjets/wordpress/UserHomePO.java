package pageObjets.wordpress;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.wordpress.UserHomePageUI;

public class UserHomePO extends BasePage {
	private WebDriver driver;

	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostInForDisplayedWithPostBody(String postTitle,String postBody) {
		waitForElementVisible(driver, UserHomePageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle,postBody);
		return isElementDisplayed(driver, UserHomePageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle,postBody);
	}

	public boolean isPostInForDisplayedWithPostAuthorName(String postTile, String authorName) {
		waitForElementVisible(driver, UserHomePageUI.POST_AUTHOR_TEXT, postTile, authorName);
		return isElementDisplayed(driver, UserHomePageUI.POST_AUTHOR_TEXT, postTile, authorName);
	}

	public boolean isPostInForDisplayedWithCurrentDay(String postTile, String currentDay) {
		waitForElementVisible(driver, UserHomePageUI.POST_CURENT_DATE_TEXT_BY_POST_TITLE, postTile, currentDay);
		return isElementDisplayed(driver, UserHomePageUI.POST_CURENT_DATE_TEXT_BY_POST_TITLE, postTile, currentDay);
	}

	public boolean isPostInForDisplayedWithPostTitle(String postTile) {
		waitForElementVisible(driver, UserHomePageUI.POST_TITLE_TEXT, postTile);
		return isElementDisplayed(driver, UserHomePageUI.POST_TITLE_TEXT, postTile);
	}

	public UserPortDetailPO clickToPostTitle(String postTitle) {
		waitForElementClickable(driver, UserHomePageUI.POST_TITLE_TEXT,postTitle);
		clickToElement(driver, UserHomePageUI.POST_AUTHOR_TEXT,postTitle);
		return PageGenaratorManager.getUserPortDetailPO(driver);
	}

}
