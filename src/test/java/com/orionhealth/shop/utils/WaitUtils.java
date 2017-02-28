package com.orionhealth.shop.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	public void waitUntilShopIsLoaded() {
		// TODO Needs to be implemented
	}

	public void waitUntilPurchaseListed(WebDriver webDriver, By by) {
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void waitUntilPageIsRefreshed() {
		// TODO Needs to be implemented
	}

}
