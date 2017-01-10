package mx.luigi.at.java8;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Java8TestStreams {
	
	public static void main(String args[]) {
		Instant start = null;
		Instant end   = null;
		
		// build String list & numbers
		List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl", "xwyz");
		List<Integer> numbers = Arrays.asList(3,4,5,2,1,7,3,8,9,0,1);
		List<Integer> integers = Arrays.asList(122,234,12,1,34,67,77,90,2,4);
		
		// operations using Java7
		start = Instant.now();
		operationsUsingJava7(list, numbers, integers);
		end = Instant.now();
		System.out.println("Operations Using Java7 in [" + Duration.between(start, end) + "]");
		System.out.println("");
		//operations using Java8
		Java8TestStreams streams = new Java8TestStreams();
		start = Instant.now();
		streams.operationsUsingJava8(list, numbers, integers);
		end = Instant.now();
		System.out.println("Operations Using Java8 in [" + Duration.between(start, end) + "]");
	}
	
	public static void operationsUsingJava7(List<String> list, List<Integer> numbers, List<Integer> integers) {
		
		Instant start = null;
		Instant end   = null;
		
		// use Java 7 sintax
		System.out.println("************* Use Java 7 sintax ************");
		System.out.println("String List: " + list);
		System.out.println("Number List: " + numbers);
		System.out.println("Integer List: " + integers);
		System.out.println("************************");
		
		//count empty String
		start = Instant.now();
		long count = getCountEmptyStringUsingJava7(list);
		end = Instant.now();
		System.out.println("Empty Strings: " + count + " in [" + Duration.between(start, end) + "]");
		System.out.println("************************");
		
		//count Strings with specific lenght
		start = Instant.now();
		count = getContentLenghtUsingJava7(list, 3);
		end = Instant.now();
		System.out.println("Strings of lenght 3: " + count + " in [" + Duration.between(start, end) + "]");
		System.out.println("************************");
		
		//filtered list, delete empty strings
		start = Instant.now();
		List<String> filteredList = deleteEmptyStringUsingJava7(list);
		end = Instant.now();
		System.out.println("Filtered List (" + filteredList + ") in [" + Duration.between(start, end) + "]");
		System.out.println("************************");
		
		//eliminate empty string and join using coma ,
		start = Instant.now();
		String mergedString = getMergedStringUsingJava7(list, ", ");
		end = Instant.now();
		System.out.println("Merged String (" + mergedString + ") in [" + Duration.between(start, end) + "]");
		System.out.println("************************");
		
		//get list of square of different numbers
		start = Instant.now();
		List<Integer> squareList = getSquares(numbers);
		end = Instant.now();
		System.out.println("Square List (" + squareList + ") in [" + Duration.between(start, end) + "]");
		System.out.println("************************");
		
		//different operations with numbers:
		start = Instant.now();
		System.out.println("List of Numbers: " + integers);
		System.out.println("Higest number in List: " + getMax(integers));
		System.out.println("Lowest number in List: " + getMin(integers));
		System.out.println("Sum of all number: " + getSum(integers));
		System.out.println("Average: " + getAverage(integers));
		//print 10 random numbers
		Random random = new Random();
		System.out.println("Random Numbers: ");
		for (int i=0; i<10; i++) {
			System.out.println(random.nextInt());
		}
		end = Instant.now();
		System.out.println("Different Operations with numbers in [" + Duration.between(start, end) + "]");
		System.out.println("************************");
	}
	
	public void operationsUsingJava8(List<String> list, List<Integer> numbers, List<Integer> integers) {
		
		Instant start = null;
		Instant end   = null;
		
		// use Java 8 sintax
		System.out.println("++++++++++++++++++++++ Use Java 8 sintax ++++++++++++++++++++++");
		System.out.println("String List: " + list);
		System.out.println("Number List: " + numbers);
		System.out.println("Integer List: " + integers);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		//count empty String
		start = Instant.now();
		long count = list.stream().filter(string->string.isEmpty()).count();
		end = Instant.now();
		System.out.println("Empty Strings: " + count + " in [" + Duration.between(start, end) + "]");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		//count Strings with specific lenght
		start = Instant.now();
		count = list.stream().filter(string->string.length() == 3).count();
		end = Instant.now();
		System.out.println("Strings of lenght 3: " + count + " in [" + Duration.between(start, end) + "]");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		//filtered list, delete empty strings
		start = Instant.now();
		List<String> filteredList = list.stream().filter(string->!string.isEmpty()).collect(Collectors.toList());
		end = Instant.now();
		System.out.println("Filtered List (" + filteredList + ") in [" + Duration.between(start, end) + "]");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		//eliminate empty string and join using coma ,
		start = Instant.now();
		String mergedString = list.stream().filter(string->!string.isEmpty()).collect(Collectors.joining(", "));
		end = Instant.now();
		System.out.println("Merged String (" + mergedString + ") in [" + Duration.between(start, end) + "]");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		//get list of square of different numbers
		start = Instant.now();
		List<Integer> squareList = numbers.stream().map(i-> i*i).distinct().collect(Collectors.toList());
		end = Instant.now();
		System.out.println("Square List (" + squareList + ") in [" + Duration.between(start, end) + "]");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		//different operations with numbers:
		start = Instant.now();
		System.out.println("List of Numbers: " + integers);
		IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();
		
		System.out.println("Higest number in List: " + stats.getMax());
		System.out.println("Lowest number in List: " + stats.getMin());
		System.out.println("Sum of all number: " + stats.getSum());
		System.out.println("Average: " + stats.getAverage());
		//print 10 random numbers
		Random random = new Random();
		System.out.println("Random Numbers: ");
		random.ints().limit(10).sorted().forEach(System.out::println);
		end = Instant.now();
		System.out.println("Different Operations with numbers in [" + Duration.between(start, end) + "]");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		//parallel processing
		start = Instant.now();
		count = list.parallelStream().filter(string-> string.isEmpty()).count();
		end = Instant.now();
		System.out.println("Empty Strings using Parallel Process: " + count + " in [" + Duration.between(start, end) + "]");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	private static int getCountEmptyStringUsingJava7(List<String> list) {
		int count = 0;
		for (String s: list) {
			if (s.isEmpty()) count++;
		}
		return count;
	}
	
	private static int getContentLenghtUsingJava7(List<String> list, int lenght) {
		int count = 0;
		for (String s: list) {
			if (s.length() == lenght) {
				count++;
			}
		}
		return count;
	}
	
	private static List<String> deleteEmptyStringUsingJava7(List<String> list) {
		List<String> filteredList = new ArrayList<String>();
		for (String s: list) {
			if (!s.isEmpty()) filteredList.add(s);
		}
		return filteredList;
	}
	
	private static String getMergedStringUsingJava7(List<String> list, String separator) {
		StringBuilder s = new StringBuilder();
		for (String string: list) {
			if (!string.isEmpty()) {
				s.append(string).append(separator);
			}
		}
		String merged = s.toString();
		return merged.substring(0, merged.length()-2);
	}
	
	private static List<Integer> getSquares(List<Integer> numbers) {
		List<Integer> squareList = new ArrayList<Integer>();
		for (Integer n: numbers) {
			Integer square = new Integer(n.intValue() * n.intValue());
			if (!squareList.contains(square)) {
				squareList.add(square);
			}
		}
		return squareList;
	}
	
	private static int getMax(List<Integer> integers) {
		int max = integers.get(0);
		for (Integer number: integers) {
			if (number.intValue() > max) max = number.intValue();
		}
		return max;
	}
	
	private static int getMin(List<Integer> integers) {
		int min = integers.get(0);
		for (Integer number: integers) {
			if (number.intValue() < min) min = number.intValue();
		}
		return min;
	}
	
	private static int getSum(List<Integer> integers) {
		int sum = integers.get(0);
		for (Integer number: integers) {
			sum+=number;
		}
		return sum;
	}
	
	private static int getAverage(List<Integer> numbers) {
		return getSum(numbers) / numbers.size();
	}

}
