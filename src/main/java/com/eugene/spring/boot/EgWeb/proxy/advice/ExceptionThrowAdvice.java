package com.eugene.spring.boot.EgWeb.proxy.advice;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Service;

@Service
public class ExceptionThrowAdvice implements ThrowsAdvice {
    public void afterThrowing(Exception se) throws Throwable{
        //log
        se.printStackTrace();
    }
}
