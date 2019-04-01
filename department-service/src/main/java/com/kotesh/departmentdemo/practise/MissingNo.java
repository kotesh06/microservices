package com.kotesh.departmentdemo.practise;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class MissingNo {
	
	public void findMissingNo(int[]arr, int count) {
		int totalexpected = count *((count+1)/2);
		
		int actualSum = 0;
		for (int i = 0; i < arr.length; i++) {
			actualSum=actualSum+arr[i];
		}
		System.out.println(totalexpected);
		System.out.println(actualSum);
		System.out.println("Missing no "+(totalexpected-actualSum));
	}
	
	private static void printMissingNumber(int[] numbers, int count) { 
		int missingCount = count - numbers.length; 
	BitSet bitSet = new BitSet(count); 
	for (int number : numbers) { bitSet.set(number - 1); } 
	System.out.printf("Missing numbers in integer array %s, with total number %d is %n", Arrays.toString(numbers), count); 
	int lastMissingIndex = 0; for (int i = 0; i < missingCount; i++) {
		lastMissingIndex = bitSet.nextClearBit(lastMissingIndex); 
	System.out.println(++lastMissingIndex); } }

	
	private static int getMissingNumber(int[] numbers, int totalCount) { 
		int expectedSum = (totalCount * (totalCount + 1) )/ 2 ;
		int actualSum = 0; for (int i : numbers) { actualSum += i; } 
		return expectedSum - actualSum; }

	
	public static void printPairsUsingSet(int[] numbers, int n){
		if(numbers.length < 2){ return; } 
		
		Set<Integer> set = new HashSet<Integer>(numbers.length);
		for(int value : numbers){
			System.out.println("Inside loop");
			int target = n - value; 
		// if target number is not in set then add 
		if(!set.contains(target)){ set.add(value); }
		else { System.out.printf("(%d, %d) %n", value, target); } 
		}
		System.out.println("Set value"+set);
	}

	
	
	public static void main(String[] args) {
		int[] arr= {
				1,2,4,6,9
		};
		int[] arr2= {
				1, 2, 4,5,6	};
		MissingNo obj = new MissingNo();
		obj.printMissingNumber(arr, 10);
		
		System.out.println("Missing no "+obj.getMissingNumber(arr2, 6));
		
		obj.printPairsUsingSet(arr2, 6);
	}

}
