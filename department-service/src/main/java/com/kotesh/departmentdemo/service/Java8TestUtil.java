package com.kotesh.departmentdemo.service;

import java.util.ArrayList;
import java.util.List;

import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.kotesh.departmentdemo.model.Emp;

public class Java8TestUtil {
	
	public static void main(String[] args) {
		Java8TestUtil obj = new Java8TestUtil();
		obj.getEmpList();
	}

	public List<Emp> getEmpList(){
		List<Emp> empList = new ArrayList<Emp>();
		for(int i=1;i<100;i++) {
			Emp e = new Emp();
			e.setEmpNo(i);
			e.setEmpName("Employee#"+i);
			e.setSal(i*1000);
			empList.add(e);
		}
		MyBizLogic bizlogic = new MyBizLogic();
		//empList.forEach(bizlogic);
		
		Stream<Emp> seqEmp=empList.stream();
		Stream<Emp> parEmp=empList.parallelStream();
		
		//Stream<Emp> filterEmp = seqEmp.filter(e -> e.getEmpNo()>90L);
		Stream<Emp> filterParllelEmp = parEmp.filter(e -> e.getSal()>45000);
		
		//filterEmp.forEach(e->System.out.println("Employess in sequential #"+e));
		filterParllelEmp.forEach(e->System.out.println("Employess in parllel #"+e));
		
		List<Integer> mylist = new ArrayList<Integer>();
		for(int i=1;i<50;i++) mylist.add(i);
		
		Stream<Emp> filterpa = empList.parallelStream().filter(e->e.getSal()>50000);
		
		//List<Emp> filterData = filterpa.collect(Collectors.toList());
		
		System.out.println("After collect data");
		
		//filterData.forEach(bizlogic);
		filterpa.forEach(e->System.out.println(e));
		
		return  empList;
	}
	
	class MyBizLogic implements Consumer<Emp>{

		@Override
		public void accept(Emp t) {
			if(t.getSal()>5000 && t.getSal()<15000)
				System.out.println(t);
			else
				System.out.println("Else block "+t);
			
		}
		
	}
}
