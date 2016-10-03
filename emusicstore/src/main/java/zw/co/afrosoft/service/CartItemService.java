package zw.co.afrosoft.service;

import zw.co.afrosoft.model.Cart;
import zw.co.afrosoft.model.CartItem;

public interface CartItemService {
	
	void addCartItem(CartItem cartItem);
	
	void removeCartItem(CartItem cartItem);
	
	void removeAllCartItems(Cart cart);
	
	CartItem getCartItemByProductId(Integer productId);
}
