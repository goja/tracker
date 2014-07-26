package org.goja.tracker.dto;

import org.goja.tracker.framework.AbstractDto;
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

}
