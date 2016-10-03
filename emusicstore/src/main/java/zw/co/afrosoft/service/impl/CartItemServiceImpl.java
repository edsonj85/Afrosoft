package zw.co.afrosoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zw.co.afrosoft.dao.CartItemDao;
import zw.co.afrosoft.model.Cart;
import zw.co.afrosoft.model.CartItem;
import zw.co.afrosoft.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{
	
	@Autowired
	private CartItemDao cartItemDao;

	@Override
	public void addCartItem(CartItem cartItem) {
		cartItemDao.addCartItem(cartItem);
		
	}

	@Override
	public void removeCartItem(CartItem cartItem) {
		cartItemDao.removeCartItem(cartItem);
		
	}

	@Override
	public void removeAllCartItems(Cart cart) {
		cartItemDao.removeAllCartItems(cart);
		
	}
	
	public CartItem getCartItemByProductId(Integer productId){
		return cartItemDao.getCartItemByProductId(productId);
	}

}
