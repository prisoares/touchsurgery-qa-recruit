package com.orionhealth.shop.stedefs;

import java.util.List;

import org.junit.Assert;

import com.orionhealth.shop.constants.Constants;
import com.orionhealth.shop.pageobject.Shop;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShopStepDefs {

	private Shop shop;

	@Given("^I open the Shop page$")
	public void i_open_the_Shop_page() {
		shop = new Shop();
		shop.navigateToShop();

		shop.refreshTheScreen();

		shop.clickResetButton();
	}

	@When("^I fill Item A with \"(.*)\" products$")
	public void i_fill_Item_A_with_products(String quantityA) {
		shop.setQuantityItemA(quantityA);
	}
	
	@When("^I fill Item B with \"(.*)\" products$")
	public void i_fill_Item_B_with_products(String quantityB) {
		shop.setQuantityItemB(quantityB);
	}

	@When("^I click on Buy button$")
	public void i_click_on_Buy_button() {
		shop.clickBuyButton();
	}
	
	@Then("^I see the \"(.*)\" message$")
	public void i_see_the_message(String successMessage) {
		String actualMessage = shop.getMessage();
		String expectedMessage = successMessage;
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@Then("^I see the Order Number \"(.*)\"$")
	public void i_see_the_Order_Number(String number) {
		String actualOrderNumber = shop.getOrderNumber(number);
		String expectedOrderNumber = Constants.ORDER_NUMBER.concat(number);
		Assert.assertEquals(expectedOrderNumber, actualOrderNumber);
	}

	@Then("^I see the stocks decrementation of the item A with \"(.*)\"$")
	public void i_see_the_stocks_decrementation_of_the_item_A_with(String decrementationValue) {
		String actualStockNumberA = shop.getStockItemA();
		String expectedStockNumberA = "Item A: " + decrementationValue + " left";
		Assert.assertEquals(expectedStockNumberA, actualStockNumberA);
	}

	@Then("^I see the stocks decrementation of the item B with \"(.*)\"$")
	public void i_see_the_stocks_decrementation_of_the_item_B_with(String decrementationValue) {
		String actualStockNumberB = shop.getStockItemB();
		String expectedStockNumberB = "Item B: " + decrementationValue + " left";
		Assert.assertEquals(expectedStockNumberB, actualStockNumberB);
	}

	@Then("^I see the items history shown in Order Number \"(.*)\" in$")
	public void i_see_the_items_history_shown_in_Order_Number_in(String orderNumber, DataTable items) {
		List<List<String>> table = items.raw();

		String firstItem = "1";
		String secondItem = "2";
		String actualOrderHistoryA = shop.getHistoryOrderItem(orderNumber, firstItem);
		String actualOrderHistoryB = shop.getHistoryOrderItem(orderNumber, secondItem);

		Assert.assertEquals(table.get(1).get(0), actualOrderHistoryA);
		Assert.assertEquals(table.get(2).get(0), actualOrderHistoryB);
	}
	
	@Then("^I see the items history shown in Order Number \"(.*)\" in item A with \"(.*)\" products displayed$")
	public void i_see_the_items_history_shown_in_Order_Number_in_item_A_with_products_displayed(String orderNumber,
			String itemQuantity) {
		String actualOrderHistoryA = shop.geHistoryOrderForOnlyItemA(orderNumber);
		String expectedOrderHistoryA = "Item A " + itemQuantity;
		Assert.assertEquals(expectedOrderHistoryA, actualOrderHistoryA);
	}
	
	@Then("^I see the items history shown in Order Number \"(.*)\" in item B with \"(.*)\" products displayed$")
	public void i_see_the_items_history_shown_in_Order_Number_in_item_B_with_products_displayed(String orderNumber,
			String itemQuantity) {
		String actualOrderHistoryB = shop.geHistoryOrderForOnlyItemB(orderNumber);
		String expectedOrderHistoryB = "Item B " + itemQuantity;
		Assert.assertEquals(expectedOrderHistoryB, actualOrderHistoryB);
	}

	
}
