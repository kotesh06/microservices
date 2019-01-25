package com.example.feiendemo.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.feiendemo.model.DeptModel;

@FeignClient(name="department-service")
public interface DepartmentProxyService {
	
	@RequestMapping("/dept-svc-test/department/{id}")
	public DeptModel getdeptDetails(@PathVariable(value="id") int id);
	
	@RequestMapping("/dept-svc-test/department")
	public List<DeptModel> getAllDeptDetails();

}
