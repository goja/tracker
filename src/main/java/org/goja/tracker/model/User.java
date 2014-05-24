package org.goja.tracker.model;

import java.io.Serializable;

import javax.persistence.Entity;

import org.goja.tracker.framework.AbstractEntity;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class User extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 2159421639680213971L;

	@NotBlank(message = "Name is required")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

}
