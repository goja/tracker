package org.goja.tracker.dto;

import org.goja.tracker.model.Actor;
import org.goja.tracker.util.Priority;
import org.goja.tracker.util.Status;

public class TicketDto {

	private Priority priority;

	private Status status;

	private Actor reporter;

	private Actor assignee;

	private String summary;

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
}
