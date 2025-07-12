package com.TheAlgorithms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.TheAlgorithms.dataStructures.dynamicArray.Array1;

@SpringBootApplication
public class AlgorithmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgorithmsApplication.class, args);

		Array1<Integer> myArr = new Array1<>();
		myArr.addElem(1);
		myArr.addElem(2);


		System.out.println(myArr.isEmpty());
		for (Object object : myArr) {
			System.out.println(object);
		}

		System.out.println(myArr.size());
	}






}
