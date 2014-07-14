package org.goja.tracker.dto;

import java.util.Date;

import org.goja.tracker.model.Actor;
import org.goja.tracker.util.Priority;
import org.goja.tracker.util.Status;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class TicketDto {

	private Priority priority;

	private Status status;

	private Actor reporter;

	private Actor assignee;

	private String summary;

	@DateTimeFormat(iso = ISO.DATE)
	private Date due;

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

	public Date getDue() {
		return due;
	}

	public void setDue(Date due) {
		this.due = due;
	}
}
