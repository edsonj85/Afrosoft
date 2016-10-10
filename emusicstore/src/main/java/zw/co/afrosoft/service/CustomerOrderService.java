package zw.co.afrosoft.service;

import zw.co.afrosoft.model.CustomerOrder;

public interface CustomerOrderService {
	void addCustomerOrder(CustomerOrder customerOrder);
	
	double getCustomerOrderGrandTotal(int cartId);
}
