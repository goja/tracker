package org.goja.tracker.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.goja.tracker.model.User;
import org.goja.tracker.repository.UserRepository;
import org.goja.tracker.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	protected static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Inject
	private UserRepository userRepository;

	@Cacheable("tracker")
	public List<User> findAll() {
		logger.info("******************* hitting database now");
		return userRepository.findAll();
	}

	@CacheEvict(value = "tracker", allEntries = true)
	public void save(User user) {
		logger.info("******************* clearing cache");
		userRepository.saveAndFlush(user);
	}

	@CacheEvict(value = "tracker", allEntries = true)
	public void delete(Long id) {
		userRepository.delete(id);
	}

	@CacheEvict(value = "tracker", allEntries = true)
	public void deleteAll() {
		userRepository.deleteAll();
	}

}
