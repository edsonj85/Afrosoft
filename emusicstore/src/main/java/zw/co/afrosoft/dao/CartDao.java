package zw.co.afrosoft.dao;

import java.io.IOException;

import zw.co.afrosoft.model.Cart;

public interface CartDao {
	
	Cart getCartById(Integer cartId);

	void updateCart(Cart cart);
	
	Cart validate(int cartId) throws IOException;
	
}
