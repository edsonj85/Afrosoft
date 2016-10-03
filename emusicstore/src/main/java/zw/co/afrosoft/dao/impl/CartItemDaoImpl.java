package zw.co.afrosoft.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import zw.co.afrosoft.dao.CartItemDao;
import zw.co.afrosoft.model.Cart;
import zw.co.afrosoft.model.CartItem;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addCartItem(CartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
		session.flush();
	}

	@Override
	public void removeCartItem(CartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.remove(cartItem);
		session.flush();
	}

	@Override
	public void removeAllCartItems(Cart cart) {
		List<CartItem> cartItems = cart.getCartItems();
		
		for(CartItem cartItem : cartItems){
			removeCartItem(cartItem);
		}
	}
	
	@Override
	public CartItem getCartItemByProductId(Integer productId){
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<CartItem> query = session.createQuery("from CartItem where productId = :productId", CartItem.class);
		CartItem cartItem = query.getSingleResult();
		session.flush();
		return cartItem;
	}

}
