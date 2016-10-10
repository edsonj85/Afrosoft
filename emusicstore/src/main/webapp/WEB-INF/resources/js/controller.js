/**
 * 
 */
var cartApp = angular.module("cartApp", []);

cartApp.controller("cartCntrl", ['$scope', '$http', '$log', function($scope,$http, $log){
	var self = this;
	self.refreshCart = function(){
		$http.get("/emusicstore/rest/cart/" +  self.cartId).success(function(data){
			
			self.cart =data;
			self.cartItems = data.cartItems;
			$log.debug(self.cart);
			$log.debug(self.cartItems);
		});
	};
	
	self.init = function(cartId){
		self.cartId = cartId;
		self.refreshCart();
	};
	
	self.addToCart = function(productId){
		$http.put("/emusicstore/rest/cart/add/"+productId).success(function(){
			alert("Product successfully added to the cart");
		});
	};
	
	self.removeFromCart = function(productId){
		$http.put('/emusicstore/rest/cart/remove/'+productId).success(function(){
			self.refreshCart();
		});
	};
	
	self.calGrandTotal = function(){
		var grandTotal = 0;
		
		for(var i = 0; i < self.cartItems.length; i++){
			grandTotal += self.cartItems[i].totalPrice;
		}
		
		return grandTotal;
	};
	
	self.clearCart = function(){
		$http.put('/emusicstore/rest/cart/clearCart/'+this.cartId).success(function(){
			self.refreshCart();
		});
	}
}]);