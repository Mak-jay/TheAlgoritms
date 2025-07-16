package com.TheAlgorithms.dataStructures.linkedList;


import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T>{

    private int size=0;
    private Node <T> head=null;
    private Node <T> tail=null;
    

    //internal node's generic class to reperesent data 
    private  class Node<T>{
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

    //clear the list
    public void clear(){
        Node <T> trav = head;
        while (trav != null) { 
            Node <T> next = trav.next;
            trav.prev= trav.next=null; //setting current node's prev and next pointer to null
            trav.data = null; //Sets node's data to null
            trav = next;//increment the trav 
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

    //remove an abritrary node from the list (O(1))
    private  T remove(Node<T> node){
        //if the node is present at either head or tail
        //then handle those case independently
        if (node.prev == null) return removeAtFirst();
        if (node.next == null) return removeAtLast(); 

        //detach the node from it's prev and next
        node.next.prev = node.prev;
        node.prev.next = node.next;
        //temprary store node's data
        T data = node.data;
        
        //must clean up the memory
        node.data = null;
        node = node.prev = node.next = null; // set node's both pointer to null

        --size;//decrement size of the list

        return data;
    }

    //remove from particular index, (O(n))
    public T removeAt(int index){
        if(index < 0 || index >= size)throw new IllegalArgumentException();

        int i;
        Node <T> trav; //make traversal pointer

        //if index is closer to front
        if (index < size/2) {
            for(i=0, trav = head ; i != index; i++){
                trav = trav.next;
            }
            System.out.println(trav);
        //else start searching from the back
        }else{
            for(i = size-1, trav = tail; i!= index; i--){
                trav = trav.prev;
            }
            System.out.println(trav);
        }
        return remove(trav);
    }

    //remove particular value from the list, (O(n))
    public boolean remove(Object object){
        Node<T> trav;

        //in case of sreaching for null
        if (object == null) {
            for(trav = head; trav != null; trav = trav.next){
                if (trav.data == null) { // when null node found
                    remove(trav);       // remove that node
                    return true;
                }
            }
        //in case of removing actual value
        }else{
            for(trav = head; trav != null; trav = trav.next){
                if (object.equals(trav.data)) {//when value found 
                    remove(trav);              //then remove it
                    return true;
                }
            }
        }
        return false; 
    }

    //find index of particular value in list, (O(n))
    public int indexOf(Object object){
        int index = 0;
        Node<T> trav = head;

        //support searching for null
        if(object == null){
            for(trav = head; trav != null; trav = trav.next, index++){
                if (trav.data == null) {//when null value found, then return the index
                    return index;
                } 
            }
        //search for give value's index
        }else{
            for(trav = head; trav != null; trav = trav.next, index++){
                if (object.equals(trav.data)) {//when value found, then return the index
                    return index;
                }
            }
        }
        return -1;
    }

    //Check whether list contains the given value
    public boolean contains(Object object){
        return indexOf(object) != -1;
    }


   @Override
  public java.util.Iterator<T> iterator() {
    return new java.util.Iterator<T>() {
      private Node<T> trav = head;

      @Override
      public boolean hasNext() {
        return trav != null;
      }

      @Override
      public T next() {
        T data = trav.data;
        trav = trav.next;
        return data;
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }
   @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[ ");
    Node<T> trav = head;
    while (trav != null) {
      sb.append(trav.data);
      if (trav.next != null) {
        sb.append(", ");
      }
      trav = trav.next;
    }
    sb.append(" ]");
    return sb.toString();
  }

  
}
