package in.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("/offers")
	public String showOffers() {
		return "offers";
	}

	@GetMapping("/balance")
	public String showBalance() {
		return "balance";
	}

	@GetMapping("/loanapprove")
	public String approveLoan() {
		return "loanapprove";
	}

	@GetMapping("/denied")
	public String accessdenied() {
		return "denied";
	}
}
