package org.goja.tracker.service;

import java.util.List;

import org.goja.tracker.model.Actor;

public interface ActorService {

	List<Actor> findAll();

	List<Actor> findAllOrderByUserName();

	Actor save(Actor actor);

	void delete(Long id);

	void deleteAll();

	Actor findOne(Long id);

}
