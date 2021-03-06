package dk.lb.keylane.java8.exercises;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * Inspired by: The Pragmatic Bookshelf. “PragPub 2017-09: Issue #99”. iBooks.
 * 
 * @author agatanoair
 *
 */
public class Lesson_04_challenge {

	// Refactor the following code into a more functional style

	@Test
	public void refactorIntoFunctionalStyle() throws IOException {
		
		
		BufferedReader reader = new BufferedReader(new FileReader("./src/test/java/dk/lb/keylane/java8/exercises/Lesson_04_challenge.java"));
		long count = 0;
		String line = null;
		while ((line = reader.readLine()) != null) {
			for (String word : line.split(" ")) {
				if (word.contains("class")) {
					count++;
				}

			}
		}
		reader.close();
		assertEquals(2, count);
	}



	// find max in parallel
	@Test
	public void java8_parallelFindMax() {
		List<Integer> data = Arrays.asList(0, 1, 3, 34, 56, 99, 123, 21, 34, 54, 22, 1024);

		int max = -1; // FIXME: take a look at Collection.parallelStream and use
						// it's max method.

		assertEquals(1024, max);
	}

	@Test
	public void testSerialToParallel() {
		IntStream range = IntStream.range(0, 100);
		
		//FIXME write a method to compute sum of squares in parallel. Hint can you use reduce?
		// assertEquals(328350, sumOfSquares(100));
	}
}

