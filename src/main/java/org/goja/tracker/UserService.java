package org.goja.tracker;

import java.util.List;

public interface UserService {

	List<User> findAll();

	void save(User user);

	void delete(Long id);

	void deleteAll();

}
