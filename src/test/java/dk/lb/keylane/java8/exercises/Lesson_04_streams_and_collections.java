package dk.lb.keylane.java8.exercises;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import dk.lb.keylane.java8.domain.LifePolicy;
import dk.lb.keylane.java8.domain.LifePolicy.LifePolicyStatus;

/**
 * Inspired by://ressource :
 * https://technologyconversations.com/2014/11/04/java-8-streams-micro-katas/
 * 
 * @author agatanoair
 *
 */

public class Lesson_04_streams_and_collections {
	
	@Test
	public void allUsersAreUpperCase() throws Exception {
		List<LifePolicy> policies = LifePolicy.getSomePolicies(3);
		
		// FIXME convert the field user in LifePolicy to upper case
		// answers = policies.forEach()....;
		
		policies.forEach( 
				policy -> assertEquals( policy.getUser(), policy.getUser().toUpperCase())
				);
	}

	@Test
	public void convertIdsToPoliciesWithMap() throws Exception {
		IntStream ids = IntStream.of(1, 2, 3, 5, 7);
		
		// FIXME create a list of policies from the supplied id's
		// you can use the mapToObj method on the intstream, and a method reference to the LifePolicy::getPolicyFromId method
		List<LifePolicy> policies = null;
		
		
		assertThat( policies, IsIterableContainingInOrder.contains( 
					LifePolicy.getPolicyFromId(1), 
					LifePolicy.getPolicyFromId(2),
					LifePolicy.getPolicyFromId(3),
					LifePolicy.getPolicyFromId(5),
					LifePolicy.getPolicyFromId(7))
				 ); 
	}


	@Test
	public void howManyPoliciesAreValidUsingReduce() {
		List<LifePolicy> policies = LifePolicy.getSomePolicies(15);
		
		// FIXME: you have to use reduce. Write an accumulator that sums valid policies.
		// sum = policies.stream().map().reduce(sum, ... );
		int sum = 0;
		
		assertEquals(7, sum);
	}
	
	@Test
	public void howManyPeopleHaveTheLastNameOlsen() throws Exception {
		List<LifePolicy> policies = LifePolicy.getSomePolicies(8);
		
		// FIXME: use filter and a collector to find out how many policies have a user, whose name contains "Olsen"
		// sum = policies.stream().filter(...).collect(...)
		long sum =0;
		
		assertEquals(3, sum);
	}


}
