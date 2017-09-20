package dk.lb.keylane.java8.answers;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

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
		policies.forEach(  policy -> policyIds.add(policy.getPolicyId())  );
		assertEquals( policyIds, Arrays.asList("1", "2", "3" ) );
		
	}
	
	
	@Test
	public void aFunctionalInterfaceCanBeInstantiatedWithALambdaWithNoArguments() throws Exception {
		
		final AtomicLong counter = new AtomicLong();
		
		Runnable task = () -> counter.incrementAndGet() ;  // Hava a look at the Runnable functional interface
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
		Sum myAdder = (a,b ) -> a+b;
		
		assertEquals(5, myAdder.add(2,3));
	}
	
	

	@Test
	public void iterateOverCollectionWithForEach() {
		IntStream numbers = IntStream.rangeClosed(1, 10);
		LongAdder adder = new LongAdder();
		numbers.forEach(number -> adder.add(number)); 

		assertEquals( 55, adder.sum());
	}
	
	@Test
	public void predicateLetsYouHaveValidPolicies() {
		
		final List<LifePolicy> policies = new ArrayList<LifePolicy>( LifePolicy.getSomePolicies(5));
		
		// FIXME: take a look at the removeIf method and pass in a predicate the is only true if the policy is valid
		policies.removeIf( policy -> LifePolicyStatus.invalid.equals( policy.getStatus() ) );

		assertEquals( 2, policies.size() );
		policies.forEach( policy -> assertEquals(LifePolicyStatus.valid, policy.getStatus() ) );
	}
	

}
