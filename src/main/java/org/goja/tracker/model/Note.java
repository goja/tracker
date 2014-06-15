package org.goja.tracker.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.goja.tracker.framework.AbstractEntity;

@Entity
public class Note extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 8808405428457396015L;

	@ManyToOne
	private Ticket ticket;

	@OneToOne
	private User user;

	private String description;

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

		public NoteBuilder withUser(User user) {
			note.user = user;
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
