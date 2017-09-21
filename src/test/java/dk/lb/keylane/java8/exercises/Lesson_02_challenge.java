package dk.lb.keylane.java8.exercises;

import static org.junit.Assert.*;

import java.util.function.Supplier;

import org.junit.Test;

import dk.lb.keylane.java8.domain.LifePolicy;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class Lesson_02_challenge {

	
	@Test
	public void writeALifePolicySupplier() throws Exception {
		
		//we have a static method in lifePolicy called getSomePolicies ... let us implement the Supplier interface instead
		Supplier<LifePolicy> policySupplier = () -> null; //FIXME supply a policy
		
		LifePolicy policy = null; // FIXME use the policySupplier to create a policy
		assertNotNull( policy );
		
	}
	
	@Test
	public void helloRx() throws Exception {
		
		Observable.just("Hello world").subscribe(System.out::println);
		
		Observable.range(1, 10)
		  .observeOn(Schedulers.computation())
		  .map(v -> v * v)
		  .blockingSubscribe(System.out::println);
		
		//TODO explain this code and write a unit test to assert correctness
		
	}
	



    
}

