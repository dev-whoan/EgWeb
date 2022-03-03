package com.eugene.spring.boot.EgWeb.config;

import com.eugene.spring.boot.EgWeb.impl.aop.config.EgYamlReaderImpl;
import org.springframework.stereotype.Service;

@Service
public abstract class EgYamlReaderAbs implements EgYamlReaderImpl {
    protected long lastModified;
    protected long[] lastModifieds[];
}
