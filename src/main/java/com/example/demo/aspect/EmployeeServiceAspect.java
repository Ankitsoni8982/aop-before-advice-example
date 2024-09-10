package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceAspect {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceAspect.class);

    @Pointcut("execution(* com.example.demo.service.EmployeeService.getAllEmployees(..))")
    public void getAllEmployeesPointcut() {}

    @Around("getAllEmployeesPointcut()")
    public Object aroundGetAllEmployees(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Before executing method: {}", joinPoint.getSignature().getName());
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            logger.error("Exception in method: {}", joinPoint.getSignature().getName(), throwable);
            throw throwable; // Rethrow the exception
        }

        logger.info("After executing method: {}", joinPoint.getSignature().getName());
        return result;
    }
}
