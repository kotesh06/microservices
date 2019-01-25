package com.kotesh.departmentdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DepartmentDemoApllication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentDemoApllication.class, args);
	}
}
