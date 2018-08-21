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

    //@Pointcut("execution(* com.step.demo.spring5.UserService.sayHello(..))")
    public void pointCut(){
        System.out.printf("%s\n" ,"Pointcut" );
    }

    //@Before("pointCut()")
    @Before("execution(* com.step.demo.spring5.UserService.*(..))")
    public void before(){
        System.out.printf("%s\n" ,"before" );
    }

    @Before("execution(* com.step.demo.spring5.UserService.sayHI(..))")
    public void pointCut2(){
        System.out.printf("%s\n" ,"Pointcut2" );
    }

}
