package org.goja.tracker.util;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audit {

	protected final static Logger logger = Logger.getLogger(Audit.class);
	
	@Pointcut("within(org.goja.tracker..*)")
	public void allMethods() {
	}

	@After("org.goja.tracker.util.Audit.allMethods()")
	public void logTrail(JoinPoint jp) {
		logger.info(jp.toString());
		
	}
	
}
