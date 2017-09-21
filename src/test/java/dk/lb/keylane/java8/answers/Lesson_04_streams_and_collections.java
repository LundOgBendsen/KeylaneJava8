package dk.lb.keylane.java8.answers;

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
		policies.forEach(  policy -> policy.setUser( policy.getUser().toUpperCase()));
		// FIXME convert the field user in LifePolicy to upper case
		// answers = policies.forEach()....;
		
		policies.forEach( 
				policy -> assertEquals( policy.getUser(), policy.getUser().toUpperCase())
				);
	}

	@Test
	public void convertIdsToPoliciesWithMap() throws Exception {
		IntStream ids = IntStream.of(1, 2, 3, 5, 7);
		List<LifePolicy> policies = ids.mapToObj(LifePolicy::getPolicyFromId).collect(Collectors.toList());
		// FIXME create a list of policies from the supplied id's
		// you can use the mapToObj method on the intstream, and a method reference to the LifePolicy::getPolicyFromId method
		
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
		int sum = policies.stream().map(policy -> policy.getStatus() == LifePolicyStatus.valid?1:0).reduce( 0, (i, j) -> i+j  );
		// FIXME: you have to use reduce. Write an accumulator that sums valid policies.
		// sum = policies.stream().map().reduce(sum, ... );

		assertEquals(7, sum);
	}
	
	@Test
	public void howManyPeopleHaveTheLastNameOlsen() throws Exception {
		List<LifePolicy> policies = LifePolicy.getSomePolicies(8);
		long sum = policies.stream().filter( policy -> policy.getUser().contains("Olsen")).count();
		
		// FIXME: use filter and a collector to find out how many policies have a user, whose name contains "Olsen"
		// sum = policies.stream().filter(...).collect(...)
		
		assertEquals(3, sum);
	}


}
