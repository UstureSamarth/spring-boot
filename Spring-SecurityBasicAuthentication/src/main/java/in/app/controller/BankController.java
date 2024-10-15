package in.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bank")
public class BankController {

	@GetMapping("/")
	public String welcomePage() {
		return "Welcome";
	}
	
	@GetMapping("/transfer")
	public String PageTransfer() {
		return "Transfer";
	}
	
	@GetMapping("/balance")
	public String PageBalance() {
		return "Balance";
	}
	
	@GetMapping("/aboutus")
	public String PageAboutUs() {
		return "About Us";
	}
}
