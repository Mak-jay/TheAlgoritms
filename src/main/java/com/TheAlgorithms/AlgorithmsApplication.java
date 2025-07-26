package com.TheAlgorithms;

import com.TheAlgorithms.dataStructures.problems.ArrayProblems.RemoveDuplicates;




public class AlgorithmsApplication {

	public static void main(String[] args) {

		int[] arr = {1,2,2,4,4,5,5};

		System.out.println(arr.length);
		int size = RemoveDuplicates.removeDuplicates(arr);
		System.out.println(size);
		

	}		
}