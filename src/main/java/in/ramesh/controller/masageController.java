package in.ramesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class masageController {
	
	@GetMapping("/")
	public String welcomeMasage(Model model) {
		model.addAttribute("sms", "Welcome to you");
		return "index";
	}
}
