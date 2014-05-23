package org.goja.tracker.controller;

import java.util.Map;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.goja.tracker.model.Ticket;
import org.goja.tracker.service.TicketService;
import org.goja.tracker.service.UserService;
import org.goja.tracker.util.Priority;
import org.goja.tracker.util.Status;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ticket")
public class TicketController {

	protected static Logger logger = Logger.getLogger(TicketController.class);

	@Inject
	private UserService userService;

	@Inject
	private TicketService ticketService;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public String findAll(Map<String, Object> model) {
		model.put("tickets", ticketService.findAll());
		model.put("ticket", new Ticket());
		model.put("users", userService.findAll());
		model.put("priority", Priority.values());
		model.put("status", Status.values());
		return "ticket";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Map<String, Object> model, @ModelAttribute("ticket") Ticket ticket) {
		ticketService.save(ticket);
		return "redirect:/ticket/findAll";
	}

}
