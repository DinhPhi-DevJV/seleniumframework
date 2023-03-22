package javaBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import static org.testng.Assert.assertTrue; // import thư viện trực tiếp bằng static
//import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import commons.BaseTest;

// để show ra consol và resulfts of test NG  Report 
@Listeners(commons.MethodListener.class)
public class Toppic_17_Assert extends BaseTest {
	WebDriver driver; // tao web drive
	// lay duong dan cua project
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\BrowserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void TC_01_ValidateCurrentUlr() {
		// khi dùng hard assert thì fall ở step đầu thì các step sau không chạy
		System.out.println("Assert 01 ----Pass----");
		String loginPagerUlr = driver.getCurrentUrl();
		verifyEquals(loginPagerUlr, "https://www.facebook.com/");
		System.out.println("Assert 02 ---- Failed----");
		String loginPageTitle = driver.getTitle();
		verifyEquals(loginPageTitle, "Facebook – log in or sign up....");
		System.out.println("Assert 03 ----Pass----");
		verifyTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());
		System.out.println("Assert 04 ----Failed----");
		verifyFalse(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());
	}

	@AfterTest
	public void offUngdung() {
		driver.quit();
	}
}
