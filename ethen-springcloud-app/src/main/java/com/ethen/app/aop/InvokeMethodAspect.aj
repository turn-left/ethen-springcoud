package com.ethen.app.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class InvokeMethodAspect {

    @Pointcut("execution(** com.ethen.app.service.UserService.listUserByIdRange(..))")
    public void performance() {
    }

    @Before("performance()")
    public void before() {
        System.err.println("invoke method aspect start...");
    }

    @After("performance()")
    public void after() {
        System.err.println("invoke method aspect end...");
    }
}
