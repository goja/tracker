package org.goja.tracker.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.goja.tracker.framework.AbstractEntity;

@Entity
public class Note extends AbstractEntity {

	private static final long serialVersionUID = 8808405428457396015L;

	@ManyToOne
	private Ticket ticket;

	@OneToOne
	private Actor actor;

	private String description;

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public static class NoteBuilder {
		private Note note;

		public NoteBuilder() {
			note = new Note();
		}

		public NoteBuilder withDescription(String description) {
			note.description = description;
			return this;
		}

		public NoteBuilder withTicket(Ticket ticket) {
			note.ticket = ticket;
			return this;
		}

		public NoteBuilder withActor(Actor actor) {
			note.setActor(actor);
			return this;
		}

		public static NoteBuilder note() {
			return new NoteBuilder();
		}

		public Note build() {
			return note;
		}
	}

}
