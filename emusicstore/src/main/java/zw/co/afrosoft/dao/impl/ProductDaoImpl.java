package zw.co.afrosoft.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
	public List<Product> getProductList() {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Product> query = session.createQuery("from Product", Product.class);
		List<Product> productList = query.getResultList();
		session.flush();
		return productList;
	}

	@Override
	public Product getProductById(int productId) {
		Session session = sessionFactory.getCurrentSession();
		Product product = session.get(Product.class, productId);
		session.flush();
		return product;
	}

	@Override
	public void addProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
	}

	@Override
	public void editProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();		
	}

	@Override
	public void deleteProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(product);
		session.flush();
		
	}


}
