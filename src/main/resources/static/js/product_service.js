var ProductService = function ($http) {
  var service = this;

  service.get = function (success, error) {
    $http.get('products')
      .success(success)
      .error(error);
  };
};

angular.module('shop')
  .service('ProductService', ['$http', ProductService]);
