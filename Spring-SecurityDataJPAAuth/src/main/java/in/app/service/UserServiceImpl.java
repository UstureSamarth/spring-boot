package in.app.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.app.dao.IUserDao;
import in.app.model.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optional = dao.findByUsername(username);
		if (optional.isEmpty()) {
			throw new IllegalArgumentException("user not found");
		}

		User details = optional.get();

		return new org.springframework.security.core.userdetails.User(details.getUsername(), details.getPassword(),
				details.getRoles().stream().map(
						role ->
				new SimpleGrantedAuthority(role))
				.collect(Collectors.toSet()));

	}

	@Override
	public String register(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setMail(encoder.encode(user.getMail()));

		return dao.save(user).getUid() + " UserId Registered";
	}

}
