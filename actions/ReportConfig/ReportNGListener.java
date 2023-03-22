package ReportConfig;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import commons.BaseTest;
import commons.GlobalConstants;

public class ReportNGListener implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {
		// Đại diện cho test class
	}

	@Override
	public void onStart(ITestContext arg0) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// Đại diện cho test case ( fail với tỉ lệ bao nhiêu ).
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// mac dinh bang true thi khong the attach hinh vao report duoc.
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		// phai lay ra duoc instance cua class ma minh dang chay test case
		Object testClass = result.getInstance();
		// phai lay duoc driver cuar base test.
		// vi khi chay thi diver trong base test se duoc khoi tao dau tien
		WebDriver webDriver = ((BaseTest) testClass).getDriverInstance();
		// ham captureScreenshot laasy ra duong dan cua cai hinh .
		String screenshotPath = captureScreenshotBase64(webDriver, result.getName());
		// lấy đường dẫn cho vào report
		Reporter.getCurrentTestResult();
		// Image File
		
		//Reporter.log("<br><a target=\"_blank\" href=\"file:///" + screenshotPath + "\">" + "<img src=\"file:///"+ screenshotPath + "\" " + "height='100' width='150'/> " + "</a></br>");
		
		// Base 64
				Reporter.log("<br><a href=\"data:image/png;base64," + screenshotPath + "\">" + "<img src=\"data:image/png;base64," + screenshotPath + "\" " + "height='100' width='150'/> " + "</a></br>");
				Reporter.setCurrentTestResult(null);
	}

	public String captureScreenshot(WebDriver driver, String screenshotName) {
		try {
			Calendar calendar = Calendar.getInstance();
			// Tên hình lấy bằng thời gian lúc step bị fail.(dùng thư viên clendar)
			// và simpledate Format.
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			// teakesScreenshot hàm chụp hình của selenium
			// chụp hình xong sẽ lưu thành 1 file
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// Đường dẫn để lưu hình ảnh
			String screenPath = GlobalConstants.REPORTNG_SCREENSHOT + screenshotName + "_"
					+ formater.format(calendar.getTime()) + ".png";
			// coppy file vào đường dẫn
			FileUtils.copyFile(source, new File(screenPath));
			// Trả về đường dẫn của hình
			return screenPath;
			// lưu không được thì trả về Io exception
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot: " + e.getMessage());
			return e.getMessage();
		}
	}

	public String captureScreenshotBase64(WebDriver driver, String screenshotName) {
		String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		return screenshotBase64;
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {

	}

	@Override
	public void onTestStart(ITestResult arg0) {

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {

	}

}
