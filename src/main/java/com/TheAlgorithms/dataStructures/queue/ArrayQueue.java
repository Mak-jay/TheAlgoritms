package com.TheAlgorithms.dataStructures.queue;

import java.util.Iterator;

public class ArrayQueue<T> implements Iterable<T> {
    private Object[] data;
    private int front;
    private int rear;

    public ArrayQueue(){};

    public ArrayQueue(int capacity){
        data = new Object[capacity + 1];
        front = 0;
        rear = 0;
    }

    public boolean ifFull(){
        return (front + data.length - rear) % data.length == 1;
    }

    public int size(){
        return adjustIndex(rear + data.length - front,data.length);
    }

    public boolean isEmpty(){
        return front == rear;
    }

    private int adjustIndex(int index, int size){
        return index >= size ? index - size : index;
    }

    public void enqueue(T elem){
        if (ifFull()) throw new RuntimeException("Queue is full");
        data[rear++] = elem;
        rear = adjustIndex(rear, data.length);
    }

    @SuppressWarnings("unchecked")
    public T dequeue(){
        if(isEmpty()) throw new RuntimeException("Queue is ");

        front = adjustIndex(front, data.length);
        return (T) data[front++];
    }

    @SuppressWarnings("unchecked")
    public T peek(){
        if(isEmpty()) throw new RuntimeException("Queue is ");

        front = adjustIndex(front, data.length);
        return (T) data[front];
    }








    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    

}
