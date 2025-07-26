package com.TheAlgorithms.dataStructures.problems.ArrayProblems;

import java.util.HashSet;

public class RemoveDuplicates {

    //remove duplicates from the given array. O(n) Time and O(n) Space
    //this will even works on Unsorted array
    public static int removeWithHash(int[] arr){
        //HashSet to track seen elements
        HashSet<Integer> elements = new HashSet<>();

        //maintaine new size of the array
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (!elements.contains(arr[i])) {
                elements.add(arr[i]);
                arr[index++] = arr[i];
            }
        }
        //return the size of new array with unique elements only
        return index;
    }

    //remove duplicates from the given array. O(n) Time and O(n) Space
    //this won't work with unsorted array
    public static int removeDuplicates(int arr[]){
        int n = arr.length;
        //check for base case, when array is size of 0 or 1
        if(n <= 1)
            return n;
        
        int index = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i-1]) {
                arr[index++] = arr[i];
            }
        }
        return index;
    }

}
