package com.TheAlgorithms.dataStructures.linkedList;


import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T>{

    private int size=0;
    private Node <T> head=null;
    private Node <T> tail=null;
    

    //internal node's generic class to reperesent data 
    public class Node<T>{
        T data;
        Node <T> prev,next;
        public Node(T data,Node <T> prev,Node <T> next){
            this.data=data;
            this.prev=prev;
            this.next=next;
        }
        @Override public String toString(){
            return data.toString();
        }
    }

    public void clear(){
        Node <T> trav = head;
        while (trav != null) { 
            Node <T> next = trav.next;
            trav.prev= trav.next=null; //setting current node's prev and next pointer to null
            trav.data = null; //Sets node's data to null
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    //get size of list
    public int size(){
        return size;
    }

    //check for empty
    public boolean isEmpty(){
        return size() == 0;
    }

    //add new element 
    public void add(T elem){
        addLast(elem);
    }

    //add element at first
    public void addFirst(T elem){
        //check is list is empty
        if (isEmpty()) {
            head = tail = new Node<T>(elem,null,null);//set both pointer to new elem
        }else{
            Node<T> newNode = new Node<T>(elem, null, head);
            head.prev = newNode;//set head's prev to new elem
            head = newNode;//set head pointer to new elem
        }
        size++;
    }

    //add element at last
    public void addLast(T elem){
        if (isEmpty()) {
            head = tail = new Node<T>(elem,null,null);
        }else{
            tail.next = new Node<T>(elem, tail,null);
            tail = tail.next;
        }
        size++;
    }

    //check for the first data of the list 
    public T peekFirst(){
        if (isEmpty()) throw new RuntimeException("The list is empty");
        return head.data;
    }

    //check for the last data of the list 
    public T peekLast(){
        if (isEmpty()) throw new RuntimeException("The list is empty");
        return tail.data;
    }

    //remove data from the first 
    public T removeAtFirst(){
        //check if list is already empty
        if (isEmpty()) {
            throw new RuntimeException("The list is empty");
        }
        //Extract the data
        T data = head.data;
        head = head.next; //increment head pointer to next 
        --size;

        //if list is becomes empty after extracting data
        if (isEmpty()) tail = null;
        //must clear the data from the memory
        else head.prev = null;
        
        return data;
    }

    //remove data from the last 
    public T removeAtLast(){
        //check if list is already empty
        if (isEmpty()) {
            throw new RuntimeException("The list is empty");
        }
        //Extract the data
        T data = tail.data;
        tail = tail.prev; //decrement tail pointer to prev
        --size;

        //if list is becomes empty after extracting data
        if (isEmpty()) head = null;
        //must clear the data from the memory
        else tail.next = null;
        
        return data;
    }


    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
    

}
