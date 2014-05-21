package org.goja.tracker.controller;

import java.util.Map;

import javax.inject.Inject;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.goja.tracker.model.User;
import org.goja.tracker.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

	private Logger logger = Logger.getLogger(UserController.class);

	@Inject
	private UserService userService;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public String findAll(Map<String, Object> model) {
		model.put("users", userService.findAll());
		model.put("user", new User());
		return "user";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id) {
		logger.info("Deleting user with id : " + id);
		userService.delete(id);
		return "redirect:/user/findAll";
	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
	public String deleteAll() {
		logger.info("DELETING ALL USERS");
		userService.deleteAll();
		return "redirect:/user/findAll";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Map<String, Object> model, @Valid @ModelAttribute("user") User user, 
			BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			logger.info("Saving user : " + user);
			userService.save(user);
			return "redirect:/user/findAll";
		}
		model.put("users", userService.findAll());
		return "user";
	}
}
