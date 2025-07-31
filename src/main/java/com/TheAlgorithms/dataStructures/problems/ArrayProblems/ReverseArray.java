package com.TheAlgorithms.dataStructures.problems.ArrayProblems;

public class ReverseArray {

    public static void reverseArray(int arr[]){
        int n = arr.length;
        //initalize new array
        int[] temp = new int[n];
        //copy elements of original array into temp array 
        //from last index
        for (int i = 0; i < n; i++) {
            temp[i] = arr[n - i - 1];
        }
        //again copy elements from temp array to onriginal array
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
            System.out.print(arr[i]+" ");
        }
    }

    public static void reverseArrayPointer(int arr[]){

        //initialize left and right elements
        int left=0, right=arr.length-1;

        //repeat while left pointer becomes less than right
        while (left < right) {
            //swap with current left and current right
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;  

            //increment and decrement points accordingly
            left++;
            right--;
        }
    }

    //reverse array by swapping the elements 
    public static void reverseArraySwap(int arr[]){
        int n = arr.length;
        //run loop till half size of array
        for (int i = 0; i < n/2; i++) {
            //swapp current element with n - i - 1 element
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }

    //recursion function to reverse an array from left to right 
    //(we'll be using it as helper method)
    static void reverseArrayHelper(int arr[],int left, int right){
        if (left >= right) 
            return;
        
        //swap the elements
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        reverseArrayHelper(arr, left + 1, right - 1);
    } 
    //function to reverse an array
    public static void reverseArrayRec(int arr[]){
        int n = arr.length;
        reverseArrayHelper(arr, 0, n-1);
    } 

}
