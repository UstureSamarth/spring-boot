package in.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.app.model.User;
import in.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;

	@GetMapping("/register")
	public String showRegistrationPage(@ModelAttribute("userInfo") User user) {
		return "user_register";
	}

	@PostMapping("/register")
	public String registerUser(@ModelAttribute("userInfo") User user, Map<String, Object> model) {
		String msg = service.register(user);

		model.put("message", msg);

		return "user_registered_success";
	}
	
	@GetMapping("/showLogin")
	public String showLoginPage() {
		return "custom_login";
	}
	
	@PostMapping("/login")
	public String loginPage() {
		return "custom_login";
	}
}
