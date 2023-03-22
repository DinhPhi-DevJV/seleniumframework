package pageObjets.wordpress;

import org.openqa.selenium.WebDriver;

public class PageGenaratorManager {
	 
	public static AdminLoginPO getAdminLoginPO(WebDriver driver) {
		return new AdminLoginPO(driver);
	}
	public static AdminDashBoardPO getAdminDashboardPO(WebDriver driver) {
		return new AdminDashBoardPO(driver);
	}
	public static AdminPorstCategoriesPO getAdminPorstCategoriesPO(WebDriver driver) {
		return new AdminPorstCategoriesPO(driver);
	}
	public static AdminPostAddNewPO getAdminPostAddNewPO(WebDriver driver) {
		return new AdminPostAddNewPO(driver);
	}
	public static AdminPostSearchPO getAdminPostSearchPO(WebDriver driver) {
		return new AdminPostSearchPO(driver);
	}
	public static AdminPostTagePO getAdminPostTagePO(WebDriver driver) {
		return new AdminPostTagePO(driver);
	}
	public static AdminProductAddNewPO getAdminProductAddNewPO(WebDriver driver) {
		return new AdminProductAddNewPO(driver);
	}
	public static AdminProductAttributePO getAdminProductAttributePO(WebDriver driver) {
		return new AdminProductAttributePO(driver);
	}
	public static AdminProductCategoriesPO getAdminProductCategoriesPO(WebDriver driver) {
		return new AdminProductCategoriesPO(driver);
	}
	public static AdminProductSearchPO getAdminProductSearchPO(WebDriver driver) {
		return new AdminProductSearchPO(driver);
	}
	public static AdminProductTagPO getAdminProductTagPO(WebDriver driver) {
		return new AdminProductTagPO(driver);
	}
	public static UserHomePO getUserHomePO(WebDriver driver) {
		return new UserHomePO(driver);
	}
	public static UserPortDetailPO getUserPortDetailPO(WebDriver driver) {
		return new UserPortDetailPO(driver);
	}
	public static AdminUserPO getAdminUserPageObject(WebDriver driver) {
		return new AdminUserPO(driver);
	}
	
	
}
