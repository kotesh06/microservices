package com.kotesh.departmentdemo.practise;

import java.util.LinkedList;
import java.util.Queue;

public class StackWith2QueueImplTest {
	
	static class StackImplWith2Queue{
		Queue<Integer> queue1 = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();
		int capacity = 0;
		
		//push costly approach
		
		public void push(Integer data) {
			
			//ADD new element to queue2
			queue2.add(data);
			
			//Remove from queue1 & add it to queue2
			for(int i=0; i<capacity ;i++) {
				//remove element 
				Integer tempData=queue1.poll();
				//add element to queue
				queue2.add(tempData);
			}
			capacity=capacity+1;
			
			//Swap queues
			
			Queue<Integer> tempQueue=queue1;
			queue1 = queue2;
			queue2 = tempQueue;
		}
		
		public Integer pop() {
			if(capacity<=0) {
				System.out.println("No element present");
				return -1;
			}
			capacity--;
			return queue1.poll();
		}
		
		public void display() {
			if(capacity>0) {
				
			//	LinkedList<Integer> head = queue1.
				for(int i=0;i<capacity;i++) {
					System.out.print(queue1.peek());
					System.out.print(" ==>>");
				}
			}else {
				System.out.println("No elements");
			}
			
				
		}
		
		public int fib(int n) {
			if(n<=1)
				return n;
			return fib(n-1)+fib(n-2);
		}
		
	}
	
	public static void main(String[] args) {
		
		StackImplWith2Queue obj =new StackImplWith2Queue();
		
		obj.push(10);
		obj.push(20);
		obj.push(30);
		obj.push(40);
		
		obj.display();
		
		obj.push(50);
		System.out.println("Next1");
		obj.display();
		obj.pop();
		System.out.println("Next2");
		obj.display();

		obj.pop();
		System.out.println("Next3");
		obj.display();

		obj.pop();
		System.out.println("Next4");
		obj.display();
		obj.pop();
		System.out.println("Nex");
		obj.display();
		
		System.out.println(obj.fib(3));
		
	}
	
	

}
