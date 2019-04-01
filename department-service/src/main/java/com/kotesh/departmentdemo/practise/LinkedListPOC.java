package com.kotesh.departmentdemo.practise;

public class LinkedListPOC {
	
	private Node head = null;
	
	class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data=data;
			//this.next=null;
		}
	}
	
	public boolean addElement(int data) {
		
		if(head==null) {
			head = new Node(data);
			head.next=null;
			return true;
		}
		
		Node currElement= head;
		while(currElement.next!=null) {
			currElement=currElement.next;
		}
		Node newElement=new Node(data);
		newElement.next=null;
		currElement.next=newElement;
		return true;
	}
	
	public void traverse() {
		if(head==null) {
			return;
		}
		Node currElement=head;
		while(currElement.next!=null) {
			System.out.println(currElement.data+" -->");
			currElement=currElement.next;
		}
		System.out.println(currElement.data+" ");
	}

	
	public static void main(String[] args) {
		LinkedListPOC llpoc = new LinkedListPOC();
		llpoc.addElement(10);
		llpoc.addElement(5);
		llpoc.addElement(30);
		llpoc.addElement(20);
		llpoc.addElement(1);
		llpoc.addElement(89);
		llpoc.addElement(90);
		llpoc.addElement(70);
		
		System.out.println("Traversing the linked list");
		
		llpoc.traverse();
	
	}
}
