/**
 * 
 */
var cartApp = angular.module("cartApp", []);

cartApp.controller("cartCntrl", function($scope,$http){
	$scope.refreshCart = function(cartId){
		$http.get("/emusicstore/rest/cart/" + $scope.cartId).success(function(data){
			$scope.cart =data;
		});
	};
	
	$scope.deleteCart= function(){
		$http.delete("/emusicstore/rest/cart/" + $scope.cartId).success($scope.refreshCart($scope.cartId));
	};
	
	$scope.initCartId = function(cartId){
		$scope.cartId = cartId;
		$scope.refreshCart(cartId);
	};
	
	$scope.addToCart = function(productId){
		$http.put("/emusicstore/rest/cart/put/"+productId).success(function(data){
			$http.get("/emusicstore/rest/cart/"+$scope.cartId);
			alert("Product successfully added to the cart");
		});
	};
	
	$scope.removeFromCart = function(productId){
		$http.put('/emusicstore/rest/cart/delete/'+productId).success(function(data){
			$scope.refreshCart($http.get('/emusicstore/rest/cart/get/' + $scope.cartId));
		});
	}
});