package org.goja.tracker.framework;

import javax.inject.Inject;

import org.dozer.DozerBeanMapper;
import org.goja.tracker.service.ActorService;
import org.goja.tracker.service.NoteService;
import org.goja.tracker.service.TicketService;
import org.springframework.context.MessageSource;

public abstract class AbstractController {

	@Inject
	protected MessageSource messageSource;

	@Inject
	protected DozerBeanMapper dozerBeanMapper;

	@Inject
	protected ActorService actorService;

	@Inject
	protected TicketService ticketService;

	@Inject
	protected NoteService noteService;
}
