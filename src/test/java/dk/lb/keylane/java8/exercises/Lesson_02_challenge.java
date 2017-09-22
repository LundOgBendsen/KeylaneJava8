package dk.lb.keylane.java8.exercises;

import static org.junit.Assert.assertNotNull;

import java.util.function.Supplier;

import org.junit.Test;

import dk.lb.keylane.java8.domain.LifePolicy;

public class Lesson_02_challenge {

	
	@Test
	public void writeALifePolicySupplier() throws Exception {
		
		//we have a static method in lifePolicy called getSomePolicies ... let us implement the Supplier interface instead
		Supplier<LifePolicy> policySupplier = () -> null; //FIXME supply a policy
		
		LifePolicy policy = null; // FIXME use the policySupplier to create a policy
		assertNotNull( policy );
		
	}
    
}

