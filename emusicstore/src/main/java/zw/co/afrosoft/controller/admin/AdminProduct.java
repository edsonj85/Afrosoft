package zw.co.afrosoft.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import zw.co.afrosoft.model.Product;
import zw.co.afrosoft.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminProduct {
	
	@Autowired
	private ProductService productService;
	
	private Path path;
	
	@RequestMapping(value="/product/productInventory")
	public String products(Model model){
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		return "productInventory";
	}
	
	@RequestMapping(value="/product/addProduct")
	public String addProduct(Model model){
		Product product = new Product();
		product.setProductStatus("active");
		product.setProductCategory("instrument");
		product.setProductCondition("new");
		
		model.addAttribute("product", product);
		
		return "addProduct";
	}
	
	@RequestMapping(value="/product/addProduct", method=RequestMethod.POST)
	public String addProductPost(@Valid @ModelAttribute(value="product") Product product, BindingResult result, HttpServletRequest request){
		if(result.hasErrors()){
			return "addProduct";
		}
		
		productService.addProduct(product);
		
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		
		path = Paths.get(rootDirectory+"\\WEB-INF\\resources\\images\\"+product.getProductId()+".png");
		if(productImage!=null && !productImage.isEmpty()){
			try{
			productImage.transferTo(new File(path.toString()));
			}catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Failed to save product!", e);
			}
		}
		
		return "redirect:/admin/productInventory";
	}
	
	@RequestMapping("/product/editProduct/{id}")
	public String editProduct(@PathVariable(value="id") int id, Model model){
		Product product = productService.getProductById(id);
		
		model.addAttribute("product", product);
		
		return "editProduct";
	}
	
	@RequestMapping(value="/product/editProduct", method=RequestMethod.POST)
	public String editProductPost(@Valid @ModelAttribute(value="product") Product product, BindingResult result, HttpServletRequest request){
		if(result.hasErrors()){
			return "addProduct";
		}
		
		MultipartFile productImage = product.getProductImage();
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path=Paths.get(rootDirectory+ "\\WEB-INF\\resources\\images\\"+product.getProductId()+".png");
		
		if(productImage!=null && !productImage.isEmpty()){
			try{
				productImage.transferTo(new File(path.toString()));
			}catch(Exception e){
				e.printStackTrace();
				throw new RuntimeException("Failed to update product image", e);
			}
		}
		
		productService.editProduct(product);
		
		return "redirect:/admin/productInventory";
	}
	
	@RequestMapping(value="/admin/product/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable int productId, Model model, HttpServletRequest request) throws IOException{
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory+"\\WEB-INF\\resources\\images\\" + productId + ".png");
		
		if(Files.exists(path)){
			try{
				Files.delete(path);
			}catch(IOException e){
				e.printStackTrace();
				//throw e;
			}
		}
		
		Product product = productService.getProductById(productId);
		productService.deleteProduct(product);
		
		return "redirect:/admin/productInventory";
	}
}
