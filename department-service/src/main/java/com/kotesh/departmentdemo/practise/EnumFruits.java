package com.kotesh.departmentdemo.practise;

public enum EnumFruits {
	MANGO(10,1),APPLE(20),ORANGE(100);
	private long price;
	public long getPrice() {
		return price;
	}
	public long getCount() {
		return count;
	}
	private long count=0;
	
	EnumFruits(long price,long count) {
		this.price=price;
		this.count=count;
	}
	EnumFruits(long price) {
		this.price=price;
	}
}
