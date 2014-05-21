package org.goja.tracker.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.goja.tracker.model.User;
import org.goja.tracker.repository.UserRepository;
import org.goja.tracker.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public void save(User user) {
		userRepository.saveAndFlush(user);
	}

	public void delete(Long id) {
		userRepository.delete(id);
	}

	public void deleteAll() {
		userRepository.deleteAll();
	}

}
