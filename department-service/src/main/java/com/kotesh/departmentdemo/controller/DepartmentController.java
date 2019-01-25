package com.kotesh.departmentdemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kotesh.departmentdemo.model.DepartmentDTO;
import com.kotesh.departmentdemo.service.DepartmentService;

@RestController
@RefreshScope
@RequestMapping("/dept-svc-test")
public class DepartmentController {
	

	final private Logger log=LoggerFactory.getLogger(DepartmentController.class);
	
	@Value("${hello.message}")
    private String message;
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value="/department/{departmentId}", method=RequestMethod.GET)
	public DepartmentDTO getDeparmentDetails(@PathVariable int departmentId) {
		return departmentService.getDeparmentDetails(departmentId);
	}
	
	@RequestMapping(value="/department", method=RequestMethod.GET)
	public List<DepartmentDTO> getAllDeparmentDetails(){
		return departmentService.getAllDeparmentDetails();
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String hello(){
		return "Welcome Config Service #"+message;
	}
	
	/*  private  Map<Integer, Department> deptData; 
	
	@RequestMapping(value="/department/{deptno}", method=RequestMethod.GET)
	public Department getDepartment(@PathVariable int deptno) throws Exception{
		
		deptData=new HashMap <Integer,Department>();
		deptData.put(111,new Department(111L,"server2 employee","LastName"));
		deptData.put(22,new Department(211L,"Employee2","LastName"));
		log.info("Inside Service method"+deptData);
		Thread.sleep(100);
	     Department emp= deptData.get(deptno);
		return emp;
	}*/

}
