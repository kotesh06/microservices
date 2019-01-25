package com.kotesh.departmentdemo.model;

public class Emp {
	
	private long empNo;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + (int) (empNo ^ (empNo >>> 32));
		result = prime * result + (int) (sal ^ (sal >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "employee [empNo=" + empNo + ", empName=" + empName + ", sal=" + sal + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (empNo != other.empNo)
			return false;
		if (sal != other.sal)
			return false;
		return true;
	}

	public long getEmpNo() {
		return empNo;
	}

	public void setEmpNo(long empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public long getSal() {
		return sal;
	}

	public void setSal(long sal) {
		this.sal = sal;
	}

	private String empName;
	
	private long sal;

}
