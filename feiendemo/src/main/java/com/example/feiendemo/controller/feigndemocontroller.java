package com.example.feiendemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.feiendemo.model.DeptModel;

@RestController
@RequestMapping("/feign")
public class feigndemocontroller {
	@Autowired
	DepartmentProxyService proxy;
	
	@GetMapping("/test")
	public String hello() {
		return "Hello Feign client demo";
	}
	
	@GetMapping("/dept")
	public List<DeptModel> getDeparments() {
		return proxy.getAllDeptDetails();
	}

	

}
