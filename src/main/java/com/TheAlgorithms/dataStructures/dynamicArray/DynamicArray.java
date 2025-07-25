package com.TheAlgorithms.dataStructures.dynamicArray;

import java.util.Iterator;

@SuppressWarnings(value = { "unchecked" })
public class DynamicArray <T> implements Iterable<Object> {

    private T[] arr;
    private int len=0;
    private int size=0;

    public DynamicArray() 
    {this(16);}//array actual size 
    

    //assign size to array
    public DynamicArray(int size) {
        if (size < 0 )throw new IllegalArgumentException("Size must be > 0");
        this.size=size;
        arr=(T[]) new Object[size];

    }

    //get array's size
    public int size(){
        return len;
    }

    //check for empty
    public boolean isEmpty(){
        return size() == 0;
    }

    //get access element by index
    public T getElem(int index){
        return arr[index];
    }

    //set element at specific index
    public void setElem(int index, T element){
        arr[index] = element;
    }

    //clear whole array
    public void clear(){
        for (int i = 0; i < size; i++) {
            arr[i]=null;
        len=0;
        }
    }


    //adding new element at last index
    public void addElem(T element){
        //check if resizing needed
        if (len+1 >= size) {
            if (size == 0)size += 1;//if size is zero
            else size *= 2; //double the size
            T[] newArr = (T[]) new Object[size];
            //extract old array
            for (int i = 0; i < len; i++) 
                newArr[i] = arr[i];
            arr = newArr;//sets old array to be new array
        }
        arr[len++] = element;// add element and increment len
    }

    //remove element from index
    public T removeAt(int rmIndex){
        //check for valid index 
        if(rmIndex >= len && rmIndex < 0)throw new IndexOutOfBoundsException();
        T data = arr[rmIndex];
        T[] newArr = (T[]) new Object[len-1];
        for (int i = 0,j=0; i < len; i++,j++) 
            if(i == rmIndex)j--;// skip over index need to be removed by fixing j temporarily
            else newArr[j] = arr[i];
        arr = newArr;
        size = --len;
        return data;
    }

    // remove by searching linearly
    public boolean remove(Object obj){
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(obj)){
                removeAt(i);
                return true;}}
    return false;
    }

    //get index of element
    public int indexOf(Object obj){
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(obj))
                return i;
        }
    return -1;
    }

    //check for array contains x element
    public boolean contains(Object obj){
        return indexOf(obj) != -1;
    }



    @Override
    public Iterator iterator() {
        return new Iterator<T> (){
        int index = 0;
        @Override
        public boolean hasNext(){return index < len;}
        @Override
        public T next(){return arr[index++];}
        };
    }
    
}
