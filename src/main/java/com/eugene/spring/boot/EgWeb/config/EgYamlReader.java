package com.eugene.spring.boot.EgWeb.config;

import com.eugene.spring.boot.EgWeb.impl.aop.config.EgYamlReaderImpl;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ConfigurationProperties("configs")
@Service
public class EgYamlReader implements EgYamlReaderImpl {
    private static final HashMap<String, String> configs = new HashMap<>();
    private List<HashMap<String, String>> paths;

    public void setPaths(List<HashMap<String, String>> paths) {
        this.paths = paths;
    }

    public void refresh(){
        configs.clear();
        for(HashMap<String, String> path : paths){
            System.out.println("path: " + path);
            configs.putAll(path);
        }

    }

    @Override
    public Map<String, Object> get(String key) {
        return null;
    }

    public static String getInfo(String key){
        return configs.get(key);
    }
}
