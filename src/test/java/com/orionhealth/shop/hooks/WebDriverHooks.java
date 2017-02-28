package com.orionhealth.shop.hooks;

import com.orionhealth.shop.utils.TestContext;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class WebDriverHooks {

	@Before
	public void testSetUp() {
		TestContext.getDriverInstance();
	}

	@After
	public void testShutDown() {
		TestContext.getDriverInstance().manage().deleteAllCookies();
	}

}
