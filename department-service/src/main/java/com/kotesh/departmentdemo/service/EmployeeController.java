package com.kotesh.departmentdemo.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kotesh.departmentdemo.model.Department;

@RestController
@RequestMapping("/dept-svc")
public class EmployeeController {
	
	final private Logger log=LoggerFactory.getLogger(EmployeeController.class);
	  private  Map<Integer, Department> deptData; 
	
	@RequestMapping(value="/department/{deptno}", method=RequestMethod.GET)
	public Department getEmployee(@PathVariable int deptno) throws Exception{
		
		deptData=new HashMap <Integer,Department>();
		deptData.put(111,new Department(111L,"server2 employee","LastName"));
		deptData.put(22,new Department(211L,"Employee2","LastName"));
		log.info("Inside Service method"+deptData);
		Thread.sleep(100);
	     Department emp= deptData.get(deptno);
		return emp;
	}

}
