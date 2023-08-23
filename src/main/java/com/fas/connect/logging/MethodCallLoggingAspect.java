package com.fas.connect.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodCallLoggingAspect {
	private final Logger logger = LoggerFactory.getLogger(MethodCallLoggingAspect.class);

    @Before("execution(* com.fas.connect.controller..*(..)) || execution(* com.fas.connect.service..*(..))")
    public void logBeforeMethodCall(JoinPoint joinPoint) {
        logger.info("Method called: {}", joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "execution(* com.fas.connect.controller..*(..)) || execution(* com.fas.connect.service..*(..))",
                    returning = "result")
    public void logAfterMethodCall(JoinPoint joinPoint, Object result) {
        logger.info("Method completed: {}. Result: {}", joinPoint.getSignature(), result);
    }
}