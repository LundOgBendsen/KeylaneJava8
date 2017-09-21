package dk.lb.keylane.java8.answers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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

		LifePolicyFactory factory = LifePolicy::new; 
		LifePolicy policy = factory.getLifePolicy("Anna", "1", "cpr", LifePolicyStatus.valid);

		assertEquals("Anna", policy.getUser());
	}
	
	

	@Test
	public void simpleReferenceWithForEach() throws Exception {
		
		 List<LifePolicy> newPolicies = IntStream.range(0,2).mapToObj(  LifePolicy::getPolicyFromId 
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
		
		Comparator<LifePolicy> byUser = Comparator.comparing(LifePolicy::getUser);
		Collections.sort(policies, byUser);	

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
		
	
		Comparator<LifePolicy> byStatusThenPersonId = Comparator.comparing(LifePolicy::getStatus).thenComparing(LifePolicy::getPersonId);
		Collections.sort(policies, byStatusThenPersonId );	
		
		assertThat( policies, IsIterableContainingInOrder.contains(
				LifePolicy.getPolicyFromId(2), 
				LifePolicy.getPolicyFromId(4), 
				LifePolicy.getPolicyFromId(1), 
				LifePolicy.getPolicyFromId(3)) 
				);
	}



}
