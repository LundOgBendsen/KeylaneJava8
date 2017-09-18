package dk.lb.keylane.java8;

import java.util.Arrays;
import java.util.stream.Stream;

public class Lesson_04_streams_and_collections {
	
	public static void main(String[] args) {
		// can create a stream using the of method
		Stream<Integer> stream = Stream.of(100, 200, 300);
		
		//another way of obatining a stream
		String[] names = {"Bart", "Lisa", "Maggie"};
		Stream<String> stream2 = Stream.of(names);
		
		Stream<String> stream3 = Arrays.stream(names);
		
		
		System.out.println(stream);
	}

}
