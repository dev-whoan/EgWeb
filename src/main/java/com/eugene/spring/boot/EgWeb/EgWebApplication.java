package com.eugene.spring.boot.EgWeb;

import com.eugene.spring.boot.EgWeb.config.EgYamlReader;
import com.eugene.spring.boot.EgWeb.config.setting.EgBaseSettingReader;
import com.eugene.spring.boot.EgWeb.impl.aop.config.EgYamlReaderImpl;
import com.eugene.spring.boot.EgWeb.proxy.EgProxyWorker;
import com.eugene.spring.boot.EgWeb.proxy.advice.ExceptionThrowAdvice;
import com.eugene.spring.boot.EgWeb.proxy.advice.log.AroundAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EgWebApplication implements CommandLineRunner {
	@Autowired
	EgYamlReader eyr;
	public static void main(String[] args) throws Exception {
		SpringApplication.run(EgWebApplication.class, args);

		//base config reader
		EgYamlReaderImpl egBaseSettingReader = EgBaseSettingReader.getInstance();
		loadConfigs(egBaseSettingReader);
	}

	@Override
	public void run(String... args) {
		eyr.refresh();
	}

	private static void loadConfigs(EgYamlReaderImpl _reader) throws Exception{
		EgProxyWorker<EgYamlReaderImpl> proxy = new EgProxyWorker<>(_reader, "refresh", null);
		proxy.addAdvice(new AroundAdvice()).addAdvice(new ExceptionThrowAdvice()).setInterface(EgYamlReaderImpl.class);
		proxy.doTask();
	}
}
