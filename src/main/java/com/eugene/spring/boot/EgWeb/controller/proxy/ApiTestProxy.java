package com.eugene.spring.boot.EgWeb.controller.proxy;

import com.eugene.spring.boot.EgWeb.impl.aop.restapi.EgRestApiImpl;
import com.eugene.spring.boot.EgWeb.proxy.EgProxyWorker;
import com.eugene.spring.boot.EgWeb.proxy.advice.log.AroundAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiTestProxy {
    EgRestApiImpl apiTest;

    @Autowired
    public void setApiTest(EgRestApiImpl apiTest){
        this.apiTest = apiTest;
    }
    @GetMapping("/")
    public String getData() throws Exception {
        EgProxyWorker<EgRestApiImpl> proxy = new EgProxyWorker<>(apiTest, "getData", null);
        proxy.addAdvice(new AroundAdvice()).setInterface(EgRestApiImpl.class);
        String result = proxy.doTask().toString();
        System.out.println("What happens");
        return result;
    }
}
