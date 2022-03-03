package com.eugene.spring.boot.EgWeb.proxy;

import com.eugene.spring.boot.EgWeb.impl.proxy.EgProxyImpl;
import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactoryBean;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class EgProxyWorker<T> implements EgProxyImpl<T> {
    ProxyFactoryBean proxy;
    //설정해야 하는 것
    T mainObject;
    String methodName;
    Class<?>[] parameterTypes;
    Object[] args;

    List<Advice> advices;
    Class<T> clazz;
    Class ifc;
    Method method;

    public EgProxyWorker(){}

    public EgProxyWorker(T mainObject, String methodName, Class<?>[] parameterTypes) throws NoSuchMethodException {
        setMainObject(mainObject);
        setMethodName(methodName);
        setParameterTypes(parameterTypes);
        setMethod();
        createProxyFactoryBean();
    }

    @Override
    public EgProxyImpl<T> setMainObject(T mainObject) {
        this.mainObject = mainObject;
        clazz = (Class<T>) mainObject.getClass();
        return this;
    }

    @Override
    public EgProxyImpl<T> setMethod() throws NoSuchMethodException {
        method = clazz.getMethod(methodName, parameterTypes);
        return this;
    }

    @Override
    public EgProxyImpl<T> setMethodName(String methodName) {
        this.methodName = methodName;
        return this;
    }

    @Override
    public EgProxyImpl<T> setParameterTypes(Class<?>[] parameterTypes) {
        if(parameterTypes == null)
            return this;

        this.parameterTypes = parameterTypes;
        return this;
    }

    @Override
    public boolean isProxyValid(){
        return proxy != null;
    }

    @Override
    public boolean isInterfaceSet(){
        return ifc != null;
    }

    @Override
    public EgProxyImpl<T> createProxyFactoryBean() {
        proxy = new ProxyFactoryBean();
        return this;
    }

    @Override
    public EgProxyImpl<T> resetProxyFactoryBean(){
        return createProxyFactoryBean();
    }

    @Override
    public EgProxyImpl<T> setArguments(Object... args) {
        this.args = args;
        return this;
    }

    @Override
    public EgProxyImpl<T> addAdvice(Advice advice) {
        if(!isProxyValid())
            createProxyFactoryBean();
        if(advices == null)
            advices = new ArrayList<>();
//        proxy.addAdvice(advice);
        advices.add(advice);

        return this;
    }

    private void setAdvices(Advised proxy){
        for(Advice adv : advices){
            proxy.addAdvice(adv);
        }
    }

    @SuppressWarnings({"unchekced"})
    @Override
    public Object doTask() throws Exception {
        if(!isProxyValid())
            throw new NullPointerException("No proxy bean initialized.");
        if(!isInterfaceSet())
            throw new NullPointerException("No interface has set. You have to use `Interface` instead of `Class`");
        if(method == null)
            setMethod();

        proxy.setTarget(mainObject);
        setAdvices(proxy);
        Object obj = proxy.getObject();
        method = ifc.getMethod(methodName, parameterTypes);
        return method.invoke(obj, args);
    }

    @Override
    public EgProxyImpl<T> setInterface(Class ifc){
        this.ifc = ifc;
        return this;
    }
}

