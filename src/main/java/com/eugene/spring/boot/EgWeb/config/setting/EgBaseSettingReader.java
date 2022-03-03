package com.eugene.spring.boot.EgWeb.config.setting;

import com.eugene.spring.boot.EgWeb.config.EgYamlReader;
import com.eugene.spring.boot.EgWeb.config.EgYamlReaderAbs;
import com.eugene.spring.boot.EgWeb.impl.aop.config.EgYamlReaderImpl;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class EgBaseSettingReader extends EgYamlReaderAbs implements EgYamlReaderImpl {
    private static final HashMap<String, Map<String, Object>> configs = new HashMap<>();
    private static File configFile;
    private static EgBaseSettingReader _instance;
    private static final ClassPathResource cpr = new ClassPathResource(EgYamlReader.get("egweb"));

    public EgBaseSettingReader() throws IOException {
        if(_instance == null){
            getInstance();
            refresh();
        }
    }

    public static EgBaseSettingReader getInstance(){
        if(_instance == null){
            _instance = new EgBaseSettingReader();
        }

        return _instance;
    }

    @Override
    private void refresh() throws IOException {
        configs.clear();

        lastModified = configFile.lastModified();

        InputStream inputStream = new FileInputStream(cpr.getFile());
        Yaml yaml = new Yaml();
        Map<String, Map<String, Object>> data = yaml.load(inputStream);
        System.out.println(data);
        Iterator<String> iter = data.keySet().iterator();
        while(iter.hasNext()){
            String key = iter.next();
            configs.put(key, data.get(key));
        }
    }

    @Override
    private boolean isFileModified() throws IOException {
        if(configFile == null){
            configFile = cpr.getFile();
        }

        return (configFile.lastModified() != lastModified);
    }

    @Override
    public Map<String, Object> get(String key){
        if(isFileModified()){
            refresh();
        }
    }
}
