package dk.lb.keylane.java8.exercises;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import dk.lb.keylane.java8.domain.LifePolicy;
import dk.lb.keylane.java8.domain.LifePolicy.LifePolicyFactory;
import dk.lb.keylane.java8.domain.LifePolicy.LifePolicyStatus;

public class Lesson_02_method_references {

	@Test
	public void createLifePolicyFactoryUsingMethodReferenceToConstructor() throws Exception {

		LifePolicyFactory factory = null; // FIXME: create a factory using a
											// method reference to the
											// constructror in LifePolicy
		LifePolicy policy = factory.getLifePolicy("Anna", "1", "cpr", LifePolicyStatus.valid);
		assertEquals("Anna", policy.getUser());
	}
	
	

	@Test
	public void simpleReferenceWithForEach() throws Exception {
		
		
		 List<LifePolicy> newPolicies = IntStream.range(0,2).mapToObj(  
				 i -> (LifePolicy) null  //FIXME pass a method reference to the getPolicyFromId method in the class LifePolicy instead of this lambda
				 ).collect(Collectors.toList());
		 
		 assertThat( newPolicies.size(), is(2)); 
		 assertThat( newPolicies, IsIterableContainingInOrder.contains( 
					LifePolicy.getPolicyFromId(0), 
					LifePolicy.getPolicyFromId(1))
				 ); 
		 
	}

	@Test
	public void sortPoliciesUsingAComparator() {
		List<LifePolicy> policies = LifePolicy.getSomePolicies(4);
	
		// FIXME: take a look the the comparing static method on Comparator.
				// Pass in the method reference for getUser() .
				// This creates one comparator.
		Collections.sort(policies, null);	

		assertThat( policies, IsIterableContainingInOrder.contains( 
				LifePolicy.getPolicyFromId(4), 
				LifePolicy.getPolicyFromId(1), 
				LifePolicy.getPolicyFromId(2), 
				LifePolicy.getPolicyFromId(3)) 
				);
	}

	@Test
	public void sortPoliciesUsingAMoreComplexComparator() throws Exception {
		List<LifePolicy> policies = LifePolicy.getSomePolicies(4);
		
		// FIXME: take a look the the comparing static method on Comparator.
		// Pass in the method reference for getState() .
		// This creates one comparator.
		// Append another one by using the default method thenComparing and use
		// the getPersonId()
		// method for comparing.
		
		Collections.sort(policies, null );	
		
		assertThat( policies, IsIterableContainingInOrder.contains(
				LifePolicy.getPolicyFromId(2), 
				LifePolicy.getPolicyFromId(4), 
				LifePolicy.getPolicyFromId(1), 
				LifePolicy.getPolicyFromId(3)) 
				);
	}


}
