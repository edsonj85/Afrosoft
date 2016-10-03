package zw.co.afrosoft.dao;

import java.util.List;

import zw.co.afrosoft.model.Customer;

public interface CustomerDao {

	void addCustomer(Customer customer);
	
	Customer getCustomerById(Integer customerId);
	
	List<Customer> getAllCustomers();
	
	Customer getCustomerByUsername(String username);
}
