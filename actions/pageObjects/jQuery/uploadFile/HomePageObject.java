package pageObjects.jQuery.uploadFile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.uploadFile.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToStartUploadFile() {
		List<WebElement> elementStarts =getListWebElements(driver, HomePageUI.startIcon);
		elementStarts.forEach(element->{element.click(); sleepInsecond(2);});
	}

	public boolean isFileLoadByName(WebDriver driver, String valueName) {
		waitForElementVisible(driver,HomePageUI.UPLOAD_FILE_NAME , valueName);
		return isElementDisplayed(driver, HomePageUI.UPLOAD_FILE_NAME,valueName);
	}
	public boolean isFileLinkByName(WebDriver driver, String valueName) {
		waitForElementVisible(driver,HomePageUI.UPLOADED_FILE_LINK, valueName);
		return isElementDisplayed(driver, HomePageUI.UPLOADED_FILE_LINK,valueName);
	}
	public boolean isImageUploadedByName(WebDriver driver,String...valueName) {
		waitForElementVisible(driver,HomePageUI.UPLOADED_LINK_IMAGE, valueName);
		return isImageLoaded(driver, HomePageUI.UPLOADED_LINK_IMAGE,valueName);
	}
}
