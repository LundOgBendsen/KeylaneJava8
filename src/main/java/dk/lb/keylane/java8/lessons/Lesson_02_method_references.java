package dk.lb.keylane.java8.lessons;

import java.util.Arrays;
import java.util.List;

public class Lesson_02_method_references {

	@FunctionalInterface
	interface StringListFormatter {
		String format(String delimiter, List<String> list);
	}

	public static void formatAndPrint(StringListFormatter formatter, String delimiter, List<String> list) {
		String formatted = formatter.format(delimiter, list);
		System.out.println(formatted);
	}

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Don", "King", "Kong");
		//static method reference 
		formatAndPrint(String::join, ", ", names);

	}

}
