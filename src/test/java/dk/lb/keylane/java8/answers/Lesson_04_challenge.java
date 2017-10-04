package dk.lb.keylane.java8.answers;

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
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
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
		
		Stream<String> lines = Files.lines( Paths.get("./src/test/java/dk/lb/keylane/java8/exercises/Lesson_04_challenge.java"));
		long count = lines.filter( s-> s.contains("class")).count();
		
		assertEquals(2, count);
	}


	
	// find max in parallel
	@Test
	public void java8_parallelFindMax() {
		List<Integer> data = Arrays.asList(0, 1, 3, 34, 56, 99, 123, 21, 34, 54, 22, 1024);

		Optional<Integer> max = data.parallelStream().max(Integer::compare); 
		// FIXME: take a look at Collection.parallelStream and use
						// it's max method.

		assertEquals(1024, (int) max.get());
	}

	@Test
	public void testSerialToParallel() {
		
		Function<Integer, Integer> sumOfSquares = (i) ->  IntStream.range(0,i).parallel().map(a -> a*a).reduce(0, Math::addExact);
		//FIXME write a method to compute sum of squares in parallel. Hint can you use reduce?
		 assertEquals(328350, (long) sumOfSquares.apply(100));
	}
}

