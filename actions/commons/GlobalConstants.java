package commons;

import java.io.File;

public class GlobalConstants {
	
	public static final String PORTAL_PAGE_ULR = "https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_ULR = "https://admin-demo.nopcommerce.com/";
	public static final String PORTAL_DEV_URL = "https://admin-demo.nopcommerce.com/";
	public static final String PORTAL_TESTING_URL = "https://admin-demo.nopcommerce.com/";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String REPORTNG_SCREENSHOT = PROJECT_PATH+File.separator+"ReportNGImages"+File.separator;
	public static final String EXTENT_PATH = PROJECT_PATH+File.separator+"ExtentV2"+File.separator;
	public static final String UPLOAD_FILE = PROJECT_PATH+File.separator+"uploadFile"+File.separator;
	public static final long SHORT_TIME_OUT = 5;
	public static final long LONG_TIME_OUT = 30;
	public static final long RETRY_TEST_FAIL = 3;
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String BROWSER_USER_NAME = "nguynnhphi_NK3efA";
	public static final String BROWSER_AUTOMATIC_KEY = "CMJXSsQgaSMqeK4yLz86";
	public static final String BROWSER_STACK_URL = "https://"+BROWSER_USER_NAME+":"+BROWSER_AUTOMATIC_KEY+"@hub-cloud.browserstack.com/wd/hub";
	

}
