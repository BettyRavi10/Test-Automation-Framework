package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utility.BrowserUtility;

public class SerchResultPage extends BrowserUtility {
	private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[@class=\"lighter\"]");
	private static final By PRODUCT_LIST_NAME_LOCATOR = By.xpath("//h5[@itemprop=\"name\"]/a");
	
	public SerchResultPage(WebDriver driver) {
		super(driver);
	}

	public String getTitleOfProductListing() {
		return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
	}
	
	public boolean isSerachNamePresentInProductList(String searchTerm) {
		List<String> keyWords = Arrays.asList(searchTerm.toLowerCase().split(","));
		List<String> productNameList = getAllVisibleText(PRODUCT_LIST_NAME_LOCATOR);
		boolean result =productNameList.stream().anyMatch(name ->keyWords.stream().anyMatch(name.toLowerCase()::contains));
		return result;
}
	
//	public ProductDetailPage clickOnProductAt(int index) {
//	clickOnElement(getAllElements(PRODUCT_LIST_NAME_LOCATOR).get(index));
//	ProductDetailPage productDetailPage = new ProductDetailPage(getDriver()); 
//	return productDetailPage;
//	}
	
	public ProductDetailPage clickOnProductAt(int index) {

	    List<WebElement> products = getAllElements(PRODUCT_LIST_NAME_LOCATOR);

	    System.out.println("Number of products found: " + products.size());

	    clickOnElement(products.get(index));

	    return new ProductDetailPage(getDriver());
	}
}