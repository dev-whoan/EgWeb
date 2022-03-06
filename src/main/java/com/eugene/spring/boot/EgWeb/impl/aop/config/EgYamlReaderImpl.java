package com.eugene.spring.boot.EgWeb.impl.aop.config;

import java.io.IOException;
import java.util.Map;

public interface EgYamlReaderImpl {
    void refresh() throws IOException;
    Map<String, Object> get(String key);
}
