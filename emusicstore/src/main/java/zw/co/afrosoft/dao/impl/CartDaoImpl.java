package zw.co.afrosoft.dao.impl;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import zw.co.afrosoft.dao.CartDao;
import zw.co.afrosoft.model.Cart;
import zw.co.afrosoft.service.CustomerOrderService;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CustomerOrderService customerOrderService;
	
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
		double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
		
		cart.setGrandTotal(grandTotal);
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cart);
		session.flush();
	}

	@Override
	public Cart validate(int cartId) throws IOException {
		Cart cart = getCartById(cartId);
		if(cart==null || cart.getCartItems().size()==0){
			throw new IOException(cartId+"");
		}
		updateCart(cart);
		return cart;
	}

}
