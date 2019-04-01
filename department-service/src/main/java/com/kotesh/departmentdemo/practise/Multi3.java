package com.kotesh.departmentdemo.practise;

import com.kotesh.departmentdemo.service.DataTest;

public class Multi3 {
	public static void main(String args[]){
		
		 DataTest data = new DataTest();
		ThreadA m1=new ThreadA(data); 
		ThreadB m2=new ThreadB(data);
		Thread t2 =new Thread(m2);  
		Thread t1 =new Thread(m1);  
		
		t2.start();
		t1.start();
		 } 
}


/*class ThreadB implements Runnable{  
	 DataTest data;
	volatile int i=1;
	public ThreadB(DataTest data) {
		this.data=data;
	}
	public void run(){  
		System.out.println("thread B is running..."); 
		while(i<=10) {
			synchronized (data) {
				//System.out.println(data.i);
				//System.out.println(data.i%2);
				if(i%2!=0) {
					data.print(i);
					try {
						i=i+2;
						data.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}				
			}
			data.notify();	
			}
		
		}
		
	}  
*/

/*class ThreadA implements Runnable{  
	 DataTest data;
	//volatile int i=2;
	public ThreadA(DataTest data) {
		this.data=data;
	}
	public void run(){  
		System.out.println("thread A is running..."); 
		while(data.getCounter()<=10) {
			synchronized (data) {
				//System.out.println(data.i);
				//System.out.println(data.i%2);
				if(data.getCounter()%2==0) {
					data.print(data.getCounter());
					try {
						data.setCounter(data.getCounter()+1);
						data.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				data.notify();
			}
			}
		
		}
		
	}  
*/

class ThreadA implements Runnable{  
	 DataTest data;
	//volatile int i=2;
	public ThreadA(DataTest data) {
		this.data=data;
	}
	public void run(){  
		System.out.println("thread B is running..."); 
		while(data.getCounter()<=10) {
			synchronized (data) {
				//System.out.println(data.i);
				//System.out.println(data.i%2);
				
				if(data.getCounter()%2!=0) {
					try {
						//data.setCounter(data.getCounter()+1);
						data.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				
				data.print(data.getCounter());
				data.setCounter(data.getCounter()+1);
				data.notify();
				
				
				
				/*if(data.getCounter()%2!=0) {
					data.print(data.getCounter());
					try {
						data.setCounter(data.getCounter()+1);
						data.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				data.notify();*/
			}
			}
		
		}
		
	}  

class ThreadB implements Runnable{  
	 DataTest data;
	//volatile int i=2;
	public ThreadB(DataTest data) {
		this.data=data;
	}
	public void run(){  
		System.out.println("thread B is running..."); 
		while(data.getCounter()<10) {
			synchronized (data) {
				//System.out.println(data.i);
				//System.out.println(data.i%2);
				
				if(data.getCounter()%2==0) {
					try {
						//data.setCounter(data.getCounter()+1);
						data.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				
				data.print(data.getCounter());
				data.setCounter(data.getCounter()+1);
				data.notify();
				
				
				
				/*if(data.getCounter()%2!=0) {
					data.print(data.getCounter());
					try {
						data.setCounter(data.getCounter()+1);
						data.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				data.notify();*/
			}
			}
		
		}
		
	}  
