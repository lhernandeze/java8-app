package mx.luigi.at.java8;

import java.util.Optional;

public class Java8TestOptional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Java8TestOptional optional = new Java8TestOptional();
		Integer defaultValue = -1;
		Integer value1 = null;
		Integer value2 = new Integer(10);
		
		//Optional.ofNullable - allows passed parameter to be null
		Optional<Integer> a = Optional.ofNullable(value1);
		
		//Optional.of - throws NullPointerException if passed parameter is null
		Optional<Integer> b = Optional.of(value2);
		
		//sum values
		System.out.println("SUM Optional Values: " + optional.sum(a, defaultValue, b, defaultValue));
		
	}
	
	public Integer sum(Optional<Integer> a, Integer defaultA, Optional<Integer> b, Integer defaultB) {
		//check if the value is present or not - Optional.isPresent
		System.out.println("First parameter is present: " + a.isPresent());
		System.out.println("Second parameter is present: " + b.isPresent());
		
		//Optional.orElse
		//returns the value if present, otherwise return the value passed
		Integer value1 = a.orElse(new Integer(defaultA));
		Integer value2 = b.orElse(new Integer(defaultB));
		// if you sure if the value is present
		//you can get the value using
		// Integer value = a.get();
		
		return value1 + value2;
	}

}
