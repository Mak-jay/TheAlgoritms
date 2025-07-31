package com.TheAlgorithms.dataStructures.problems.ArrayProblems;



public class AllSubArray {

    public static void subArray(int arr[]){
        int n = arr.length;


        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int j2 = i; j2 <= j; j2++) {
                    System.out.print(arr[j2]);
                }
                System.out.println();
            }
        }
    }

    public static void subArrayRec(int arr[],int start,int end){
        if (end == arr.length) {
            return;
        }else if(start > end){
            subArrayRec(arr, 0, end+1);
        }else{
            System.out.print("[");
            for (int i = start; i < end; i++)
                System.out.print(arr[i] + ", ");
            System.out.println(arr[end] + "]");
            subArrayRec(arr, start + 1, end);
        }
        return;
    }

}
