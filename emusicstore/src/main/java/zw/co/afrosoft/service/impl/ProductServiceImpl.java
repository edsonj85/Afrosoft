/**
 * 
 */
package zw.co.afrosoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zw.co.afrosoft.dao.ProductDao;
import zw.co.afrosoft.model.Product;
import zw.co.afrosoft.service.ProductService;

/**
 * @author edsonj
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	/* (non-Javadoc)
	 * @see zw.co.afrosoft.service.ProductService#getProductList()
	 */
	@Override
	public List<Product> getProductList() {
		return productDao.getProductList();
	}

	/* (non-Javadoc)
	 * @see zw.co.afrosoft.service.ProductService#getProductById(int)
	 */
	@Override
	public Product getProductById(int productId) {
		
		return productDao.getProductById(productId);
	}

	/* (non-Javadoc)
	 * @see zw.co.afrosoft.service.ProductService#addProduct(zw.co.afrosoft.model.Product)
	 */
	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);

	}

	/* (non-Javadoc)
	 * @see zw.co.afrosoft.service.ProductService#editProduct(zw.co.afrosoft.model.Product)
	 */
	@Override
	public void editProduct(Product product) {
		productDao.editProduct(product);

	}

	/* (non-Javadoc)
	 * @see zw.co.afrosoft.service.ProductService#deleteProduct(zw.co.afrosoft.model.Product)
	 */
	@Override
	public void deleteProduct(Product product) {
		productDao.deleteProduct(product);

	}

}
