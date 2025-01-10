package in.ramesh.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.ramesh.binding.Product;
import in.ramesh.entity.ProductEntity;
import in.ramesh.repository.ProductRepository;  // Corrected spelling
import jakarta.validation.Valid;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository repository;  // Corrected spelling
	
	//method to display form
	@RequestMapping("/")
	 public String showIndexPage(Model model) {
        // Create a Product object and add it to the model
        Product product = new Product();
        model.addAttribute("product", product);
        return "index";
	}
	
	//method to handle form submission
	@PostMapping("/product")
	public String handleSubmissionBtn(@Valid   Product p, BindingResult bindingResult, Model model) {
	    // Check if there are validation errors
	    if (bindingResult.hasErrors()) {
	        return "index"; // return to the form page with error messages
	    } else {
	        // Display success message and process the valid product data
	        model.addAttribute("sms", "Product data saved successfully!");
	        
	        // Convert the Product object to a ProductEntity for saving in the database
	        ProductEntity entity = new ProductEntity();
	        BeanUtils.copyProperties(p, entity); // Copies properties from Product to ProductEntity
	        
	        // Save the product entity in the repository
	        repository.save(entity);
	        
	        // Optionally print the product to the console (for debugging purposes)
	        System.out.println(p); // This could be useful to check the submitted Product data
	    }
	    
	    // Return to the form page after processing
	    return "index";
	}
}
