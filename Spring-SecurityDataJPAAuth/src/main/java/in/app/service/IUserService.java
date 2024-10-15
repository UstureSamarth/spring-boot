package in.app.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import in.app.model.User;

public interface IUserService extends UserDetailsService {

	String register(User user);
}
