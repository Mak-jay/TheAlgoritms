package com.TheAlgorithms.dataStructures.problems.ArrayProblems;

import java.util.ArrayList;
import java.util.Collections;


public class LeadersInArray {

    //find leaders in array. time complexity = O(n^2)
    public static ArrayList<Integer> getLeaders(int arr[]){
        ArrayList<Integer> leaders = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int j;
            for (j = i+1; j < n; j++) {
                if (arr[i] < arr[j]) 
                    break;
            }
            if (j == n) {
                leaders.add(arr[i]);
            }
        }
        return leaders;
    }

    //find leaders in array(Using suffix maximum). time complexity = O(n)
    public static ArrayList<Integer> getLearersWithSuffix(int arr[]){
        ArrayList<Integer> elements = new ArrayList<>();
        int n = arr.length;
        //start with righmost element
        int maxRight = arr[n-1];
        for (int i = n-2; i >= 0; i--) {
            if (arr[i] >= maxRight) {
                maxRight = arr[i];
                elements.add(arr[i]);
            }
        }
        //reverse the array list to maintain order
        Collections.reverse(elements);
        return elements;
    }


}
