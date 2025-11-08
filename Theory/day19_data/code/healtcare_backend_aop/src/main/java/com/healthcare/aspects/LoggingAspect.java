package com.healthcare.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
/*
 * Log every incoming request to this Backend app
 */
@Aspect
@Component
@Slf4j
public class LoggingAspect {
	@Before("execution (* com.healthcare.controller.*.*(..))")
	public void startLogging(JoinPoint joinPoint) {
		System.out.println("in before advice.....");
		log.debug("Logging every incoming request here -" + joinPoint);
	}

}
