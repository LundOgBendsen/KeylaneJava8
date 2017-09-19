package dk.lb.keylane.java8.exercises;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

import org.junit.Test;

// 2 programmeringsopgaver + *opgave

public class Lesson_01_java_lambdas {
	
	//default method in interface
	
	//lambda 
	
	//more lambda
	
	// try the for each
	

	@Test
	public void java8_iterateOverCollection() {
		IntStream numbers = IntStream.rangeClosed(1, 10);
		LongAdder adder = new LongAdder();

		numbers.forEach(number -> {
		}); // FIXME: add the number to the adder

		assertEquals( 55, adder.sum());
	}
	
	@Test
	public void predicateLetsYouHaveLunch() {
		List<String> hungryPeople =  Arrays.asList("Anders", "Bent", "Casper", "Dennis", "Eva");

		// FIXME: take a look at the removeIf method and pass in a predicate the is only true if the name is of other length than 4
		hungryPeople.removeIf(null);

		assertEquals(4, hungryPeople );
		assertThat( hungryPeople, not(hasItem("Bent")) );
	}
	
	
	

}
