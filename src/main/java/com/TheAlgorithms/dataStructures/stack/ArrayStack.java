package com.TheAlgorithms.dataStructures.stack;

import java.util.Arrays;
import java.util.EmptyStackException;



public class ArrayStack<T> implements  Stack<T> {
    private int size;
    private int capacity;
    private Object[] data;

    

    public ArrayStack() {
        capacity = 10;
        data = new Object[capacity];
    }


    public void increseSize(){
        capacity *= 2;
        data = Arrays.copyOf(data, size);
    }

    @Override
    public int size() {
       return size;
    }



    @Override
    public boolean isEmpty() {
        return size() == 0;
    }



    @Override
    public void push(T elem) {
        if (size == capacity) {
            increseSize();
        }
        data[size++] = elem;
    }


    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
       if(isEmpty()) throw  new EmptyStackException();
       T element = (T) data[--size];
       data[size] = null;
       return element;   
    }

    @Override
    public T peek() {
        if(isEmpty()) throw new EmptyStackException();
        return (T) data[size-1];
    }



  
}
