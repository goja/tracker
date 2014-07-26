package org.goja.tracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.goja.tracker.framework.AbstractEntity;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Actor extends AbstractEntity {

	private static final long serialVersionUID = 2159421639680213971L;

	@Column(unique = true)
	@NotBlank(message = "{actor.userName.required}")
	private String userName;

	@NotBlank(message = "{actor.firstName.required}")
	private String firstName;

	@NotBlank(message = "{actor.lastName.required}")
	private String lastName;

	@NotBlank(message = "{actor.email.required}")
	private String email;

	public String toString() {
		return userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
