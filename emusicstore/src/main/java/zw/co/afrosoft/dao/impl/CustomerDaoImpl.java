package zw.co.afrosoft.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import zw.co.afrosoft.dao.CustomerDao;
import zw.co.afrosoft.model.Authorities;
import zw.co.afrosoft.model.Cart;
import zw.co.afrosoft.model.Customer;
import zw.co.afrosoft.model.Users;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		
		customer.getBillingAddress().setCustomer(customer);
		customer.getShippingAddress().setCustomer(customer);
		
		session.saveOrUpdate(customer);
		session.saveOrUpdate(customer.getBillingAddress());
		session.saveOrUpdate(customer.getShippingAddress());
		
		Users user = new Users();
		user.setCustomerId(customer.getCustomerId());
		user.setEnabled(true);
		user.setPassword(customer.getPassword());
		user.setUsername(customer.getUsername());
		
		Authorities authorities = new Authorities();
		authorities.setAuthority("ROLE_ADMIN");
		authorities.setUsername(customer.getUsername());
		
		session.saveOrUpdate(user);
		session.saveOrUpdate(authorities);
		
		Cart cart = new Cart();
		cart.setCustomer(customer);
		customer.setCart(cart);
		
		session.saveOrUpdate(cart);
		session.saveOrUpdate(customer);
		
		session.flush();
	}

	@Override
	public Customer getCustomerById(Integer customerId) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, customerId);
		session.flush();
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Customer> query = session.createQuery("from Customer", Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
	}
	
	public Customer getCustomerByUsername(String username){
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Customer> query = session.createQuery("from Customer c where c.username = :username", Customer.class);
		Customer customer = query.getSingleResult();
		session.flush();
		
		return customer;
	}

}
