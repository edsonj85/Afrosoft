package zw.co.afrosoft.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import zw.co.afrosoft.dao.CartDao;
import zw.co.afrosoft.model.Cart;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Cart getCartById(Integer cartId) {
		Session session = sessionFactory.getCurrentSession();
		Cart cart = session.get(Cart.class, cartId);
		session.flush();
		return cart;
	}

	@Override
	public void updateCart(Cart cart) {
		Integer cartId = cart.getCartId();
		// will be considered very soon.
	}

}
