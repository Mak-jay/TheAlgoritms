package com.TheAlgorithms.dataStructures.problems.ArrayProblems;

import java.util.ArrayList;

public class PrintAlternates {

    //iterative approach to print alternate element from the array
    public static  ArrayList<Integer> getAlternates(int arr[]){
        ArrayList<Integer> elements = new ArrayList<>();
        for (int i = 0; i < arr.length; i+=2) {
            elements.add(arr[i]);
        }
        return elements;
    }

    public static void getAlternateRec
    (int[] arr,int index,ArrayList<Integer> list){
        if (index < arr.length) {
            list.add(arr[index]);
            getAlternateRec(arr, index+2, list);
        }
    }

    public static ArrayList<Integer> getAlternateElem(int arr[]){
        ArrayList<Integer> elements = new ArrayList<>();
        getAlternateRec(arr, 0, elements);
        return elements;
    }
    

}
