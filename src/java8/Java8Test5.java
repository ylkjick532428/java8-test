package java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Java8Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "addf", "dfd", "", "dfdd");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println(filtered);
		Java8Test5.test1();
		Java8Test5.test2();
		Java8Test5.test3();
		Java8Test5.test4();
		Java8Test5.test5();
		Java8Test5.test6();
		Java8Test5.test7();
		Java8Test5.test8();
		
	}
	
	/**
	 * for each 
	 */
	public static void test1() {
		System.out.println("test1, for each");
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);
	}
	
	/**
	 * map
	 */
	public static void test2() {
		System.out.println("test2, map");
		List<Integer> numbers = Arrays.asList(2, 4, 5, 6, -5, 3);
		List<Integer> squaresList = numbers.stream().map(i -> i*i).distinct().collect(Collectors.toList());
		System.out.println(squaresList);
	}
	
	/**
	 * filter
	 */
	public static void test3() {
		System.out.println("test3, filter");
		List<String> strings = Arrays.asList("1", "2", "344", "334", "342", "dd");
		int count = (int) strings.stream().filter(string -> !string.isEmpty()).count();
		System.out.println(count);
	}
	
	/**
	 * limit
	 */
	public static void test4() {
		System.out.println("test4, limit");
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);
	}
	
	/**
	 * sorted
	 */
	public static void test5() {
		System.out.println("test5, sorted");
		Random random = new Random();
		random.ints().limit(10).sorted().forEach(System.out::println);
	}
	
	/**
	 * parallel processing
	 */
	public static void test6() {
		System.out.println("test6, parallel processing");
		List<String> strings = Arrays.asList("1bdf", "dfd", "dfdf", "dfdf", "dfdw", "d23");
		int count = (int) strings.parallelStream().filter(string -> string.isEmpty()).count();
	}
	
	/**
	 * Collectors
	 */
	public static void test7() {
		System.out.println("test7, Collectors");
		List<String> strings = Arrays.asList("dfdf", "dfddf", "", "dfdf2", "d22d");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		
		System.out.println("Filtered List:" + filtered);
		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("Merged String: " + mergedString);

	}
	
	/**
	 * Statistics
	 */
	public static void test8() {
		List<Integer> numbers = Arrays.asList(2,4,5,6,78,9,0);
		List<Integer> integers = Arrays.asList(2,4,5,6,78,9,0);
		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
		
		System.out.println(stats.getAverage());
		System.out.println(stats.getCount());
	}
}
