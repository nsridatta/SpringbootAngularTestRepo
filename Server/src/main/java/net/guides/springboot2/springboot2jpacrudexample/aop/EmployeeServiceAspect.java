package net.guides.springboot2.springboot2jpacrudexample.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.hibernate.mapping.Join;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

@Aspect
@Component
public class EmployeeServiceAspect {

    Logger log = LoggerFactory.getLogger(getClass());
    /*
    @Before(value = "execution(* net.guides.springboot2.springboot2jpacrudexample.*.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        log.info("Before method:" + joinPoint.getSignature());

    }

    @After(value = "execution(* net.guides.springboot2.springboot2jpacrudexample.*.*.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        log.info("After method:" + joinPoint.getSignature());

    }*/


    @Pointcut(value="execution(* net.guides.springboot2.springboot2jpacrudexample.*.*.*(..))")
    public void myPointcut() {

    }

    @Around("myPointcut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        Object[] array = pjp.getArgs();
        log.info("Class Invoked:= " + className + " : Method Name:= " + methodName + "(); " + " Arguments:= "
                + mapper.writeValueAsString(array));
        Object object = pjp.proceed();
        log.info("Class Name:= "+ className + " Method Name:= " + methodName + " (); " + " Response:= "
                + mapper.writeValueAsString(object));
        return object;
    }

    @AfterThrowing(pointcut = "execution(* net.guides.springboot2.springboot2jpacrudexample.*.*.*(..))", throwing = "ex")
    public void logError(JoinPoint joinPoint, Exception ex) {
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        String stuff = signature.toString();
        String arguments = Arrays.toString(joinPoint.getArgs());

        log.error("Exception was caught in method: "+ methodName+ " with arguments "+arguments
                +"\nand the full toString: " + stuff + "\nthe exception is: "
                + ex.getMessage());
    }
}
