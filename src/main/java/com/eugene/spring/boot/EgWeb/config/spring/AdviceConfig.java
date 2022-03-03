package com.eugene.spring.boot.EgWeb.config.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= "com.eugene.spring.boot.EgWeb.proxy.advice")
public class AdviceConfig {

}
