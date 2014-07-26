package org.goja.tracker.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.goja.tracker.model.Actor;
import org.goja.tracker.repository.ActorRepository;
import org.goja.tracker.service.ActorService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceImpl implements ActorService {

	protected static final Logger logger = Logger.getLogger(ActorServiceImpl.class);

	@Inject
	private ActorRepository actorRepository;

	@PersistenceContext
	private EntityManager em;

	@Cacheable("tracker")
	public List<Actor> findAll() {
		logger.info("******************* hitting database now");
		return actorRepository.findAll();
	}

	@Cacheable("tracker")
	public Actor findOne(Long id) {
		logger.info("******************* hitting database now");
		return actorRepository.findOne(id);
	}

	@CacheEvict(value = "tracker", allEntries = true)
	public void save(Actor actor) {
		logger.info("******************* clearing cache");
		actorRepository.saveAndFlush(actor);
	}

	@CacheEvict(value = "tracker", allEntries = true)
	public void delete(Long id) {
		actorRepository.delete(id);
	}

	@CacheEvict(value = "tracker", allEntries = true)
	public void deleteAll() {
		actorRepository.deleteAll();
	}

	@Cacheable("tracker")
	public List<Actor> findAllOrderByUserName() {
		logger.info("*********** hitting database now");
		// return em.createNativeQuery("select * from User order by name desc",
		// org.goja.tracker.model.User.class)
		// .getResultList();
		return em.createQuery("from Actor order by userName").getResultList();
	}

}
