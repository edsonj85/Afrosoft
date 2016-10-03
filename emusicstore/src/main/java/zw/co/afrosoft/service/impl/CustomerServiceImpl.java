package zw.co.afrosoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zw.co.afrosoft.dao.CustomerDao;
import zw.co.afrosoft.model.Customer;
import zw.co.afrosoft.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}

	@Override
	public Customer getCustomerById(Integer customerId) {
		return customerDao.getCustomerById(customerId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}
	
	public Customer getCustomerByUsername(String username){
		return customerDao.getCustomerByUsername(username);
	}

}
