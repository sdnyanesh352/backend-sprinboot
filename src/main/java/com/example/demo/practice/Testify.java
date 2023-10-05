package com.example.demo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.demo.models.City;
import com.example.demo.models.Student;

public class Testify {
	static int[] numbers= {4,56,76,32,41,70,90,001};
	static String str="itsmemaulee";
	static public List cities= Arrays.asList("Pune","mumbai","kolhapur","Solapur");
	static public List students= new ArrayList();
	
	
	public static void main(String[] args) {
		HashMap<String, List<String>> mp= new HashMap<>();
		mp.put("Maharashtra", Arrays.asList("Pune","Mumbai"));
		mp.put("Bihar", Arrays.asList("Patna","gaya"));
		mp.put("Andhra pradesh", Arrays.asList("Hyderabad"));
		mp.put("UP", Arrays.asList("Ayodhya","sangam"));
		students.add(new Student("Soham","pune","IT"));	
		System.out.println(Testify.SecondHighestNumber(numbers));
		System.out.println("Count of alphabets in given String: "+Testify.countingAlphabets(str));
		System.out.println("NonRepeated Letters: "+Testify.getNonRepeatedLetters(str));
		System.out.println(" "+Testify.rotateElemets(numbers));
		System.out.println("Duplicate chars :"+Testify.countDuplicateChars(str));
		System.out.println("First NonRepeat Elements: "+Testify.firstNonRepeatElements(str));
		ArrayList<String> st= new ArrayList<>();
		System.out.println("State neame is :"+Testify.getStatename(mp, "Pune"));
		
	}																			
	
	//problem 01: Finding Second Highest number in given array using stream/java 8
	public static Integer SecondHighestNumber(int[] arr) {
		
		Integer secondHighest = 0;
		secondHighest= Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		
		return secondHighest;
		
	}
	
	
	//Problem 02: Non repeated  letters
	public static List<String> getNonRepeatedLetters(String s){
		
		return Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(sit->sit.getValue()==1).map(Map.Entry::getKey).collect(Collectors.toList());
		
		
	}
	
	
	
	//problem 03: Counting ocurrence of alphabets in a string
	public static Map countingAlphabets(String stringSequence) {
		
		Map map = null;
		Map<String, Long> collect = Arrays.stream(stringSequence.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		return collect;
		
	}
	
	//Problem : Rotate Elements in the array
	//need fix
	public static  int [] rotateElemets(int[] arr) {
		
		int startIndex=arr[0];
		int lastIndex;
		int times=1;
		for(int i=1;i<startIndex;i++) {
			arr[i]=arr[i++];
			
		}
		return arr;
	}
	
	
	//Problem 05: Duplicate 
	public static List countDuplicateChars(String str) {
		List<String> val = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(p->p.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toList());
        return val;
	}
	
	//find first non repeat element from string
	public static String firstNonRepeatElements(String str) {
		String val = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(p->p.getValue()==1).findFirst().get().getKey();
		return val;
	}
	//find only pune city
	
	/*
	 * public static String findPuneCity() { List<City> citie=
	 * students.stream().forEach(a->if(a.equ)); .filter(ap->ap.
	 * getCity().equals("pune"))
	 * .map(Student::getCity).collect(Collectors.toList()); return citie;
	 * 
	 * }
	 */
	
	//recursive functions
	
	
	//Builder Design Pattern
	
	//Sum in Array of arrays
	
	static int sumArrayOfArrays(int [][] arr) {
		
		//int [][] arr={{1,2,3},{3,4,5},{6,8}};
		
		return Arrays.stream(arr).flatMapToInt(Arrays::stream).sum();
		
		
	}
	
	//get state from city name
	
	static String getStatename(HashMap<String, List<String>> mp, String city) {
		String state = null;
		 mp.entrySet().iterator().next().equals(city);
		 Iterator<Entry<String, List<String>>> itr= mp.entrySet().iterator();
		 while(itr.hasNext()) {
			 Entry<String, List<String>> getval = itr.next();
			 if(getval.getValue().contains(city)) {
				 state= getval.getKey();
				 break;
				 
			 }
		 }
		
		return state;
	}
	
	//getStatename using stream
	static String getStatenameUsingStream(HashMap<String, List<String>> mp, String city) {
		
		return mp.entrySet().stream().filter(p->p.getValue().contains(city)).map(Map.Entry::getKey).findFirst().orElse("");
		
		
	}
	
	

}
