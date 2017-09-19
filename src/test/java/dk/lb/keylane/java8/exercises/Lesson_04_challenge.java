package dk.lb.keylane.java8.exercises;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;

public class Lesson_04_challenge {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	
	// use an atomicinteger to count iterations in parallel stream
	
	//find max in parallel
	@Test
	public void java8_parallelFindMax() {
		List<Integer> data = Arrays.asList(0, 1, 3, 34, 56, 99, 123, 21, 34, 54, 22, 1024);

		int max = -1; // FIXME: take a look at Collection.parallelStream and use it's max method.

		assertEquals(1024, max);
	}
	
	 @Test
	    public void testSerialToParallel() {
	        IntStream range = IntStream.range(0, 100);
	        //assertEquals(328350, SerialToParallel.sumOfSquares(range));
	    }
}

// 
//ressource: http://winterbe.com/posts/2015/05/22/java8-concurrency-tutorial-atomic-concurrent-map-examples/
