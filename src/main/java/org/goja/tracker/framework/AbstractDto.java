package org.goja.tracker.framework;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class AbstractDto {

	protected Long id;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	protected Date created = new Date();

	@DateTimeFormat(iso = ISO.DATE_TIME)
	protected Date modified = new Date();

	protected Integer version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
