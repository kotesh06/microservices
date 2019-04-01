package com.kotesh.departmentdemo.service;

public class DataTest {
	
	
	public void print(int i) {
		System.out.println(i);
	}
	
  private volatile int counter=1;
  
  
	
  
	public int getCounter() {
	return counter;
}



public void setCounter(int counter) {
	this.counter = counter;
}


 public synchronized void printEvenNumber() {

	 while(counter<10) {
		 if(counter%2==0) {
			 System.out.println(counter);
			 counter++;
			 try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 notifyAll();
	 }
	
 }
 public synchronized void printOddNumber() {

	 while(counter<10) {
		 if(counter%2!=0) {
			 System.out.println(counter);
			 counter++;
			 try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 notifyAll();
	 }
	
 }
	
}
