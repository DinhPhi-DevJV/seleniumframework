package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjets.wordpress.AdminDashBoardPO;
import pageObjets.wordpress.AdminLoginPO;
import pageObjets.wordpress.AdminPostAddNewPO;
import pageObjets.wordpress.AdminPostSearchPO;
import pageObjets.wordpress.PageGenaratorManager;
import pageObjets.wordpress.UserHomePO;
import pageObjets.wordpress.UserPortDetailPO;

public class Post_01_Create_Read_Upload_Delete_Search extends BaseTest {
	String adminUserName = "automationfc";
	String adminPassWord = "automationfc";
	String SearchPostUrl;
	int randomNumber = genarateFakeNumber();
	String postTitle = "Live coding Title" + randomNumber;
	String postBody = "Live coding Body" + randomNumber;
	String authorName = "Automation FC";
	String editPostTitle = "Edit Title" + randomNumber;
	String editPostBody = "Edit Body" + randomNumber;
	String adminUrl, endUserUrl;
	String currentDay = getCurrentDay();

	@Parameters({ "browser", "urlAdmin", "urlUser" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
		log.info("pre-conditon - Step 01: open browser and admin Url");
		this.adminUrl = adminUrl;
		this.endUserUrl = endUserUrl;
		driver = getBrowserDriver(browserName, this.adminUrl);
		adminloginPage = PageGenaratorManager.getAdminLoginPO(driver);

		log.info("pre-conditon - Step 02: Enter to Username textbox with value : " + adminUserName);
		adminloginPage.enterToUserName(adminUserName);

		log.info("pre-conditon - Step 03: Enter to Password textbox with value: " + adminPassWord);
		adminloginPage.enterToPassword(adminPassWord);

		log.info("pre-conditon - Step 04: Enter to Login button");
		adminDashboardPage = adminloginPage.clickToLogin();

	}

	@Test
	public void Post_01_Create_NewPost() {
		log.info("Create_Post - Step 01: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

		log.info("Create_Post - Step 02: Click to 'Add new' button");
		SearchPostUrl = adminPostSearchPage.getPageUlr(driver);
		adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();

		log.info("Create_Post - Step 03: Enter to 'post Title' ");
		adminPostAddNewPage.enterToAddNewPostTitle(postTitle);

		log.info("Create_Post - Step 04: Enter to body");
		adminPostAddNewPage.enterToAddNewPostBody(postBody);

		log.info("Create_Post - Step 05: Click to 'publish' button");
		adminPostAddNewPage.clickToPublishButton();

		log.info("Create_Post - Step 06: Verify 'Post published.' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post published."));
	}

	@Test
	public void Post_02_Search_And_View_Post() {
		log.info("Search_Post - Step 01: Open 'Search post' page ");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(SearchPostUrl);

		log.info("Search_Post - Step 02: Enter to Search text box");
		adminPostSearchPage.enterToSearchTextBox(postTitle);

		log.info("Search_Post - Step 03: Click to 'search posts' button");
		adminPostSearchPage.clickToSearchPortButton();

		log.info("Search_Post - Step 04: verify Search table contains'" + postTitle + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", postTitle));

		log.info("Search_Post - Step 05: verify Search table contains'" + authorName + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));

		log.info("Search_Post - Step 06: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);

		log.info("Search_Post - Step 07: Verify Post infor displayed at Home Page");
		verifyTrue(userHomePage.isPostInForDisplayedWithPostTitle(postTitle));
		verifyTrue(userHomePage.isPostInForDisplayedWithPostBody(postTitle, postBody));
		verifyTrue(userHomePage.isPostInForDisplayedWithPostAuthorName(postTitle, authorName));
		verifyTrue(userHomePage.isPostInForDisplayedWithCurrentDay(postTitle, currentDay));

		log.info("Search_Post - Step 08: Click to Post Title");
		userPortDetailPage = userHomePage.clickToPostTitle(postTitle);

		log.info("Search_Post - Step 09:  Verify Post infor displayed at Post detail Page");
		verifyTrue(userPortDetailPage.isPostInForDisplayedWithPostTitle(postTitle));
		verifyTrue(userPortDetailPage.isPostInForDisplayedWithPostBody(postBody, SearchPostUrl));
		verifyTrue(userPortDetailPage.isPostInForDisplayedWithPostAuthorName(authorName, postTitle));
		verifyTrue(userPortDetailPage.isPostInForDisplayedWithCurrentDay(currentDay, postTitle));
	}

	@Test
	public void Post_03_Edit_Post() {
		log.info("Edit_Post - Step 01:  Open Admin site ");
		userPortDetailPage.OpenAdminSite(driver, this.adminUrl);

		log.info("Edit_Post - Step 02: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

		log.info("Edit_Post - Step 03: Enter to Search text box");
		adminPostSearchPage.enterToSearchTextBox(postTitle);

		log.info("Edit_Post - Step 04: Click to 'search posts' button");
		adminPostSearchPage.clickToSearchPortButton();

		log.info("Edit_Post - Step 05: Click to Post title detail link and navigate to Edit post page");
		adminPostAddNewPage = adminPostSearchPage.clickToPostTitleLink(postTitle);

		log.info("Edit_Post - Step 06: Enter to 'post Title' ");
		adminPostAddNewPage.enterToAddNewPostTitle(editPostTitle);

		log.info("Edit_Post - Step 07: Enter to body");
		adminPostAddNewPage.enterToEditPostBody(editPostBody);

		log.info("Edit_Post - Step 08: Click to 'Update' button");
		adminPostAddNewPage.clickToPublishButton();

		log.info("Edit_Post - Step 09: Verify 'Post updated.' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post updated."));
		
		log.info("Edit_Post - Step 10: Open 'Search post' page ");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(SearchPostUrl);

		log.info("Edit_Post - Step 11: Enter to Search text box");
		adminPostSearchPage.enterToSearchTextBox(editPostTitle);

		log.info("Edit_Post - Step 12: Click to 'search posts' button");
		adminPostSearchPage.clickToSearchPortButton();

		log.info("Edit_Post - Step 13: verify Search table contains'" + editPostTitle + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", editPostTitle));

		log.info("Edit_Post - Step 14: verify Search table contains'" + authorName + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));

		log.info("Edit_Post - Step 15: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);

		log.info("Edit_Post - Step 16: Verify Post infor displayed at Home Page");
		verifyTrue(userHomePage.isPostInForDisplayedWithPostTitle(editPostTitle));
		verifyTrue(userHomePage.isPostInForDisplayedWithPostBody(editPostTitle, editPostBody));
		verifyTrue(userHomePage.isPostInForDisplayedWithPostAuthorName(editPostTitle, authorName));
		verifyTrue(userHomePage.isPostInForDisplayedWithCurrentDay(editPostTitle, currentDay));

		log.info("Edit_Post - Step 17: Click to Post Title");
		userPortDetailPage = userHomePage.clickToPostTitle(postTitle);

		log.info("Edit_Post - Step 18:  Verify Post infor displayed at Post detail Page");
		verifyTrue(userPortDetailPage.isPostInForDisplayedWithPostTitle(postTitle));
		verifyTrue(userPortDetailPage.isPostInForDisplayedWithPostBody(postBody, SearchPostUrl));
		verifyTrue(userPortDetailPage.isPostInForDisplayedWithPostAuthorName(authorName, postTitle));
		verifyTrue(userPortDetailPage.isPostInForDisplayedWithCurrentDay(currentDay, postTitle));
	}

	@Test
	public void Post_03_Delete_Post() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	AdminLoginPO adminloginPage;
	AdminDashBoardPO adminDashboardPage;
	AdminPostSearchPO adminPostSearchPage;
	AdminPostAddNewPO adminPostAddNewPage;
	UserHomePO userHomePage;
	UserPortDetailPO userPortDetailPage;

}
