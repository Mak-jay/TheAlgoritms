package com.TheAlgorithms.dataStructures.problems.ArrayProblems;

import java.util.HashSet;

public class ArrayIsSorted {

    //helper mathod to check array is sorted or not
    public static boolean isSortedHelper(int arr[],int n){
        if (n == 1 || n == 0) {
            return true;
        }
        //check is current element is grater than or equal to 
        //it's previous and call recursivly method with new length of array 
        return arr[n - 1] >= arr[n-2] && isSortedHelper(arr, n-1);
    }

    //actual method, time complaxity O(n) and space is O(n)
    public static boolean isSortedRec(int arr[]){
        return isSortedHelper(arr, arr.length);
    }

    //Iterative approach, time complaxity O(n) and space is O(1)
    public static  boolean isSorted(int arr[]){
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i-1]) {
                return false;
            }
        }
        return true;
    }

}
