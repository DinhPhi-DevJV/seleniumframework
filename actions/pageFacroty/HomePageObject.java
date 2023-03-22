package pageFacroty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class HomePageObject extends BasePageFactory {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		// init element no moi lien ket dc element vs locator duoc
		PageFactory.initElements(driver, this);
	}

	// Page UI
	@FindBy(xpath = "//a[@class='ico-register']")
	private WebElement registerLink;
	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement loginLink;
	@FindBy(xpath = "//a[@class='ico-account']")
	private WebElement myAcountLink;
	// page object/action
	public void clickToRegisterLink() {
		waitForElementVisible(driver, registerLink);
		clickToElement(driver, registerLink);
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

}
