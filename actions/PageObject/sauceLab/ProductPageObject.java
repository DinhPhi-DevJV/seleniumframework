package PageObject.sauceLab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.SauceLad.ProductPageUI;

public class ProductPageObject extends BasePage {
	WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInProductSortDropdown(String textItem) {
		waitForElementVisible(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN);
		selectItemInDefaultDropDown(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN, textItem);
	}

	public boolean isProductNameSortByAscending() {
		ArrayList<String> arrayList = new ArrayList<String>();
		List<WebElement> list = getListWebElements(driver, ProductPageUI.PRODUCT_NAME);
		for (WebElement webElement : list) {
			String itemName = webElement.getText();
			arrayList.add(itemName);
		}
		ArrayList<String> sortAsecding = new ArrayList<String>();
		for (String item : arrayList) {
			sortAsecding.add(item);
		}
		Collections.sort(sortAsecding);
		return sortAsecding.equals(arrayList);
	}

	public boolean isProductNameSortByDescending() {
		ArrayList<String> arrayList = new ArrayList<String>();
		List<WebElement> list = getListWebElements(driver, ProductPageUI.PRODUCT_NAME);
		for (WebElement webElement : list) {
			String itemName = webElement.getText();
			arrayList.add(itemName);
		}
		ArrayList<String> sortAsecding = new ArrayList<String>();
		for (String item : arrayList) {
			sortAsecding.add(item);
		}
		Collections.sort(sortAsecding);
		Collections.reverse(sortAsecding);
		return sortAsecding.equals(arrayList);
	}

	public boolean isProductPriceSortByAscending() {
		ArrayList<Float> arrayList = new ArrayList<Float>();
		List<WebElement> list = getListWebElements(driver, ProductPageUI.PRODUCT_PRICE);
		for (WebElement webElement : list) {
			Float priceFloat = Float.parseFloat(webElement.getText().replace("$", ""));

			arrayList.add(priceFloat);
		}
		ArrayList<Float> sortAsecding = new ArrayList<Float>();
		for (Float item : arrayList) {
			sortAsecding.add(item);
		}
		Collections.sort(sortAsecding);
		return sortAsecding.equals(arrayList);
	}

	public boolean isProductPriceSortByDescending() {
		ArrayList<Float> arrayList = new ArrayList<Float>();
		List<WebElement> list = getListWebElements(driver, ProductPageUI.PRODUCT_PRICE);
		for (WebElement webElement : list) {
			Float priceFloat = Float.parseFloat(webElement.getText().replace("$", ""));

			arrayList.add(priceFloat);
		}
		ArrayList<Float> sortAsecding = new ArrayList<Float>();
		for (Float item : arrayList) {
			sortAsecding.add(item);
		}
		Collections.sort(sortAsecding);
		Collections.reverse(sortAsecding);
		return sortAsecding.equals(arrayList);
	}

}
