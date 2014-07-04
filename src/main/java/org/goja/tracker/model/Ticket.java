package org.goja.tracker.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.goja.tracker.framework.AbstractEntity;
import org.goja.tracker.util.Priority;
import org.goja.tracker.util.Status;

@Entity
public class Ticket extends AbstractEntity {

	private static final long serialVersionUID = -8780970420284463018L;

	@Enumerated(value = EnumType.STRING)
	private Priority priority;

	@Enumerated(value = EnumType.STRING)
	private Status status;

	@OneToOne
	private Actor reporter;

	@OneToOne
	private Actor assignee;

	private String summary;

	@OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Note> notes;

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Actor getReporter() {
		return reporter;
	}

	public void setReporter(Actor reporter) {
		this.reporter = reporter;
	}

	public Actor getAssignee() {
		return assignee;
	}

	public void setAssignee(Actor assignee) {
		this.assignee = assignee;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public String toString() {
		return summary;
	}
}
