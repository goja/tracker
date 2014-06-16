package org.goja.tracker.service;

import java.util.List;

import org.goja.tracker.model.User;

public interface UserService {

	List<User> findAll();

	List<User> findAllOrderByName();

	void save(User user);

	void delete(Long id);

	void deleteAll();

}
