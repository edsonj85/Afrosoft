package zw.co.afrosoft.service;

import java.util.List;

import zw.co.afrosoft.model.Customer;

public interface CustomerService {
	
	void addCustomer(Customer customer);
	
	Customer getCustomerById(Integer customerId);
	
	List<Customer> getAllCustomers();
	
	Customer getCustomerByUsername(String username);
}
