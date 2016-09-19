package zw.co.afrosoft.dao;

import java.util.List;

import zw.co.afrosoft.model.Product;

public interface ProductDao {
	
	void addProduct(Product product);
	
	void editProduct(Product product);
	
	List<Product> getAllProducts();
	
	Product getProductById(Integer productId);
	
	void deleteProduct(Integer productId);
}
