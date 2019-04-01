package com.kotesh.departmentdemo.practise;

import java.util.LinkedList;
import java.util.Queue;

public class StackImplTest {
	
	static class StackImplWithQueue{
		Queue<Integer> queue = new LinkedList<Integer>();
		int capacity = 0;
		
		public void push(Integer data) {
			
			//ADD new element to queue
			queue.add(data);
			
			//Remove existing elements from Queue & add back
			for(int i=0; i<capacity ;i++) {
				//remove element 
				Integer tempData=queue.poll();
				//add element to queue
				queue.add(tempData);
			}
			capacity=capacity+1;
		}
		
		public Integer pop() {
			if(capacity<=0) {
				System.out.println("No element present");
				return -1;
			}
			capacity--;
			return queue.poll();
		}
		
		public void display() {
			if(capacity>0) {
				for(int i=0;i<capacity;i++) {
					System.out.print(queue.peek());
					System.out.print(" ==>>");
				}
			}else {
				System.out.println("No elements");
			}
			
				
		}
		
		
	}
	
	public static void main(String[] args) {
		
		StackImplWithQueue obj =new StackImplWithQueue();
		
		obj.push(10);
		obj.push(20);
		obj.push(40);
		
		obj.display();
		
		obj.push(50);
		obj.display();
		obj.pop();
		obj.display();

		obj.pop();
		obj.display();

		obj.pop();
		obj.display();
		obj.pop();
		obj.display();
		
	}

}
