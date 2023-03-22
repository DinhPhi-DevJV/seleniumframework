package pageUIs.jQuery.dataTable;

public class HomePageUIs {
	public static final String PAGINGNATION_PAGE_BY_NUMBER="XPATH=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String PAGINGNATION_PAGE_AVTIVED_BY_NUMBER ="xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String ENTER_TO_HEADER_TEXTBOX_BY_LABLE="XPATH=//div[@class='qgrd-header-text'and text()='%s']/parent::div/following-sibling::input";
	public static final String TOTAL_PAGINGNATION = "css=ul.qgrd-pagination-ul>li.qgrd-pagination-page";
	public static final String PAGINATION_PAGE_INDEX ="xpath=//ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page'][%s]/a";
	public static final String ALL_ROW_EACH_PAGE ="xpath=//tbody/tr";
	
	// Index của cái cột mà mình cần enter vào hoặc click, select vào.
	// xpath axes lấy ra index của chính nó so với các anh em của nó.
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/td[text()='%s']/preceding-sibling::td";
	public static final String TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX ="xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX ="xpath=//tbody/tr[%s]/td[%s]/select";
	public static final String CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX ="xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String ICON_BY_ROW_INDEX_AND_TYPE_ACTION ="xpath=//tbody/tr[1]//button[@title='%s']";	
	public static final String LOAD_BUTTON ="xpath=//button[@id='btnLoad']/span";
	
	
}
