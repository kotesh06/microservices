package com.kotesh.departmentdemo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kotesh.departmentdemo.model.DepartmentDTO;
import com.kotesh.departmentdemo.service.DepartmentNotFoundException;
import com.kotesh.departmentdemo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	private List<DepartmentDTO> deptList = null;

	@Override
	public DepartmentDTO getDeparmentDetails(int departmentId) {
		List<DepartmentDTO> deptListlocal = getAllDeparmentDetails();
		List<DepartmentDTO> matchedLists=deptListlocal.stream().
				filter(d->d.getDeparmentNo().equals(new Long(departmentId))).collect(Collectors.toList()) ;
		
		DepartmentDTO deptDetails = null;
		if(matchedLists!=null && matchedLists.size()>0) {
			deptDetails=matchedLists.get(0);
		}else {
			throw new DepartmentNotFoundException("Department ID"+departmentId+" Not found");
		}
		return deptDetails;
	}

	@Override
	public List<DepartmentDTO> getAllDeparmentDetails() {
		return getLists();
	}
	
	private List<DepartmentDTO> getLists(){
		if(deptList==null) {
			deptList= new ArrayList<>();
			DepartmentDTO deptObj;
			for(int i=1;i<26;i++) {
				deptObj=new DepartmentDTO(new Long(i), "Deparment Name#"+i, "Categery "+i);
				deptList.add(deptObj);
			}
		}
		return deptList;
	}

	public static void main(String[] args) {
		DepartmentServiceImpl imp = new DepartmentServiceImpl();
		System.out.println(imp.getAllDeparmentDetails());
		
		System.out.println(imp.getDeparmentDetails(4));
	}
}
