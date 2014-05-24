package org.goja.tracker.model;

import java.io.Serializable;
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
public class Ticket extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 6232235360983944420L;

	@Enumerated(value = EnumType.STRING)
	private Priority priority;

	@Enumerated(value = EnumType.STRING)
	private Status status;

	@OneToOne
	private User reporter;

	@OneToOne
	private User assignee;

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

	public User getReporter() {
		return reporter;
	}

	public void setReporter(User reporter) {
		this.reporter = reporter;
	}

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
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
}
