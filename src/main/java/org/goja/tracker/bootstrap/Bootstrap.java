package org.goja.tracker.bootstrap;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.goja.tracker.framework.AbstractController;
import org.goja.tracker.model.Actor;
import org.goja.tracker.model.Ticket;
import org.goja.tracker.util.Priority;
import org.goja.tracker.util.Status;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap extends AbstractController {

	@PostConstruct
	public void bootstrap() {
		Actor doug = null;
		Actor rich = null;
		Actor ilene = null;
		Actor sebastian = null;

		if (actorService.findAll().isEmpty()) {
			doug = createActor("doug.bailey@siemens.com", "doug", "bailey", "doug");
			rich = createActor("rich.channel@siemens.com", "rich", "channel", "rich");
			ilene = createActor("ilene.yost@siemens.com", "ilene", "yost", "ilene");
			sebastian = createActor("sebastian.hermida@siemens.com", "sebastian", "hermida", "sebastian");
		}
		if (ticketService.findAll().isEmpty()) {
			createTicket(new Date(), Priority.P2, Status.Open, "write code everyday", doug, rich);
			createTicket(new Date(), Priority.P3, Status.Closed, "focus is the key", sebastian, ilene);
			createTicket(new Date(), Priority.P1, Status.Testing, "set goals", rich, sebastian);
			createTicket(new Date(), Priority.P4, Status.Development, "be positive, have confidence", ilene, doug);
		}
	}

	private void createTicket(Date due, Priority priority, Status status, String summary, Actor assignee, Actor reporter) {
		ticketService.save(new Ticket(due, priority, status, summary, assignee, reporter));
	}

	private Actor createActor(String email, String firstName, String lastName, String username) {
		return actorService.save(new Actor(email, firstName, lastName, username));
	}
}
