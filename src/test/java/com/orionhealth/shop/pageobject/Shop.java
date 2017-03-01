package com.orionhealth.shop.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.orionhealth.shop.constants.Constants;
import com.orionhealth.shop.utils.TestContext;
import com.orionhealth.shop.utils.WaitUtils;

public class Shop {

	private final WebDriver driver;
	public Shop() {
		this.driver = TestContext.getDriver();
	}

	public void navigateToShop() {
		driver.navigate().to(System.getProperty("shop.host", Constants.URL));
		WaitUtils.waitUntilShopIsLoaded(driver);
	}

	public void refreshTheScreen() {
		driver.navigate().refresh();
		WaitUtils.waitUntilPageIsRefreshed();
	}

	public void setQuantityItemA(String quantity) {
		WebElement webElement = driver.findElement(By.xpath(Constants.ITEM_A_XPATH));
		clearField(webElement);
		webElement.sendKeys(quantity);
	}

	public void setQuantityItemB(String quantity) {
		WebElement webElement = driver.findElement(By.xpath(Constants.ITEM_B_XPATH));
		clearField(webElement);
		webElement.sendKeys(quantity);
	}

	public void clickBuyButton() {
		driver.findElement(By.xpath(Constants.BUY_BUTTON_XPATH)).click();
		WaitUtils.waitUntilPurchaseListed(this.driver, By.xpath(Constants.HISTORY_ORDERS_XPATH));
	}

	public String getMessage() {
		return driver.findElement(By.xpath(Constants.MESSAGE_XPATH)).getText();
	}

	public String getOrderNumber(String orderNumber) {
		return driver.findElement(By.xpath(Constants.ORDER_NUMBER_XPATH.replace("ORDER", orderNumber))).getText();
	}

	public String geHistoryOrderForOnlyItemA(String orderNumber) {
		return driver.findElement(By.xpath(Constants.HISTORY_ORDER_FOR_ONLY_ITEM_A_XPATH.replace("ORDER", orderNumber)))
				.getText();
	}

	public String geHistoryOrderForOnlyItemB(String orderNumber) {
		return driver.findElement(By.xpath(Constants.HISTORY_ORDER_FOR_ONLY_ITEM_B_XPATH.replace("ORDER", orderNumber)))
				.getText();
	}

	public String getHistoryOrderItem(String orderNumber, String item) {
		return driver.findElement(By.xpath(Constants.HISTORY_ORDER_FOR_MORE_THAN_ONE_ITEM_XPATH
				.replace("ORDER", orderNumber).replace("ITEM", item))).getText();
	}

	public String getStockItemA() {
		return driver.findElement(By.xpath(Constants.STOCK_ITEM_A_XPATH)).getText();
	}

	public String getStockItemB() {
		return driver.findElement(By.xpath(Constants.STOCK_ITEM_B_XPATH)).getText();
	}

	public void clickResetButton() {
		driver.findElement(By.xpath(Constants.RESET_BUTTON_XPATH)).click();
		WaitUtils.waitUntilPurchaseCleaned(driver, By.xpath(Constants.HISTORY_ORDERS_XPATH));
	}

	private void clearField(WebElement webElement) {
		webElement.clear();
	}

}
