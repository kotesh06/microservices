package com.kotesh.departmentdemo.model;

public class DepartmentDTO {
	
	private Long deparmentNo;
	
	public DepartmentDTO(Long deparmentNo, String departmentName, String departmentCategory) {
		super();
		this.deparmentNo = deparmentNo;
		this.departmentName = departmentName;
		this.departmentCategory = departmentCategory;
	}

	@Override
	public String toString() {
		return "DepartmentDTO [deparmentNo=" + deparmentNo + ", departmentName=" + departmentName
				+ ", departmentCategory=" + departmentCategory + "]";
	}

	public Long getDeparmentNo() {
		return deparmentNo;
	}

	public void setDeparmentNo(Long deparmentNo) {
		this.deparmentNo = deparmentNo;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentCategory() {
		return departmentCategory;
	}

	public void setDepartmentCategory(String departmentCategory) {
		this.departmentCategory = departmentCategory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deparmentNo == null) ? 0 : deparmentNo.hashCode());
		result = prime * result + ((departmentCategory == null) ? 0 : departmentCategory.hashCode());
		result = prime * result + ((departmentName == null) ? 0 : departmentName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartmentDTO other = (DepartmentDTO) obj;
		if (deparmentNo == null) {
			if (other.deparmentNo != null)
				return false;
		} else if (!deparmentNo.equals(other.deparmentNo))
			return false;
		if (departmentCategory == null) {
			if (other.departmentCategory != null)
				return false;
		} else if (!departmentCategory.equals(other.departmentCategory))
			return false;
		if (departmentName == null) {
			if (other.departmentName != null)
				return false;
		} else if (!departmentName.equals(other.departmentName))
			return false;
		return true;
	}

	private String departmentName;
	
	private String departmentCategory;
	


}
