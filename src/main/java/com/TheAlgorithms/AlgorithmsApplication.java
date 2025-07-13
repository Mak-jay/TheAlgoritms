package com.TheAlgorithms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.TheAlgorithms.dataStructures.linkedList.DoublyLinkedList;

@SpringBootApplication
public class AlgorithmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgorithmsApplication.class, args);

		DoublyLinkedList<Integer> myList = new DoublyLinkedList<>();
		myList.add(1);
		myList.add(2);
		myList.add(3);
		myList.add(4);
		myList.add(5);
		System.out.println(myList.toString());

		myList.removeAt(2);
		System.out.println(myList.toString());
		
	}






}
