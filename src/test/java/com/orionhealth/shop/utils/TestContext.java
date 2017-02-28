package com.orionhealth.shop.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestContext {

	private static WebDriver driver;

	public static WebDriver getDriverInstance() {
		if (driver == null) {
			driver = new ChromeDriver();
		}
		return driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		TestContext.driver = driver;
	}

}
