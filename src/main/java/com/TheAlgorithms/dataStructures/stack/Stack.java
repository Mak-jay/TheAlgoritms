package com.TheAlgorithms.dataStructures.stack;

public interface Stack<T>{

    //returns size of the Stack 
    int size();
    
    //Check whether stack is empty
    boolean isEmpty();

    //insert/push element into the stack 
    void push(T element);

    //delete/pop element from the stack
    T pop();

    //peek on the top elemen 
    T peek();

}
