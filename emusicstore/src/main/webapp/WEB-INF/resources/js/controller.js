/**
 * 
 */
var cartApp = angular.module("cartApp", []);

cartApp.controller("cartCntrl", ['$scope', '$http', function($scope,$http){
	var self = this;
	self.refreshCart = function(cartId){
		$http.get("/emusicstore/rest/cart/" + cartId).success(function(data){
			self.cart =data;
		});
	};
	/**
	$scope.deleteCart= function(){
		$http.delete("/emusicstore/rest/cart/" + $scope.cartId).success($scope.refreshCart($scope.cartId));
	};
	*/
	self.initCartId = function(cartId){
		self.cartId = cartId;
		self.refreshCart(cartId);
	};
	
	self.addToCart = function(productId){
		$http.put("/emusicstore/rest/cart/add/"+productId).success(function(data){
			$http.get("/emusicstore/rest/cart/"+self.cartId);
			alert("Product successfully added to the cart");
		});
	};
	
	self.removeFromCart = function(productId){
		$http.put('/emusicstore/rest/cart/delete/'+productId).success(function(data){
			self.refreshCart($http.get('/emusicstore/rest/cart/get/' + self.cartId));
		});
	}
}]);