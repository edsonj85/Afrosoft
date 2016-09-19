package zw.co.afrosoft.controller;

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

import zw.co.afrosoft.dao.ProductDao;
import zw.co.afrosoft.model.Product;

@Controller
public class AdminController {
	
	private Path path;
	
	@Autowired
	private ProductDao productDao;

	@RequestMapping("/admin")
	public String admin(){
		return "admin";
	}
	
	@RequestMapping("/admin/productInventory")
	public String productInventory(Model model){
		List<Product> products = productDao.getAllProducts();
		model.addAttribute("products", products);
		
		return "productInventory";
	}
	
	
	@RequestMapping("/admin/productInventory/addProduct")
	public String addProduct(Model model){
		Product product = new Product();
		product.setProductCategory("instrument");
		product.setProductCondition("new");
		product.setProductStatus("active");
		product.setProductPrice(10.50);
		model.addAttribute(product);
		
		return "addProduct";
	}
	
	@RequestMapping(value="/admin/productInventory/addProduct", method= RequestMethod.POST)
	public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request){
		if(result.hasErrors()){
			return "/addProduct";
		}
		
		productDao.addProduct(product);
		MultipartFile productImage = product.getProductImage();
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");
		
		try{
			productImage.transferTo(new File(path.toString()));
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException("Image upload failed", ex);
		}
		
		return "redirect:/admin/productInventory";
	}
	
	@RequestMapping("/admin/productInventory/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable Integer productId, Model model, HttpServletRequest request){
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + productId + ".png");
		
		if(Files.exists(path)){
			try{
				Files.delete(path);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
		productDao.deleteProduct(productId);
		
		return "redirect:/admin/productInventory";
	}
	
	@RequestMapping("/admin/productInventory/editProduct/{productId}")
	public String editProduct(@PathVariable Integer productId, Model model){
		Product product = productDao.getProductById(productId);
		model.addAttribute(product);
		
		return "editProduct";
	}
	
	@RequestMapping(value="/admin/productInventory/editProduct", method=RequestMethod.POST)
	public String editProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model, HttpServletRequest request){
		
		if(result.hasErrors()){
			return "/editProduct";
		}
		
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory+"\\WEB-INF\\resources\\images\\" + product.getProductId()+".png");
		
		if(productImage != null && !productImage.isEmpty()){
			try {
				productImage.transferTo(new File(path.toString()));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
				throw new RuntimeException("Failed to update the product image", e);
			}
		}
		
		productDao.editProduct(product);
		
		return "redirect:/admin/productInventory";
	}
}
