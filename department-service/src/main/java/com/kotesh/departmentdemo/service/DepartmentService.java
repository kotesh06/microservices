package com.kotesh.departmentdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kotesh.departmentdemo.model.DepartmentDTO;


public interface DepartmentService {
	
	public DepartmentDTO getDeparmentDetails(int departmentId);
	
	public List<DepartmentDTO> getAllDeparmentDetails();

}
