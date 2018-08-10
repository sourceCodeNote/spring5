package com.step.demo.spring;

import java.util.Arrays;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Advice
 * before after around 的实现
 * **/
public class SayImplAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		/** 前置处理入参 **/
		befor(invocation.getArguments());
		/** 最关键的一步 **/
		Object result = invocation.proceed();
		/** 后置处理返回 **/
		after(result);
		return result;
	}
	
	public void befor(Object[] params) {
		System.out.println("i am ar before!");
		List<Object> list = Arrays.asList(params);
		list.forEach(e->System.out.println("params:"+e));
	}
	
	public void after(Object result) {
		System.out.println("i am ar after!\nresult is "+result);
	}

}

