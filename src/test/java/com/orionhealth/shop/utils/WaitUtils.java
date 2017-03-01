package com.orionhealth.shop.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	public static void waitUntilShopIsLoaded(final WebDriver driver) {
		// TODO Needs to be implemented
	}

	public static void waitUntilPurchaseListed(final WebDriver driver, final By by) {
		final WebDriverWait wait = new WebDriverWait(driver, 3);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (final TimeoutException e) {
			// do nothing
		}

	}

	public static void waitUntilPurchaseCleaned(final WebDriver driver, final By by) {
		final WebDriverWait wait = new WebDriverWait(driver, 5);
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
		} catch (final TimeoutException e) {
			// do nothing
		}

	}

	public static void waitUntilPageIsRefreshed() {
		// TODO Needs to be implemented
	}

}
