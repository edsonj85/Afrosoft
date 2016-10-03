package zw.co.afrosoft.service;

import zw.co.afrosoft.model.Cart;

public interface CartService {
	
	Cart getCartById(Integer cartId);
	
	void updateCart(Cart cart);
}
