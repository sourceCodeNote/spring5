package com.step.demo.spring5.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component(value = "aspectTransaction")
public class AspectTransaction {

    public AspectTransaction() {
        System.err.printf("%s\n" , "AspectTransaction construct");
    }

    @Pointcut("execution(* com.step.demo.spring5.UserService.*(..))")
    public void pointCut(){
        System.out.printf("%s\n" ,"Pointcut" );
    }

    @Before("pointCut()")
    public void before(){
        System.out.printf("%s\n" ,"before" );
    }

}
