package zw.co.afrosoft.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@GenericGenerator(
        name = "tableGenerator",
        strategy = "org.hibernate.id.enhanced.TableGenerator"
)
public class Product implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3125486198018198555L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tableGenerator")
	private Integer productId;
	
	@NotEmpty(message="The product name cannot be empty!")
	private String productName;
	private String productCategory;
	private String productDescription;
	private String productStatus;
	private String productCondition;
	@Min(value=0, message="Product price must not be less than 0!")
	private double productPrice;
	@Min(value=0, message="Units in stock cannot be less than 0!")
	private int unitsInStock;
	@NotEmpty(message="Product manufacturer information required!")
	private String manufacturer;
	@Transient
	private MultipartFile productImage;
	
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonIgnore
	private List<CartItem> cartItemList;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public String getProductCondition() {
		return productCondition;
	}
	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public MultipartFile getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	public List<CartItem> getCartItemList() {
		return cartItemList;
	}
	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}
	
}
