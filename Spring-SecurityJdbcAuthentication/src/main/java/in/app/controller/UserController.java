package in.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

	@GetMapping("/")
	public String welcome() {
		return "<h1>Welcome to home page</h1>";
	}

	@GetMapping("/admin")
	public String admin() {
		return "<h1>Welcome Admin</h1>";
	}

	@GetMapping("/user")
	public String user() {
		return "<h1>Welcome User</h1>";
	}

}
