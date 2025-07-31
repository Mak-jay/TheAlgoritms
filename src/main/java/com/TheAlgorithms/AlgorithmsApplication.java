package com.TheAlgorithms;

import com.TheAlgorithms.dataStructures.problems.ArrayProblems.ReverseArray;

public class AlgorithmsApplication {

	public static void main(String[] args) {

		int[] arr = {1,2,3};

		ReverseArray.reverseArrayRec(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		

	}		
}