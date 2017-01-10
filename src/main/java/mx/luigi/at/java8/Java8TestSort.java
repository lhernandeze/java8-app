package mx.luigi.at.java8;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java8TestSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Instant start = null;
		Instant end   = null;
				
		List <String>names1 = new ArrayList<String>();
		names1.add("Mahesh ");
		names1.add("Suresh ");
		names1.add("Ramesh ");
		names1.add("Naresh ");
		names1.add("Kalpesh ");

		List <String>names2 = new ArrayList<String>();
		names2.add("Mahesh ");
		names2.add("Suresh ");
		names2.add("Ramesh ");
		names2.add("Naresh ");
		names2.add("Kalpesh ");

		//do sort
		Java8TestSort test = new Java8TestSort();
		
		//do Java 7 sintax
		start = Instant.now();
		test.sortUsingJava7(names1);
		end = Instant.now();
		System.out.println("Sort using Java 7 syntax, duration: " + Duration.between(start, end));
		// using new operator TreeSet::new
		names1.forEach(System.out::println);
		
		//do Java 8 sintax
		start = Instant.now();
		test.sortUsingJava8(names2);
		end = Instant.now();
		System.out.println("Sort using Java 8 syntax, duration: " + Duration.between(start, end));
		// using new operator TreeSet::new
		names1.forEach(System.out::println);
		

	}

	// sort using Java7
	private void sortUsingJava7(List<String> names) {
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
	}

	// sort using Java8
	private void sortUsingJava8(List<String> names) {
		Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
	}

}
