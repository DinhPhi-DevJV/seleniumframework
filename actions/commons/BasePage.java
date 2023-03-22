package commons;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import PageObject.nopCommerce.admin.AdminLoginPageObject;
import PageObject.nopCommerce.user.UserAddressPageObject;
import PageObject.nopCommerce.user.UserHomePageObject;
import PageObject.nopCommerce.user.UserMyProductReviewPageObject;
import PageObject.nopCommerce.user.UserRewardPointPageObject;
import pageObjets.wordpress.AdminDashBoardPO;
import pageObjets.wordpress.PageGenaratorManager;
import pageObjets.wordpress.UserHomePO;
import pageUIs.jQuery.uploadFile.BasePageJQueryUI;
import pageUIs.nopComerce.user.BasePageNopcommerceUI;

public class BasePage {

	public static BasePage getBasePageObject() {
		return new BasePage();
	}

	public void openPageUlr(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUlr(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshToPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public Set<Cookie>  getAllCookie(WebDriver driver) {
		return driver.manage().getCookies();
	}
	public void setCookies (WebDriver driver, Set<Cookie>cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
		sleepInsecond(3); 
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, timeOut);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		Alert alert = waitForAlertPresence(driver);
		alert.accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void sendkeyToAlert(WebDriver driver, String texValue) {
		waitForAlertPresence(driver).sendKeys(texValue);
	}

	public void switchToWindowByID(WebDriver drvier, String parentID) {
		Set<String> allWindowIDs = drvier.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(parentID)) {
				drvier.switchTo().window(id);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver drvier, String expectedPageTitle) {
		Set<String> allWindowIDs = drvier.getWindowHandles();
		for (String id : allWindowIDs) {
			drvier.switchTo().window(id);
			String currentPageTitle = drvier.getTitle();
			if (currentPageTitle.equals(expectedPageTitle)) {
				break;
			}
		}

	}

	public void closeAllWindowWithoughtParent(WebDriver drvier, String parentId) {
		Set<String> allWindowIDs = drvier.getWindowHandles();
		for (String windowIDs : allWindowIDs) {
			if (!windowIDs.equals(parentId)) {
				drvier.switchTo().window(windowIDs);
				drvier.close();
			}
		}
		drvier.switchTo().window(parentId);
	}

	// private By getByXpath(String xpathLocator) {
	// return By.xpath(xpathLocator);
	// }
	// locator type: id=// css=// xpath=// name = class=
	// locator type: ID=// CSS=// XPATH=// NAME = CLASS=
	// locator type: Id=// Css=// Xpath=// Name = Class=
	private By getByLocator(String locatorType) {
		By by = null;
		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=")
				|| locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=")
				|| locatorType.startsWith("Name=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=")
				|| locatorType.startsWith("Xpath=")) {
			by = By.xpath(locatorType.substring(6));
		} else {
			throw new RuntimeException("Locator type not supported!");
		}
		return by;
	}

	private String getDynamicXpath(String locatorType, String... values) {
		if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
			locatorType = String.format(locatorType, (Object[]) values);

		}
		return locatorType;
	}

	private WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	public List<WebElement> getListWebElements(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}

	public void clickToElement(WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();
	}

	public void clickToElement(WebDriver driver, String locatorType, String values) {
		getWebElement(driver, getDynamicXpath(locatorType, values)).click();
	}

	public void sendkeysToElement(WebDriver driver, String locatorType, String keys) {
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(keys);
	}

	public void sendkeysToElement(WebDriver driver, String locatorType, String keys, String... values) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, values));
		element.clear();
		element.sendKeys(keys);
	}

	public void selectItemInDefaultDropDown(WebDriver driver, String locatorType, String textItem) {
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByValue(textItem);
	}

	public void selectItemInDefaultDropDown(WebDriver driver, String locatorType, String textItem, String... values) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, values)));
		select.selectByVisibleText(textItem);
	}

	public String getFirstSelectedItemDefaultDropDown(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropDowmMutiple(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.isMultiple();
	}

	public void selectItemInCustomDropDown(WebDriver driver, String parentLocator, String childLocator,
			String excpectedTextItem) {
		getWebElement(driver, parentLocator).click();
		sleepInsecond(1);
		WebDriverWait explicitwait = new WebDriverWait(driver, timeOut);
		List<WebElement> allDropdownItem = explicitwait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childLocator)));
		for (WebElement item : allDropdownItem) {
			if (item.getText().trim().equals(excpectedTextItem)) {
				JavascriptExecutor jsExcutor = (JavascriptExecutor) driver;
				jsExcutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInsecond(1);
				item.click();
				break;
			}

		}

	}

	public void sleepInsecond(long timeInsecond) {
		try {
			Thread.sleep(timeInsecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public String getAttributeName(WebDriver driver, String locatorType, String attributeName) {
		return getWebElement(driver, locatorType).getAttribute(attributeName);
	}

	public String getTextElement(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getText();
	}

	public String getTextElement(WebDriver driver, String locatorType, String... values) {
		return getWebElement(driver, getDynamicXpath(locatorType, values)).getText();
	}

	public String getElementCssValue(WebDriver driver, String locatorType, String propertyName) {
		return getWebElement(driver, locatorType).getCssValue(propertyName);
	}

	public String getHexaColorFromRgba(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	public int getElementSize(WebDriver driver, String locatorType) {
		return getListWebElements(driver, locatorType).size();
	}

	public int getElementSize(WebDriver driver, String locatorType, String... values) {
		return getListWebElements(driver, getDynamicXpath(locatorType, values)).size();
	}

	public void checkToDefaultCheckBoxOrRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void checkToDefaultCheckBoxOrRadio(WebDriver driver, String locatorType, String... value) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, value));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void unchekToDefaultCheckbox(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}

	public void unchekToDefaultCheckbox(WebDriver driver, String locatorType, String... value) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, value));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locatorType) {
		try {
			// tìm thấy element:
			// case 1: displayed trả vẻ true;
			// case 2: undisplayed trả về false;
			return getWebElement(driver, locatorType).isDisplayed();
		} catch (NoSuchElementException e) {
			// case 3 : undisplayed return false;
			// new Exception("element undisplayed");
			return false;
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locatorType, String... values) {
		return getWebElement(driver, getDynamicXpath(locatorType, values)).isDisplayed();
	}

	public boolean isElementUndisplayed(WebDriver driver, String locatorType) {
		System.out.println("Start time " + new Date().toString());
		overrideImplicitTimeout(driver, shortTimeOut);
		List<WebElement> elements = getListWebElements(driver, locatorType);
		overrideImplicitTimeout(driver, timeOut);
		if (elements.size() == 0) {
			System.out.println("Element not in DOM ");
			System.out.println("End time:" + new Date().toString());
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visible / displayed");
			System.out.println("End time:" + new Date().toString());
			return true;

		} else {
			System.out.println("Element in DOM and visible");
			return false;
		}
	}

	public void overrideImplicitTimeout(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	public boolean isElementEnabled(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}

	public void switchToFrameIframe(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}

	public void presskeyToElement(WebDriver driver, String locatorType, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locatorType), key).perform();
	}

	public void presskeyToElement(WebDriver driver, String locatorType, Keys key, String... values) {
		Actions action = new Actions(driver);
		// nhấn ennter vào element dùng hàm sendkey của thư viện acction
		action.sendKeys(getWebElement(driver, getDynamicXpath(locatorType, values)), key).perform();
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInsecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

	public void scrollToElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}

	public void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, locatorType));
	}
	
	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, timeOut);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, locatorType));
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, locatorType));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType, String... values) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, getDynamicXpath(locatorType, values)));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, timeOut);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}

	public void waitForElementVisible(WebDriver driver, String locatorType, String... values) {
		WebDriverWait explicitWait = new WebDriverWait(driver, timeOut);
		explicitWait.until(
				ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, values))));
	}

	public void waitForAllElementsVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitwait = new WebDriverWait(driver, timeOut);
		explicitwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}

	public void waitForAllElementsVisible(WebDriver driver, String locatorType, String... values) {
		WebDriverWait explicitwait = new WebDriverWait(driver, timeOut);
		explicitwait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, values))));
	}

	public void waitForElementInVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, timeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}

	/*
	 * wait for element undisplayed in DOM or not In DOM and Override implicit time
	 * out
	 */
	public void waitForElementUndisplayed(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeOut);
		overrideImplicitTimeout(driver, shortTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
		overrideImplicitTimeout(driver, shortTimeOut);
	}

	public void waitForElementInVisible(WebDriver driver, String locatorType, String... values) {
		WebDriverWait explicitWait = new WebDriverWait(driver, timeOut);
		explicitWait.until(
				ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, values))));
	}

	public void waitForAllElementsInVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitwait = new WebDriverWait(driver, timeOut);
		explicitwait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElements(driver, xpathLocator)));
	}

	public void waitForElementClickable(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, timeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}

	public void waitForElementClickable(WebDriver driver, String locatorType, String... value) {
		WebDriverWait explicitWait = new WebDriverWait(driver, timeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, value))));
	}

	public void uploadMultipleFiles(WebDriver driver, String... fileName) {
		// Đường dẫn thư mục upload file : window/ mac/linux
		String filePath = GlobalConstants.UPLOAD_FILE;
		// Đường dẫn của tất cả các file
		String fullFileName = "";
		for (String file : fileName) {
			// fullFileName
			fullFileName = fullFileName + filePath + file + "\n";
		}
		/*
		 * khi trên firefox đường dẫn ở cuối có /n thì hay lỗi nên trim đường dẫn 2 đầu.
		 * ( khoảng trắng /tab/xuống dòng ở đầu hoặc cuối)
		 */
		fullFileName = fullFileName.trim();
		getWebElement(driver, BasePageJQueryUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
	}

	// tối ưu ở bài học level 7_switch_page - viết hàm tại base page
	public UserAddressPageObject openAddressPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageNopcommerceUI.ADDRESS_LINK);
		clickToElement(driver, BasePageNopcommerceUI.ADDRESS_LINK);
		return PageGenerator_Manager.getUserAddressPageObject(driver);
	}

	public UserMyProductReviewPageObject openMyProductReviewPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageNopcommerceUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, BasePageNopcommerceUI.MY_PRODUCT_REVIEW_LINK);
		return PageGenerator_Manager.getUsertmyMyProductReviewPageObject(driver);
	}

	public UserRewardPointPageObject openRewardPointPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageNopcommerceUI.REWARD_POINT_LINK);
		clickToElement(driver, BasePageNopcommerceUI.REWARD_POINT_LINK);
		return PageGenerator_Manager.getUsermyreRewardPointPageObject(driver);
	}

	// tối ưu ở level 9 - viết một hàm sử dụng cho chuyển page
	public BasePage openPagesAtMyAccountByName(WebDriver driver, String pageName) {
		waitForElementVisible(driver, BasePageNopcommerceUI.DYNAMIC_PAGE_MYACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageNopcommerceUI.DYNAMIC_PAGE_MYACCOUNT_AREA, pageName);
		switch (pageName) {
		case "Addresses":
			return PageGenerator_Manager.getUserAddressPageObject(driver);
		case "My product reviews":
			return PageGenerator_Manager.getUsertmyMyProductReviewPageObject(driver);
		case "Reward points":
			return PageGenerator_Manager.getUsertmyMyProductReviewPageObject(driver);
		default:
			throw new RuntimeException("invalid page name at my account area");
		}
	}

	// Tối ưu ở bài học level_08_Switch_Role
	public UserHomePageObject clickToLogoutLinkAtUserPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageNopcommerceUI.LOGOUT_LINK_AT_USER);
		clickToElement(driver, BasePageNopcommerceUI.LOGOUT_LINK_AT_USER);
		return PageGenerator_Manager.getUserHomePageOject(driver);
	}

	public AdminLoginPageObject clickToLogoutLinkAtAdminPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageNopcommerceUI.LOGOUT_LINK_AT_ADMIN);
		clickToElement(driver, BasePageNopcommerceUI.LOGOUT_LINK_AT_ADMIN);
		return PageGenerator_Manager.getAdminLoginPageObject(driver);

	}

	// partten object
/**
 	* Enter to dynamic text box by id 
 * @author Mr Phi
 * @param driver
 * @param texBoxId
 * @param keyValue
 */
	public void inputToTextboxByID(WebDriver driver,String texBoxId, String keyValue) {
		waitForElementVisible(driver,BasePageNopcommerceUI.DYNAMIC_TEXTBOX_BY_ID, texBoxId);
		sendkeysToElement(driver, BasePageNopcommerceUI.DYNAMIC_TEXTBOX_BY_ID, keyValue, texBoxId);
	}
	/**
	 * click to dynamic button by text
	 * @author Mr Phi
	 * @param driver
	 * @param text
	 * @return
	 */
	public void clickToButtonByText(WebDriver driver,String buttonText) {
		waitForElementVisible(driver, BasePageNopcommerceUI.BUTTON_CONTAINS_TEXT, buttonText);
		clickToElement(driver, BasePageNopcommerceUI.BUTTON_CONTAINS_TEXT, buttonText);
	}

	/**
	 * Select item in dropdown by name attribute
	 * 
	 * @param driver
	 * @param dropdowName
	 * @param itemValue
	 */
	public void selectToDropdownByName(WebDriver driver, String dropdowAttributeName,String itemValue) {
		waitForElementClickable(driver,BasePageNopcommerceUI.DYNAMIC_DROWPDOWN_BY_NAME, dropdowAttributeName);
		selectItemInDefaultDropDown(driver, BasePageNopcommerceUI.DYNAMIC_DROWPDOWN_BY_NAME,itemValue,dropdowAttributeName);
	}
	/**
	 * click to dynamic radio button by label name
	 * @param driver
	 * @param radioButtonLableName
	 */
	public void clickToRadioButtonLabeName(WebDriver driver, String radioButtonLableName) {
		waitForElementClickable(driver,BasePageNopcommerceUI.DYNAMIC_RADIOBUTTON_BY_LABLE,radioButtonLableName );
		checkToDefaultCheckBoxOrRadio(driver, BasePageNopcommerceUI.DYNAMIC_RADIOBUTTON_BY_LABLE,radioButtonLableName );
	}
	/**
	 * click to dynamic check box by lable name
	 * @param driver
	 * @param checkBoxLabelName
	 */
	public void clickToChekboxByLableName(WebDriver driver, String checkBoxLabelName) {
		waitForElementClickable(driver,BasePageNopcommerceUI.DYNAMIC_CHECK_BOX,checkBoxLabelName );
		checkToDefaultCheckBoxOrRadio(driver, BasePageNopcommerceUI.DYNAMIC_CHECK_BOX,checkBoxLabelName );

	}


	public UserHomePO openEndUserSite(WebDriver driver, String endUserUrl) {
		openPageUlr(driver, endUserUrl);
		return PageGenaratorManager.getUserHomePO(driver);
	}

	public AdminDashBoardPO OpenAdminSite(WebDriver driver, String adminUrl) {
		openPageUlr(driver, adminUrl);
		return PageGenaratorManager.getAdminDashboardPO(driver);
	}
	private long timeOut = GlobalConstants.LONG_TIME_OUT;
	private long shortTimeOut = GlobalConstants.SHORT_TIME_OUT;

}
