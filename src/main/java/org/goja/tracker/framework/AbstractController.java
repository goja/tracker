package org.goja.tracker.framework;

import java.beans.PropertyEditorSupport;

import javax.inject.Inject;

import org.dozer.DozerBeanMapper;
import org.goja.tracker.dto.ActorDto;
import org.goja.tracker.model.Actor;
import org.goja.tracker.service.ActorService;
import org.goja.tracker.service.NoteService;
import org.goja.tracker.service.TicketService;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

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

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(ActorDto.class, "assignee", new ActorDtoPropertyEditorSupport(actorService,
				dozerBeanMapper));
		binder.registerCustomEditor(ActorDto.class, "reporter", new ActorDtoPropertyEditorSupport(actorService,
				dozerBeanMapper));
	}

	public static class ActorDtoPropertyEditorSupport extends PropertyEditorSupport {
		private ActorService actorService;
		private DozerBeanMapper beanMapper;

		public ActorDtoPropertyEditorSupport(ActorService actorService, DozerBeanMapper beanMapper) {
			this.actorService = actorService;
			this.beanMapper = beanMapper;
		}

		@Override
		public void setAsText(String id) throws IllegalArgumentException {
			final Actor actor = actorService.findOne(Long.parseLong(id));
			final ActorDto actorDto = beanMapper.map(actor, ActorDto.class);
			setValue(actorDto);
		}
	}
}
