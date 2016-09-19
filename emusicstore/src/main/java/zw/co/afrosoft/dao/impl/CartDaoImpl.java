package zw.co.afrosoft.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import zw.co.afrosoft.dao.CartDao;
import zw.co.afrosoft.model.Cart;

@Repository
public class CartDaoImpl implements CartDao {
	
	private Map<String, Cart> listOfCarts;
	
	public CartDaoImpl(){
		listOfCarts = new HashMap<>();
	}

	@Override
	public Cart create(Cart cart) {
		if(listOfCarts.keySet().contains(cart.getCartId())){
			throw new IllegalArgumentException(String.format("Cannot create a cart. A cart with a give id: %1$d already exists!", cart.getCartId()));
		}
		
		listOfCarts.put(cart.getCartId(), cart);
		
		return cart;
	}

	@Override
	public void update(String cartId, Cart cart) {
		if(!listOfCarts.keySet().contains(cartId)){
			throw new IllegalArgumentException(String.format("Cannot update the cart. The cart with a give id: %1$d does not exists!", cart.getCartId()));
		}
		
		listOfCarts.put(cartId, cart);
	}

	@Override
	public Cart read(String cartId) {
		if(!listOfCarts.keySet().contains(cartId)){
			throw new IllegalArgumentException(String.format("Cannot read cart. The cart with a give id: %1$d does not exists!", cartId));
		}

		return listOfCarts.get(cartId);
	}

	@Override
	public void delete(String cartId) {
		if(!listOfCarts.keySet().contains(cartId)){
			throw new IllegalArgumentException(String.format("Cannot delete cart. The cart with a give id: %1$d does not exists!", cartId));
		}
		listOfCarts.remove(cartId);
	}

}
