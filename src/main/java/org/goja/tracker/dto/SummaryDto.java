package org.goja.tracker.dto;

import java.io.Serializable;

import com.google.common.base.Objects;

public class SummaryDto implements Serializable {

	private static final long serialVersionUID = 8300405118943847506L;
	private String priority;
	private String status;
	private String summary;
	private String reporter;
	private String assignee;
	private String note;

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String toString() {
		return Objects.toStringHelper(getClass()).add("priority", priority).add("status", status)
				.add("summary", summary).add("reporter", reporter).add("assignee", assignee).add("note", note)
				.toString();
	}
}
