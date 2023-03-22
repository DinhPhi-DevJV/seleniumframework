package javaBasic;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_06_Conditon_Statement {
	WebDriver driver;
	@Test
	public void TC_01_If() {

		boolean status = 5 > 3;
		System.out.println(status);
		// nhận vào một điều kiện đúng thì vào phần thân của if còn sai thì bỏ qua.
		// kiểm tra duy nhất một điều kiện nếu dk đúng sẽ action (xxx) trong phần thân.
		if (status) {
			// đúng thì vào phần if
			// sai thì bỏ qua
			System.out.println(" Go to if");
		}
		// assign (gán)
		int studenNumber = 10;
		// so sánh ==
		status = (studenNumber == 10);
		WebDriver driver = new FirefoxDriver();
		// element luôn có trong dom dù popup hiển thị hay không.
		// nếu tìm không thấy sẽ bị fail
		WebElement popup = driver.findElement(By.id(""));
		if (popup.isDisplayed()) {
		}
		// không có trong Dom thì trả về một cái list rỗng chứ ko bị fail.
		List<WebElement> salePopup = driver.findElements(By.id(""));
		if (salePopup.size() > 0 && salePopup.get(0).isDisplayed()) {
		}
		// Uncheck to checkbox
		WebElement languagesCheckbox = driver.findElement(By.id(""));
		if (languagesCheckbox.isDisplayed()) {
			languagesCheckbox.click();
		}
		// Check to checkbox
		if (!languagesCheckbox.isDisplayed()) {
			languagesCheckbox.click();
		}
		// có tới 2 điều kiên đúng thì vào if sai thì vào else

	}

	@Test
	public void TC_02_If_Else() {
		// có tới hai điều kiện nếu như đúng thì vào if nếu như sai thì vào else
		// nếu driver start với trình duyệt chrome/frifox/sanfari thì dùng hàm click 
		// thông thường (buldtin)của selenium
		// nếu start IE dùng javascriptExcutor
		
	}
}
