package org.sample.foo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

	private static int MAX_LENGTH = 4;

	@Around("this(org.slf4j.Logger)")
	public void enhance(ProceedingJoinPoint pjp) throws Throwable {
		Logger logger = (Logger) pjp.getTarget();

		Object[] args = pjp.getArgs();
		if (args.length > 0) {
			String message = (String) args[0];
			if (message.length() > MAX_LENGTH) {
				logger.warn(logger.getName() + " produced too long message");
				Object[] modifiedArgs = new Object[args.length];
				System.arraycopy(args, 1, modifiedArgs, 1, args.length - 1);
				modifiedArgs[0] = message.subSequence(0, MAX_LENGTH);
				pjp.proceed(modifiedArgs);
			} else {
				pjp.proceed(args);

			}
		}

	}
}
