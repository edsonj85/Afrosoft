package zw.co.afrosoft.dao;

import zw.co.afrosoft.model.Cart;
import zw.co.afrosoft.model.CartItem;

public interface CartItemDao {
	
	void addCartItem(CartItem cartItem);
	
	void removeCartItem(CartItem cartItem);
	
	void removeAllCartItems(Cart cart);
	
	CartItem getCartItemByProductId(Integer productId);
}
