var StockItemService = function ($http) {
  var service = this;
  service.get = function (success, error) {
    $http.get('stock_items')
      .success(success)
      .error(error);
  };

  service.reset =  function (success, error) {
    $http.post('stock_items/reset')
      .success(success)
      .error(error);
  };
};

angular.module('shop')
  .service('StockItemService', ['$http', StockItemService]);
