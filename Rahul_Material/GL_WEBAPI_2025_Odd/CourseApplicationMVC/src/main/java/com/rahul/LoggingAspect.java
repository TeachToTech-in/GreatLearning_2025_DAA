package com.rahul;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
	private Logger logger = LoggerFactory.getLogger(getClass());

	//@Before("execution(* com.rahul.Course*.*(..))")
	public void logMethodBeforeCall(JoinPoint joinPoint) {
		logger.info("Before log Executed {} ",joinPoint);
	}

	//@After("execution(* com.rahul.Course*.*(..))")
	public void logMethodAfterCall(JoinPoint joinPoint) {
		logger.info("After log Executed {} ",joinPoint);
	}
	
	//Write And Advice to Be Executed To calculate the 
	//Time Taken by a Method of Course Application
	@Around("execution(* com.rahul.CourseController.*(..))")
	public Object timetaken(ProceedingJoinPoint pjp )  throws Throwable{
		//hold the Start time
		long starttime =  System.currentTimeMillis();
		// to executed the target method 
		Object object = pjp.proceed();
		//hold the Stop time 
		long stoptime = System.currentTimeMillis();
		long elapsed = stoptime-starttime;
		logger.info("Time Elapsed {} ms by The Method {}",elapsed,pjp);
		
		return object;
	}
}
