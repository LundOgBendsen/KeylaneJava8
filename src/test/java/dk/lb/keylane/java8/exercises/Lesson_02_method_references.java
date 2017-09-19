package dk.lb.keylane.java8.exercises;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import dk.lb.keylane.java8.domain.LifePolicy;
import dk.lb.keylane.java8.domain.LifePolicy.LifePolicyFactory;
import dk.lb.keylane.java8.domain.LifePolicy.LifePolicyStatus;

// 2 programmeringsopgaver
public class Lesson_02_method_references {

	
	
	
	// comparator
	
		@Test
		public void sortPoliciesUsingAComparator() {
			List<LifePolicy> policies = LifePolicy.getSomePolicies(4);
			List<LifePolicy> expectedAnswers = Arrays.asList(
					new LifePolicy("Anna Pedersen", "1", "010170-4", LifePolicyStatus.valid),
					new LifePolicy("Bent Pedersen", "1", "010170-1", LifePolicyStatus.invalid),
					new LifePolicy("Cecilie Olsen", "1", "010170-2", LifePolicyStatus.valid),
					new LifePolicy("Dennis Hansen", "1", "010170-3", LifePolicyStatus.invalid)
					); 
			

			// FIXME: take a look the the comparing static method on Comparator. Pass in the method reference for getUser .
			// This creates one comparator. 
			Collections.sort( policies, null);

			assertEquals( expectedAnswers, policies);
		}
		
		@Test
		public void sortPoliciesUsingAMoreComplexComparator() throws Exception {
			List<LifePolicy> policies = LifePolicy.getSomePolicies(4);
			List<LifePolicy> expectedAnswers = Arrays.asList(
					new LifePolicy("Bent Pedersen", "1", "010170-1", LifePolicyStatus.invalid),
					new LifePolicy("Dennis Hansen", "1", "010170-3", LifePolicyStatus.invalid),
					new LifePolicy("Cecilie Olsen", "1", "010170-2", LifePolicyStatus.valid),
					new LifePolicy("Anna Pedersen", "1", "010170-4", LifePolicyStatus.valid)
					); 
			// FIXME: take a look the the comparing static method on Comparator. 
			// Pass in the method reference for getState() .
			// This creates one comparator. 
			// Append another one by using the default method thenComparing and use the getUserId()
			// method for comparing.

			assertEquals( expectedAnswers, policies);
		}
		
		@Test
		public void createLifePolicyFactoryUsingMethodReferenceToConstructor() throws Exception {
			
			LifePolicyFactory factory = null;  // FIXME: create a factory using a method reference to the constructror in LifePolicy
			LifePolicy policy = factory.getLifePolicy("Anna", "1", "cpr", LifePolicyStatus.valid);
			
			assertEquals( "Anna", policy.getUser()  );
		}


}
