package pageUIs.wordpress;

public class UserPortDetailPageUI {
	public static final String POST_TITLE_TEXT = "Xpath=//article//h1[text()='%s']";
	public static final String POST_CURENT_DATE_TEXT_BY_POST_TITLE = "Xpath=//article//h1[text()='%s']/following-sibling::div//time[text()='%s']";
	public static final String POST_BODY_TEXT_BY_POST_TITLE = "Xpath=//article//h1[text()='%s']/ancestor::header/following-sibling::div/p[@text='%s']";
	public static final String POST_AUTHOR_TEXT = "Xpath=//article//h1[text()='%s']/following-sibling::div//span[@class='author vcard']/a[@text()='%s']";
}
