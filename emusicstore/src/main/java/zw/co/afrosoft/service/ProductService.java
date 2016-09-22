package zw.co.afrosoft.service;

import java.util.List;

import zw.co.afrosoft.model.Product;

public interface ProductService {
	List<Product> getProductList();
	
	Product getProductById(int productId);
	
	void addProduct(Product product);
	
	void editProduct(Product product);
	
	void deleteProduct(Product product);
}
