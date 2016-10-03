/**
 * 
 */
var cartApp = angular.module("cartApp", []);

cartApp.controller("cartCntrl", ['$scope', '$http', function($scope,$http){
	var self = this;
	self.refreshCart = function(){
		$http.get("/emusicstore/rest/cart/" + cartId).success(function(data){
			self.cart =data;
		});
	};
	
	self.initCartId = function(cartId){
		self.cartId = cartId;
		self.refreshCart();
	};
	
	self.addToCart = function(productId){
		$http.put("/emusicstore/rest/cart/add/"+productId).success(function(){
			alert("Product successfully added to the cart");
		});
	};
	
	self.removeFromCart = function(productId){
		$http.put('/emusicstore/rest/cart/delete/'+productId).success(function(data){
			self.refreshCart();
		});
	};
	
	self.calGrandTotal = function(){
		var grandTotal = 0;
		
		for(var i = 0; i < self.cart.cartItems.length; i++){
			grandTotal += self.cart.cartItems[i].totalPrice;
		}
		
		return grandTotal;
	};
}]);