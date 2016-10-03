package zw.co.afrosoft.dao;

import zw.co.afrosoft.model.Cart;

public interface CartDao {
	
	Cart getCartById(Integer cartId);

	void updateCart(Cart cart);
	
}
