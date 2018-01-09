package java8;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Java8Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names1 = new ArrayList<String>();
		names1.add("Mahesh");
		names1.add("Suresh");
		names1.add("Ramesh");
		names1.add("Naresh");
		names1.add("Kalpesh");

		List<String> names2 = new ArrayList<String>();
		names2.add("Mahesh");
		names2.add("Suresh");
		names2.add("Ramesh");
		names2.add("Naresh");
		names2.add("Kalpesh");

		Java8Tester tester = new Java8Tester();
		System.out.println("Sort using Java 7 syntax: ");
		tester.sortUsingJava7(names1);
		System.out.println(names1);

		System.out.println("Sort using Java 8 syntax: ");

		tester.sortUsingJava8(names2);
		System.out.println(names2);

		tester.test2();
	}

	// sort using java 7
	private void sortUsingJava7Back(List<String> names) {
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
	}

	private void sortUsingJava7(List<String> names) {
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
	}

	// sort using java 8
	private void sortUsingJava8Back(List<String> names) {
		Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
	}

	private void sortUsingJava8(List<String> names) {
		Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
	}

	public void test2() {
		MathOperation addition = (int a, int b) -> a + b;

		MathOperation subtraction = (a, b) -> a - b;

		// with return statement along with curly braces
		MathOperation multiplication = (int a, int b) -> {
			return a * b;
		};

		// without return statement and without curly braces
		MathOperation division = (int a, int b) -> a / b;

		System.out.println("10 + 5 = " + this.operate(10, 5, addition));
		System.out.println("10 - 5 = " + this.operate(10, 5, subtraction));
		System.out.println("10 x 5 = " + this.operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + this.operate(10, 5, division));

		// without parenthesis
		GreetingService greetService1 = message -> System.out.println("Hello " + message);

		// with parenthesis
		GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

		greetService1.sayMessage("Mahesh");
		greetService2.sayMessage("Suresh");
	}

	interface MathOperation {
		int operation(int a, int b);
	}

	interface GreetingService {
		void sayMessage(String message);
	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
}