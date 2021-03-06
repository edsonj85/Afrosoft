package zw.co.afrosoft.dao;

import java.util.List;

import zw.co.afrosoft.model.Product;

public interface ProductDao {
	
	List<Product> getProductList();
	
	Product getProductById(int productId);
	
	void addProduct(Product product);
	
	void editProduct(Product product);
	
	void deleteProduct(Product product);
}
