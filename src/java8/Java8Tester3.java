package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Java8Tester3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		System.out.println(list);
		eval(list, n->true);
		
		eval(list, n-> n%2 == 0);
		
		eval(list, n-> n > 3);
	}
	
	public static void eval(List<Integer> list, Predicate<Integer> predicate) {
		for (Integer n: list) {
			if (predicate.test(n)) {
				System.out.println(n + " ");
			}
		}
	}

}
