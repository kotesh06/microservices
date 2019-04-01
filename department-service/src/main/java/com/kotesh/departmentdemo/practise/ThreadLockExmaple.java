package com.kotesh.departmentdemo.practise;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadLockExmaple {
	
	
	
	
	public static void main(String[] args) {
		
		Map<Integer,Integer> abc = new HashMap<Integer, Integer>();
		ReadWriteLock mylock = new ReentrantReadWriteLock();
		MyThread T1Instance = new MyThread("T1", mylock,true);
		Thread t1 = new Thread(T1Instance);
		Thread t2 = new Thread(new MyThread("T2", mylock,false));
		Thread t3 = new Thread(new MyThread("T3", mylock,false));
		
		t1.start();
		t2.start();
		t3.start();
	}

}
class MyThread implements Runnable{
		ReadWriteLock mylock = null;
		
		//Lock readLock= null;
		//Lock writeLock= null;
		String name = null;
		boolean timeout = false;
		
		public MyThread(){
			
		}
		public MyThread(String name,ReadWriteLock mylock){
			this.name=name;
			this.mylock=mylock;
			//readLock=mylock.readLock();
			//writeLock=mylock.writeLock();
		}

		public MyThread(String name,ReadWriteLock mylock, boolean timeout){
			this.name=name;
			this.mylock=mylock;
			this.timeout=timeout;

			//readLock=mylock.readLock();
			////writeLock=mylock.writeLock();
		}


		@Override
		public void run() {
			System.out.println("Inside Thread "+name);
		try {
			if(timeout) {
				bizlogic(true);
				
			}else {
				bizlogic(false);
			}
			// if(mylock.tryLock()) {
		}catch (Exception e) {
			// TODO: handle exception
		}	
		System.out.println("Exit Thread "+name);
		
	}
		
	public void bizlogic(boolean write) {
		try {
			if(write) {
				mylock.writeLock().lock();
				 try {
					 System.out.println("Im in Write Locked block my name is "+name);
						// this.sleep(1000);
					 	Thread.sleep(1500);
					 	System.out.println("After write sleep");
						 mylock.writeLock().unlock();
						//mylock.notifyAll();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}else {mylock.readLock().lock();
				 try {
					 System.out.println("Im in Read Locked block my name is "+name);
					 
					/* mylock.readLock().unlock();
						mylock.notifyAll();*/
						// this.sleep(1000);
						 //Thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
		
		// }//if block
	} finally {
		mylock.readLock().unlock();
		mylock.notifyAll();
		mylock.writeLock().unlock();
		mylock.notifyAll();
		
	}
		}
	
		
}