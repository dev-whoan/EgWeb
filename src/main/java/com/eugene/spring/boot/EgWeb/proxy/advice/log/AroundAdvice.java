package com.eugene.spring.boot.EgWeb.proxy.advice.log;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Service;

@Service("logAroundAdvice")
public class AroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        // before
        System.out.printf("[(%s)::%s start]\n", invocation.getMethod().getDeclaringClass(), invocation.getMethod().getName());

        // Business
        Object result = invocation.proceed();
        // Business

        System.out.printf("[(%s)::%s end]\n", invocation.getMethod().getDeclaringClass(), invocation.getMethod().getName());
        // after
        return result;
    }
}
