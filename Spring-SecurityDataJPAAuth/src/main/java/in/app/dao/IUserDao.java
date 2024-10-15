package in.app.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import in.app.model.User;


public interface IUserDao extends CrudRepository<User, Integer> {
	Optional<User> findByUsername(String username);
}
