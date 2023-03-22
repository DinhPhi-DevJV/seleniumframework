package commons;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	private long timeOut = 30;
	

	public static BasePageFactory getBasePageObject() {
		return new BasePageFactory();
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

	public void waitForElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, timeOut);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForAllElementsVisible(WebDriver driver, List<WebElement> element) {
		WebDriverWait explicitwait = new WebDriverWait(driver, timeOut);
		explicitwait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public void waitForElementInVisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, timeOut);
		explicitWait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitForAllElementsInVisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitwait = new WebDriverWait(driver, timeOut);
		explicitwait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitForElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, timeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	public void sendkeys(WebDriver driver, WebElement element, String keys) {
		element.clear();
		element.sendKeys(keys);
	}

	public String getTextElement(WebDriver driver, WebElement element) {
		return element.getText();
	}

}
