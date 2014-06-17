package org.goja.tracker.dto;

import java.io.Serializable;

import org.goja.tracker.util.Priority;
import org.goja.tracker.util.Status;

import com.google.common.base.Objects;

public class SummaryDto implements Serializable {

	private static final long serialVersionUID = 8300405118943847506L;
	private String summary;
	private String reporter;
	private String assignee;
	private Priority priority;
	private Status status;

	public SummaryDto(Priority priority, Status status, String summary, String reporter, String assignee) {
		this.priority = priority;
		this.status = status;
		this.summary = summary;
		this.reporter = reporter;
		this.assignee = assignee;
	}

	public String getSummary() {
		return summary;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}



	public String toString() {
		return Objects.toStringHelper(getClass()).add("priority", priority).add("status", status)
				.add("summary", summary).add("reporter", reporter).add("assignee", assignee)
				.toString();
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

}
