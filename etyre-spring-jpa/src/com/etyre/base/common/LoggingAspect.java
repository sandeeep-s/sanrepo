package com.etyre.base.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

	public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {

		String traceString = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()+"()";

		Object returnValue = null;
		try {
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("entering " + traceString);
			}


			returnValue = joinPoint.proceed();

			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("exiting " + traceString);
			}
		} catch (Throwable e) {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error(e.getMessage(), e);
			}
			throw e;
		}

		return returnValue;
	}

	// before the execution of any method with any number and type of parameters
	public void logDebugBeforeMethod(JoinPoint joinPoint) {
		if (LOGGER.isDebugEnabled()) {
			// constructing a string of the method signature, method and
			// parameters
			String traceString = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "(";
			Object[] args = joinPoint.getArgs();
			for (int i = 0; i < args.length; i++) {
				if (args[i] != null) {
					traceString += args[i];
				} else {
					traceString += "null";
				}
				if (i < (args.length - 1)) {
					traceString += ", ";
				}
			}
			traceString += ")";
			LOGGER.debug(traceString);
		}
	}
}
