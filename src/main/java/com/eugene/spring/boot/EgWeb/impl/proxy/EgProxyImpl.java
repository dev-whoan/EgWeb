package com.eugene.spring.boot.EgWeb.impl.proxy;

import org.aopalliance.aop.Advice;

public interface EgProxyImpl<T> {
    boolean isProxyValid();
    boolean isInterfaceSet();
    EgProxyImpl<T> addAdvice(Advice advice);
    Object doTask() throws Exception;
    EgProxyImpl<T> createProxyFactoryBean();
    EgProxyImpl<T> resetProxyFactoryBean();
    EgProxyImpl<T> setArguments(Object...args);
    EgProxyImpl<T> setMainObject(T mainObject);
    EgProxyImpl<T> setMethod() throws NoSuchMethodException;
    EgProxyImpl<T> setMethodName(String methodName);
    EgProxyImpl<T> setParameterTypes(Class<?>[] parameterTypes);
    EgProxyImpl<T> setInterface(Class ifc);
}
