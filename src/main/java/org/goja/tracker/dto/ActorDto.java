package org.goja.tracker.dto;

import org.goja.tracker.framework.AbstractDto;
import org.hibernate.validator.constraints.NotBlank;

public class ActorDto extends AbstractDto {

	@NotBlank(message = "{actor.name.required}")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
