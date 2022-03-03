package com.eugene.spring.boot.EgWeb.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@ConfigurationProperties("configs")
@Service
public class EgYamlReader {
    private static final HashMap<String, String> configs = new HashMap<>();
    private long lastmodified;
    private List<HashMap<String, String>> paths;

    public void setPaths(List<HashMap<String, String>> paths) {
        this.paths = paths;
    }

    public void refresh(){
        configs.clear();
        for(HashMap<String, String> path : paths){
            configs.putAll(path);
            System.out.println("path: " + path);
        }

    }

    public static String get(String key){
        return configs.get(key);
    }
}
