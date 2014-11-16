package org.goja.tracker.controller;

import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.goja.tracker.dto.ActorDto;
import org.goja.tracker.framework.AbstractController;
import org.goja.tracker.model.Actor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/actor")
public class ActorController extends AbstractController {

	protected static final Logger logger = Logger.getLogger(ActorController.class);

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public String findAll(Map<String, Object> model) {
		logger.info("*********** delegating to service");
		model.put("actors", actorService.findAll());
		model.put("actor", new ActorDto());
		return "actor";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id) {
		logger.info("Deleting actor with id : " + id);
		actorService.delete(id);
		return "redirect:/actor/findAll";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(Map<String, Object> model, @PathVariable Long id) {
		Actor actor = actorService.findOne(id);
		model.put("actors", actorService.findAll());
		model.put("actor", dozerBeanMapper.map(actor, ActorDto.class));
		return "actor";
	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
	public String deleteAll() {
		logger.info("DELETING ALL ACTORS");
		actorService.deleteAll();
		return "redirect:/actor/findAll";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Map<String, Object> model, @Valid @ModelAttribute("actor") ActorDto actorDto,
			BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			Actor actor = null;
			if (actorDto.getId() == null) {
				actor = dozerBeanMapper.map(actorDto, Actor.class);
			} else {
				actor = actorService.findOne(actorDto.getId());
				dozerBeanMapper.map(actorDto, actor);
			}

			actorService.save(actor);
			return "redirect:/actor/findAll";
		}
		model.put("actors", actorService.findAll());
		return "actor";
	}
}
