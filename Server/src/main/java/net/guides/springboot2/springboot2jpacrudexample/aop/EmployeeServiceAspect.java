package net.guides.springboot2.springboot2jpacrudexample.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;


@Aspect
@Component
public class EmployeeServiceAspect {

    @Before(value = "execution(* net.guides.springboot2.springboot2jpacrudexample.*.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Before method:" + joinPoint.getSignature());


    }

    @After(value = "execution(* net.guides.springboot2.springboot2jpacrudexample.*.*.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("After method:" + joinPoint.getSignature());


    }
}
