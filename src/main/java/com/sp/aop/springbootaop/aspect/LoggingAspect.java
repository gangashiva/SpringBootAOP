package com.sp.aop.springbootaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
//@Configurable
@Component
public class LoggingAspect {


  @Before("businessService()")
  public void logBefore(JoinPoint joinPoint) {
    System.out.println("logBefore() is running..!");
    System.out.println("hijacked: " + joinPoint.getSignature().getName());
    System.out.println("**********************************************");
  }

  @After("execution(* com.sp.aop.springbootaop.service.impl.CustomerServiceImpl.addCustomer(..))")
  public void logAfter(JoinPoint joinPoint) {
    System.out.println("logAfter() is running..!");
    System.out.println("hijacked: " + joinPoint.getSignature().getName());
    System.out.println("**********************************************");
  }

  @AfterReturning(
      pointcut = "execution(* com.sp.aop.springbootaop.service.impl.CustomerServiceImpl.addCustReturnedValue())",
      returning = "result")
  public void logReturnning(JoinPoint joinPoint, Object result) {
    System.out.println("logReturnning() is running..!");
    System.out.println("hijacked: " + joinPoint.getSignature().getName());
    System.out.println("Method returned value: "+result);
    System.out.println("**********************************************");
  }

  @AfterThrowing(
      pointcut = "execution(* com.sp.aop.springbootaop.service.impl.CustomerServiceImpl.addCustReturnedValue())",
      throwing = "error")
  public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
    System.out.println("logAfterThrowing() is running..!");
    System.out.println("hijacked: " + joinPoint.getSignature().getName());
    System.out.println("Exception: "+error);
    System.out.println("**********************************************");
  }
@Around("execution(* com.sp.aop.springbootaop.service.impl.CustomerServiceImpl.addCustomerAround(..))")
  public void logAround(ProceedingJoinPoint pjp) throws Throwable {
    System.out.println("logAround() is running..!");
    System.out.println("hijacked: " + pjp.getSignature().getName());
    System.out.println("Hijacked args: "+Arrays.toString(pjp.getArgs()));
    System.out.println("Around Before is running...! ");
    pjp.proceed();
    System.out.println("Around After is running...! ");
    System.out.println("**********************************************");
  }

  @Pointcut("execution(* com.sp.aop.springbootaop.service.impl.CustomerServiceImpl.addCustomer(..))")
  public void businessService(){

  }
}