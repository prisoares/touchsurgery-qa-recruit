var ShopController = function ($document, stockItemService, orderService, productService) {
  var controller = this;

  controller.message = '';
  controller.stockItems = [];
  controller.newOrder = {};
  controller.orders = [];
  controller.products = [];

  controller.convertNewOrderToJSON = function (newOrder) {
    var result = {order_items: []};
    for (var orderItem in newOrder) {
      result.order_items.push({
        product: {
          id: +orderItem
        },
        quantity: newOrder[orderItem]
      });
    }
    return result;
  };

  controller.updateMessage = function (message) {
    controller.message = message;
  };

  controller.updateError = function (error) {
    controller.message = error.message;
  };

  controller.updateContent = function () {
    controller.updateMessage('Success');
    controller.getOrders();
    controller.getStockItems();
  };

  controller.getOrders = function () {
    orderService.get(controller.updateOrders, controller.updateError);
  };

  controller.updateOrders = function (orders) {
    controller.orders = orders;
  };

  controller.getProducts = function () {
    productService.get(controller.updateProducts, controller.updateError);
  };

  controller.updateProducts = function (products) {
    controller.products = products;
  };

  controller.getStockItems = function () {
    stockItemService.get(controller.updateStockItems, controller.updateError);
  };

  controller.updateStockItems = function (stockItems) {
    controller.stockItems = stockItems;
  };

  controller.addOrder = function () {
    orderService.add(
      controller.convertNewOrderToJSON(controller.newOrder),
      controller.updateContent,
      controller.updateError);
  };

  controller.reset = function () {
    stockItemService.reset(controller.updateContent,
    controller.updateError);
  };

  $document.ready(controller.getStockItems);
  $document.ready(controller.getOrders);
  $document.ready(controller.getProducts);
};

angular.module('shop')
  .controller('ShopController', ['$document', 'StockItemService', 'OrderService', 'ProductService', ShopController]);
