package com.eugene.spring.boot.EgWeb.impl.aop.restapi;

import org.springframework.web.bind.annotation.*;

public interface EgRestApiImpl {
    @GetMapping
    @ResponseStatus
    String getData() throws Exception;

    @PostMapping
    @ResponseStatus
    String postData();

    @PutMapping
    @ResponseStatus
    String putData();

    @DeleteMapping
    @ResponseStatus
    String deleteData();
}
