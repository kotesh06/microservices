package com.example.feiendemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeiendemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeiendemoApplication.class, args);
	}

}

