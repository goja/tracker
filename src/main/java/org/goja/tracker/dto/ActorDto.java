package org.goja.tracker.dto;

import org.goja.tracker.framework.AbstractDto;
import org.goja.tracker.model.Actor;
import org.hibernate.validator.constraints.NotBlank;

public class ActorDto extends AbstractDto {

	@NotBlank(message = "{actor.userName.required}")
	private String userName;

	@NotBlank(message = "{actor.firstName.required}")
	private String firstName;

	@NotBlank(message = "{actor.lastName.required}")
	private String lastName;

	@NotBlank(message = "{actor.email.required}")
	private String email;

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

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj instanceof Actor) {
			return this.getId().equals(((Actor) obj).getId());
		} else if (obj instanceof Long) {
			return this.getId().equals((Long) obj);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.getId() == null ? 0 : this.getId().hashCode();
	}

}
