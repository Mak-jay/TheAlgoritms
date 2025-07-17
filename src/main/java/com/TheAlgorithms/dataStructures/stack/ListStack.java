package com.TheAlgorithms.dataStructures.stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;

public class ListStack<T> implements Iterable<T>{

    
    private java.util.LinkedList<T> list = new java.util.LinkedList<T>();

    public ListStack() {}

    //Create a stack
    public ListStack(T element) {
        push(element);
    }

    //get size of the stack
    public int size(){
        return list.size();
    }

    //Check for empty 
    public boolean isEmpty(){
        return size() == 0;
    }

    //Push element to the stack 
    public void push(T element){
        list.addLast(element);
    }

    //remove the element lastly added
    public T pop(){
        if (isEmpty()) throw new EmptyStackException();  
        return list.removeLast();
    }

    //Peek on the top of the Stack, without removing element
    public T peek(){
        if (isEmpty()) throw new EmptyStackException(); 
    return list.peekLast();
    }
    
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
    

}
