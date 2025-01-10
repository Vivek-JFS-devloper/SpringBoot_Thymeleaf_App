package in.ramesh.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.ramesh.binding.Product;
import in.ramesh.entity.ProductEntity;
import in.ramesh.repository.ProdectRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProdectRepository repository;
	
	//method to display form
	@RequestMapping("/")
	public String loadForm(Model model) {
		
		model.addAttribute("product", new Product());
		
		return "index";
	}
	
	//method to handle form submision
	@PostMapping("/product")
	public String handleSubmissionBtn(Product p ,Model model) {
		model.addAttribute("sms", "save Product data!");
		ProductEntity entity = new ProductEntity();
		BeanUtils.copyProperties(p, entity);
		repository.save(entity);
		System.out.println(p);
		return "index";
	}
}
