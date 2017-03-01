package com.orionhealth.shop.constants;

public interface Constants {

	String URL = "http://localhost:8080";

	String ORDER_NUMBER = "Order #";

	String ITEM_A_XPATH = "/html/body/article/section[2]/form/div[1]/label/input";

	String ITEM_B_XPATH = "/html/body/article/section[2]/form/div[2]/label/input";

	String BUY_BUTTON_XPATH = "/html/body/article/section[2]/form/button";

	String MESSAGE_XPATH = "/html/body/article/h1";
	
	String STOCK_ITEM_A_XPATH = "/html/body/article/section[1]/div[1]";

	String STOCK_ITEM_B_XPATH = "/html/body/article/section[1]/div[2]";

	String HISTORY_ORDERS_XPATH = "/html/body/article/section[3]/div";
	
	String HISTORY_ORDER_FOR_ONLY_ITEM_A_XPATH = "/html/body/article/section[3]/div[ORDER]/div[1]";
	
	String HISTORY_ORDER_FOR_ONLY_ITEM_B_XPATH = "/html/body/article/section[3]/div[ORDER]/div[1]";

	String HISTORY_ORDER_FOR_MORE_THAN_ONE_ITEM_XPATH = "/html/body/article/section[3]/div[ORDER]/div[ITEM]";

	String ORDER_NUMBER_XPATH = "/html/body/article/section[3]/div[ORDER]/h1";

	String RESET_BUTTON_XPATH = "/html/body/article/section[4]/button";
}
