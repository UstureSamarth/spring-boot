package in.app.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
public class BankOperationController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("/offers")
	public String showOffers() {
		return "offers";
	}

	@GetMapping("/balance")
	public String showBalance(Map<String, Object> model) {
		model.put("balance_amt", new Random().nextInt(10000));
		return "balance";
	}

	@GetMapping("/loanApprove")
	public String approveLoan(Map<String, Object> model) {
		model.put("amount", new Random().nextInt(1000));
		return "loan";
	}

	@GetMapping("/denied")
	public String accessdenied(Map<String, Object> model) {
		model.put("username", SecurityContextHolder.getContext().getAuthentication().getName());
		return "access_denied";
	}
}
