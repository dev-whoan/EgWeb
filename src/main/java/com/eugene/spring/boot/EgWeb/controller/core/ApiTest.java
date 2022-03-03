package com.eugene.spring.boot.EgWeb.controller.core;

import com.eugene.spring.boot.EgWeb.impl.aop.restapi.EgRestApiImpl;
import org.springframework.stereotype.Service;

@Service
public class ApiTest implements EgRestApiImpl {
    public String getData() throws Exception {
        return "{\"result\":\"OK\"}";
    }

    public String postData() {
        return null;
    }

    public String putData() {
        return null;
    }

    public String deleteData() {
        return null;
    }
}
