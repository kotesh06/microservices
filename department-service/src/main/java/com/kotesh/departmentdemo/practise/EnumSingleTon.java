package com.kotesh.departmentdemo.practise;

public enum EnumSingleTon {
	INSTANCE;
	
	String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
