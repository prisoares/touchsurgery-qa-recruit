var OrderService = function ($http) {
  var service = this;
  service.add = function (order, success, error) {
    $http.post('orders', order)
      .success(success)
      .error(error);
  };

  service.get = function (success, error) {
    $http.get('orders')
      .success(success)
      .error(error);
  };
};

angular.module('shop')
  .service('OrderService', ['$http', OrderService]);
