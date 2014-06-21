package org.goja.tracker.controller;

import java.util.Map;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.goja.tracker.model.Note;
import org.goja.tracker.model.Ticket;
import org.goja.tracker.service.ActorService;
import org.goja.tracker.service.NoteService;
import org.goja.tracker.service.TicketService;
import org.goja.tracker.util.Priority;
import org.goja.tracker.util.Status;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ticket")
public class TicketController {

	protected static Logger logger = Logger.getLogger(TicketController.class);

	@Inject
	private ActorService actorService;

	@Inject
	private TicketService ticketService;

	@Inject
	private NoteService noteService;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public String findAll(Map<String, Object> model) {
		model.put("tickets", ticketService.findAll());
		model.put("ticket", new Ticket());
		model.put("actors", actorService.findAll());
		model.put("priority", Priority.values());
		model.put("status", Status.values());
		logger.info("********* " + ticketService.displaySummary());
		return "ticket";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Map<String, Object> model, @ModelAttribute("ticket") Ticket ticket,
			@RequestParam("note") String description) {
		logger.info("Saving ticket : " + ticket);
		ticketService.save(ticket);
		final Note note = Note.NoteBuilder.note().withDescription(description).withTicket(ticket)
				.withActor(ticket.getReporter())
				.build();
		noteService.save(note);
		return "redirect:/ticket/findAll";
	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
	public String deleteAll() {
		logger.info("DELETING ALL TICKETS");
		ticketService.deleteAll();
		return "redirect:/ticket/findAll";
	}

}
