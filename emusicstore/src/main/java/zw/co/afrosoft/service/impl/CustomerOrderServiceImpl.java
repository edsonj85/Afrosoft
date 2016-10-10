package zw.co.afrosoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zw.co.afrosoft.dao.CustomerOrderDao;
import zw.co.afrosoft.model.Cart;
import zw.co.afrosoft.model.CartItem;
import zw.co.afrosoft.model.CustomerOrder;
import zw.co.afrosoft.service.CartService;
import zw.co.afrosoft.service.CustomerOrderService;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {
	
	@Autowired
	private CustomerOrderDao customerOrderDao;
	
	@Autowired
	private CartService cartService;

	@Override
	public void addCustomerOrder(CustomerOrder customerOrder) {
		customerOrderDao.addCustomerOrder(customerOrder);
	}

	@Override
	public double getCustomerOrderGrandTotal(int cartId) {
		double grandTotal = 0;
		Cart cart = cartService.getCartById(cartId);
		for(CartItem cartItem : cart.getCartItems())
			grandTotal+=cartItem.getTotalPrice();
		return grandTotal;
	}

}
