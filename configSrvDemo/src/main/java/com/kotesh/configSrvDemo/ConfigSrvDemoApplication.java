package com.kotesh.configSrvDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
@EnableConfigServer
@SpringBootApplication
public class ConfigSrvDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigSrvDemoApplication.class, args);
	}

}

