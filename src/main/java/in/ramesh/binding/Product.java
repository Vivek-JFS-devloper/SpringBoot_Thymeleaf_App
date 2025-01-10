package in.ramesh.binding;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Product {
	
	//from validation
	private Integer pid;
	@NotEmpty(message = "name is required")
	@Size(min = 3,max = 10)
	private String pname;  // Correct field name
	@NotNull(message = "price is required")
	private Double price;
	@NotNull(message = "quantity is required")
	private Integer quantity;

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {  // Correct getter method
		return pname;
	}

	public void setPname(String pname) {  // Correct setter method
		this.pname = pname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + "]";
	}
}
