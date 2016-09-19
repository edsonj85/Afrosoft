package zw.co.afrosoft.dao;

import zw.co.afrosoft.model.Cart;

public interface CartDao {
	Cart create(Cart cart);
	
	void update(String cartId, Cart cart);
	
	Cart read(String cartId);
	
	void delete(String cartId);
}
