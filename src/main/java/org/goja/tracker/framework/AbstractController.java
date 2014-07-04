package org.goja.tracker.framework;

import javax.inject.Inject;

import org.springframework.context.MessageSource;

public abstract class AbstractController {

	@Inject
	protected MessageSource messageSource;
}
