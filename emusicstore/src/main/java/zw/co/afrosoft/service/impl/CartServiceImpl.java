package zw.co.afrosoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zw.co.afrosoft.dao.CartDao;
import zw.co.afrosoft.model.Cart;
import zw.co.afrosoft.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDao cartDao;

	@Override
	public Cart getCartById(Integer cartId) {
		
		return cartDao.getCartById(cartId);
	}

	@Override
	public void updateCart(Cart cart) {
		cartDao.updateCart(cart);

	}

}
