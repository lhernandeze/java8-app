package mx.luigi.at.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Java8TestPredicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,0);
		
		//sorted list
		Collections.sort(list, (s1,s2) -> s1.compareTo(s2));
		
		System.out.println("Print all numbers:");
		// Predicate<Integer> predicate = n -> true
		// test if n is integer, pass true
		//pass n as parameter
		eval(list, n->true);
		
		System.out.println("Print even numbers:");
		//Predicate<Integer> predicate = n -> n%2 == 0
		//return true if n%2 comes to be zero
		eval(list,n -> n%2 == 0);
		
		System.out.println("Print numbers greater than 3:");
		//Predicate<Integer> predicate = n -> n > 3
		//return true if n is greater than 3
		eval(list, n -> n > 3);
		
	}

	public static void eval(List<Integer> list, Predicate<Integer> predicate) {
		for (Integer i : list) {
			if (predicate.test(i)) {
				System.out.println(i + " ");
			}
		}
	}

}
