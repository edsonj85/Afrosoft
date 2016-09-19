package zw.co.afrosoft.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import zw.co.afrosoft.dao.ProductDao;
import zw.co.afrosoft.model.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
	}

	@Override
	public List<Product> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product");
		List<Product> products = query.getResultList();
		session.flush();
		return products;
	}

	@Override
	public Product getProductById(Integer productId) {
		Session session = sessionFactory.getCurrentSession();
		Product product = session.get(Product.class, productId);
		session.flush();
		return product;
	}

	@Override
	public void deleteProduct(Integer productId) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(getProductById(productId));
		session.flush();
	}

	@Override
	public void editProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
		
	}

}
