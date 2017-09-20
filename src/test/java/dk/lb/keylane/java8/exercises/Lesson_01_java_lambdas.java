package dk.lb.keylane.java8.exercises;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

import org.junit.Test;

import dk.lb.keylane.java8.domain.LifePolicy;
import dk.lb.keylane.java8.domain.LifePolicy.LifePolicyStatus;


public class Lesson_01_java_lambdas {
	
	@Test
	public void simpleLambda() throws Exception {
		
		final List<LifePolicy> policies = LifePolicy.getSomePolicies(3);
		final List<String> policyIds = new ArrayList<>();
		
		policies.forEach(  policy -> {}  ); // FIXME write a lambda, that adds the policy id to the list policyIds
		
		assertEquals( policyIds, Arrays.asList("1", "2", "3" ) );
		
	}
	
	@Test
	public void iterateOverCollectionWithForEach() {
		IntStream numbers = IntStream.rangeClosed(1, 10);
		LongAdder adder = new LongAdder();
		numbers.forEach( number -> {} );  // FIXME write a lambda, that sums the numbers 1..10, by incrementing the adder. Lookup the LongAdder - hint its threadsafe!
		
		assertEquals( 55, adder.sum());
	}
	
	
	@Test
	public void aFunctionalInterfaceCanBeInstantiatedWithALambdaWithNoArguments() throws Exception {
		
		final AtomicLong counter = new AtomicLong();
		
		Runnable task = () -> {};  //  FIXME Hava a look at the Runnable functional interface, and write a lambda that increments the counter
		assertThat( task.getClass().getSimpleName(), containsString("Lambda") );
		
		IntStream.range(0, 17).forEach( n ->  new Thread(task).run() );
		assertEquals(17, counter.get());
		
	}
	
	@FunctionalInterface
	interface Sum {
	  int add(int a, int b);
	}
	
	@Test
	public void aFunctionalInterfaceCanBeInstantiatedWithALambdaWithSeveralArguments() throws Exception {
		Sum myAdder = (a,b ) -> 0; //FIXME write a lambda, that adds the two arguments a and b	
		assertEquals(5, myAdder.add(2,3));
	}
	
	
	
	@Test
	public void predicateLetsYouHaveValidPolicies() {
		
		final List<LifePolicy> policies = new ArrayList<LifePolicy>( LifePolicy.getSomePolicies(5));
		
		// FIXME: take a look at the removeIf method and pass in a predicate the is only true if the policy is valid
		policies.removeIf( null );

		assertEquals( 2, policies.size() );
		policies.forEach( policy -> assertEquals(LifePolicyStatus.valid, policy.getStatus() ) );
	}
	

}
