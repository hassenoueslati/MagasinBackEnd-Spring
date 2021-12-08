package tn.esprit.spring.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

public class LoggingAspect {
    private static final Logger l = LogManager.getLogger(LoggingAspect.class);

    @Before("execution(* tn.esprit.spring.service.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        l.info("In method " + name + " : ");
    }
}
