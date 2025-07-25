package com.TheAlgorithms;

import java.util.ArrayList;

import com.TheAlgorithms.dataStructures.problems.ArrayProblems.LeadersInArray;




public class AlgorithmsApplication {

	public static void main(String[] args) {

		int[] array = {16,17,6,8,5,2};
		
		ArrayList<Integer> leader = LeadersInArray.getLearersWithSuffix(array);
		for (int i : leader) {
			System.out.print(i+" ");
		}
	}		
}