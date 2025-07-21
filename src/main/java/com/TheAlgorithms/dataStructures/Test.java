package com.TheAlgorithms.dataStructures;

import java.util.Iterator;

public class Test<T> implements Iterable {

    int size = 0;
    Node<T> head = null;
    Node<T> tail = null;
    


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

    public void clear(){
        Node<T> trav = head;
        while(trav != null){
            Node<T> next = trav.next;
            trav.next = trav.prev = null;
            trav.data = null;
            trav = next;
        }
        head = tail = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void addFirst(T elem){
        if (isEmpty()) {
            head = tail = new Node<T>(elem, null,null);
        }else{
            Node<T> newNode = new Node<T>(elem,null,head);
            head.prev = newNode;
            newNode = head;
        }
        size++;
    }

    public void addLast(T elem){
        if (isEmpty()) {
            head = tail = new Node<T>(elem,null,null);
        }else{
            Node<T> newNode = new Node(elem, tail, null);
            tail.next = newNode;
            tail = newNode;
        }
    }

    public T removeFirst(){
        if (isEmpty()) throw new RuntimeException("List is empty");
        
        T data = head.data;
        head = head.next;
        --size;

        if (isEmpty()) tail = null;
        else head.prev = null;

        return data;
    }

    public T removeLast(){
        if(isEmpty()) throw new RuntimeException("List is empty");

        T data = tail.data;
        tail = tail.prev;
        --size;

        if (isEmpty()) head = null;
        else tail.prev = null;

        return data;
    }

    @SuppressWarnings("Unchecked")
    private T remove(Node<T> node){
        if(node.prev == null) return removeFirst();
        if(node.next == null) return removeLast();

        node.next.prev = node.prev;
        node.prev.next = node.next;
        
        T data = node.data;//data copied

        node.data = null;
        node = node.next = node.prev = null;
        --size;

        return data;
    }

    public T removeAt(int index){
        int i;
        Node<T> trav;

        if (index < 0 || index >= size) throw new IllegalArgumentException();

        if (index < (size/2)) {
            for(i=0,trav = head;i != index;i++){
                trav = trav.next;
            }
        }else{
            for(i=size-1, trav = tail; i != index; i--){
                trav = trav.next;
            }
        }
        return remove(trav);
    }

    public T peekFirst(){
         if (isEmpty()) throw new RuntimeException("The list is empty");
        return head.data;
    }


    public T peekLast(){
         if (isEmpty()) throw new RuntimeException("The list is empty");
        return tail.data;
    }

    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
    
}
