package com.example.demo.practice;

import java.util.Arrays;
import java.util.Comparator;

public class SecondHighestNumber {
	static int[] numberer= {5,6,7,11,12,8,9};
	public static void main(String[] args) {
		Integer values = Arrays.stream(numberer).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(values);
		System.out.println(Arrays.stream(numberer).boxed().sorted(Comparator.reverseOrder()).skip(0).findFirst().get());
	}


}
