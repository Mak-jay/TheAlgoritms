package com.TheAlgorithms.dataStructures.queue;

import java.util.Iterator;
import java.util.LinkedList;

public class Queue <T> implements Iterable<T> {

    //Create instance variable of list
    private LinkedList<T> list = new LinkedList<>();


    public Queue(){}

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Queue(T firstElem){
        enqueue(firstElem);
    }

    //return size of the queue
    public int size(){
        return list.size();
    }

    //check queue is empty 
    public boolean isEmpty(){
        return size() == 0;
    }

    //peek at first element of the queue
    public T peek(){
        if(isEmpty()) throw new RuntimeException("The queue is empty");
        return list.peekFirst();
    }

    //remove first element from the queue
    public T dequeue(){
        if(isEmpty()) throw new RuntimeException("The queue is empty");
        return list.removeFirst();
    }

    //add element at the last point of the queue
    public void enqueue(T elem){
        if(elem == null)throw new RuntimeException("Element must contain value");
        list.addLast(elem);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

}
