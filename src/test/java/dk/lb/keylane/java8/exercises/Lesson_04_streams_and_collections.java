package dk.lb.keylane.java8.exercises;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import dk.lb.keylane.java8.domain.LifePolicy;

/**
 * Inspired by://ressource :
 * https://technologyconversations.com/2014/11/04/java-8-streams-micro-katas/
 * 
 * @author agatanoair
 *
 */

public class Lesson_04_streams_and_collections {

	// 4 programmeringsopgaver + 2 *opgave

	// Map
	@Test
	public void convertIdsToPolicies() throws Exception {
		List<Integer> ids = Arrays.asList(1, 2, 3, 5, 7, 11, 13);
		List<LifePolicy> policies = null;
		// FIXME policies = filter policies.stream.map().;
		
		assertEquals( ids.size(), policies.size() ); 
	}

	// to uppercase
	@Test
	public void allUsersAreUpperCase() throws Exception {
		List<LifePolicy> policies = LifePolicy.getSomePolicies(3);
		List<LifePolicy> answers = null;
		// FIXME convert the field user in LifePolicy to upper case
		// answers = policies.stream.map()....;
		
		answers.forEach( 
				policy -> assertEquals( policy.getUser(), policy.getUser().toUpperCase())
				);
	}

	

	@Test
	public void howManyPoliciesAreValidUsingReduce() {
		List<LifePolicy> policies = LifePolicy.getSomePolicies(5);
		int sum = 0;
		// FIXME: you have to use reduce. Write an accumulator that sums valid policies.
		// sum = policies.stream().reduce(sum, ... );

		assertEquals(3, sum);
	}
	
	@Test
	public void howManyPeopleHaveTheLastNameOlsen() throws Exception {
		List<LifePolicy> policies = LifePolicy.getSomePolicies(8);
		int sum = 0;
		
		// FIXME: use filter and a collector to find out how many policies have a user, whose name contains "Olsen"
		// sum = policies.stream().filter(...).collect(...)
		
		assertEquals(3, sum);
	}

	


	// partition by

	// group by

	// collect

	// oldestperson

	// summary statistics

}
