package com.kotesh.departmentdemo.practise;

public class TestMeVerify {
	
	public static void main(String[] args) {
		/* Printer print = new Printer();
		    Thread t1 = new Thread(new TaskEvenOdd(print, 10, false),"Odd");
		    Thread t2 = new Thread(new TaskEvenOdd(print, 10, true),"Even");
		    t1.start();
		    t2.start();*/
		
		TrafficSignal signal = new TrafficSignal();
		Thread red= new Thread(new Signal(signal, "RED"));
		Thread green= new Thread(new Signal(signal, "GREEN"));
		Thread yellow= new Thread(new Signal(signal, "YELLOW"));
		
		red.start();
		green.start();
		yellow.start();
	}

}

class Signal implements  Runnable{
	
	private TrafficSignal signal;
	private String signalName;
	
	public Signal() {
		
	}
	public Signal(TrafficSignal signal,String signalName) {
		this.signal=signal;
		this.signalName=signalName;
	}
	public void run() {
		for(int i=0;i<10;i++) {
			if(signalName.equalsIgnoreCase("GREEN")) {
				signal.printGreen();
			}else if(signalName.equalsIgnoreCase("RED")) {
				signal.printRed();
				
			}else if(signalName.equalsIgnoreCase("YELLOW")) {
				signal.printYellow();
				
			}else {
				System.out.println("Invalid signal");
			}
		}
		
			
		
	}
}

class TaskEvenOdd implements Runnable {
    private int max;
    private Printer print;
    private boolean isEvenNumber;
 
    public TaskEvenOdd() {
		// TODO Auto-generated constructor stub
	}
    
    public TaskEvenOdd( Printer print, int max, boolean isEvenNumber) {
    	this.print=print;
    	this.max=max;
    	this.isEvenNumber=isEvenNumber;
    }
 
    @Override
    public void run() {
        int number = isEvenNumber ? 2 : 1;
        while (number <= max) {
            if (isEvenNumber) {
                print.printEven(number);
            } else {
                print.printOdd(number);
            }
            number += 2;
        }
    }
}

class Printer {
    private volatile boolean isOdd;
 
    synchronized void printEven(int number) {
        while (!isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        //System.out.println(Thread.currentThread().getName() + ":" + number);
        System.out.println(number);
        isOdd = false;
        notify();
    }
 
    synchronized void printOdd(int number) {
        while (isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        //System.out.println(Thread.currentThread().getName() + ":" + number);
        System.out.println(number);
        isOdd = true;
        notify();
    }
    
    
    
}

class TrafficSignal {
    private volatile int currentSignal=2;
    
    private boolean isGreen() {
    	return currentSignal==1;
    }
    
    private boolean isRed() {
    	return currentSignal==2;
    }
    private boolean isYellow() {
    	return currentSignal==3;
    }
    
 
    synchronized void printGreen() {
    	while(!isGreen()) {
    		try {
				wait();
			} catch (Exception e) {			// TODO: handle exception
			}
    	}
    	System.out.println("GREEN");
    	currentSignal=currentSignal+1;
    	notifyAll();
    }
    
    synchronized void printRed() {
    	while(!isRed()) {
    		try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
    	}
    	System.out.println("RED");
    	currentSignal=currentSignal+1;
    	notifyAll();
    }
    synchronized void printYellow() {
    	while(!isYellow()) {
    		try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
    	}
    	System.out.println("YELLOW");
    	System.out.println("-------------");
    	currentSignal=1;
    	notifyAll();
    }
    
    
    
   /* synchronized void printEven(int number) {
        while (!isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        //System.out.println(Thread.currentThread().getName() + ":" + number);
        System.out.println(number);
        isOdd = false;
        notify();
    }
 
    synchronized void printOdd(int number) {
        while (isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        //System.out.println(Thread.currentThread().getName() + ":" + number);
        System.out.println(number);
        isOdd = true;
        notify();
    }*/
}