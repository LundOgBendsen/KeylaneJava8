package dk.lb.keylane.java8.exercises;

import static org.junit.Assert.*;

import org.junit.Test;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.TestSubscriber;

public class Lesson_02_challenge {

	
	@Test
	public void helloRx() throws Exception {
		
		Observable.just("Hello world").subscribe(System.out::println);
		
		Observable.range(1, 10)
		  .observeOn(Schedulers.computation())
		  .map(v -> v * v)
		  .blockingSubscribe(System.out::println);
		
	}
	
	// advanced comparator
	// FIXME: take a look the the comparing static method on Comparator. Pass in the method reference for getPolicyId() .
				// This creates one comparator. 
				//Append another one by using the default method thenComparing and use the getRole
				// method for comparing.
	
	
	
    /**
     * Observables are ultimately about handling "streams" of items (i.e. more than one item) in a "data pipeline".
     * Each item is called an "event" of "data". Here we have the creation of a new stream of data/events,
     * called an Observable. (http://reactivex.io/RxJava/javadoc/rx/Observable.html)
     * We also have a subscription, which finally takes the values from the pipeline and consumes them.
     * <p>
     * For our RxJava tests, we will be working with an object called TestSubscriber which the framework includes.
     * It gives us an easy way to check what was emitted on the pipeline.
     */
//    @Test
//    public void _1_anObservableStreamOfEventsAndDataEmitsEachItemInOrder() {
//    	 TestSubscriber mSubscriber = new TestSubscriber<>();
//        Observable<String> pipelineOfData = Observable.just("Functional", "programming", "is", "fun");
//        pipelineOfData.subscribe(mSubscriber);
//        List<Object> dataEmitted = mSubscriber.getOnNextEvents();
//        assertThat(dataEmitted).hasSize(____);
//        assertThat(dataEmitted).containsOnlyOnce(_____);
//        assertThat(dataEmitted).containsOnlyOnce(_____);
//    }

	
	 /**
     * An observable stream calls 3 major lifecycle methods as it does it's work:
     * onNext(), onCompleted(), and onError().
     * <p>
     * onNext():
     * An Observable calls this method whenever the Observable emits an item.
     * This method takes as a parameter the item emitted by the Observable.
     * <p>
     * onError():
     * An Observable calls this method to indicate that it has failed to generate the expected data
     * or has encountered some other error.
     * This stops the Observable and it will not make further calls to onNext or onCompleted.
     * The onError method takes as its parameter an indication of what caused the error.
     * <p>
     * onCompleted():
     * An Observable calls this method after it has called onNext for the final time,
     * if it has not encountered any errors.
     */
    @Test
    public void _2_anObservableStreamEmitsThreeMajorEventTypes() {
//        Observable<Integer> pipelineOfData = Observable.just(1, 2, 3, 4, 5);
//        int counter = 0, completed = 0, errors = 0;
//		pipelineOfData.doOnNext(integer -> counter ++)
//                .doOnCompleted(() -> completed++)
//                .doOnError(throwable -> mCount3++)
//                .subscribe(mSubscriber);
//        mSubscriber.awaitTerminalEvent();
//        assertThat(counter).isEqualTo(____);
//        assertThat(mCount2).isEqualTo(____);
//        assertThat(mCount3).isEqualTo(____);
    }
	
    
    
}


// reactive runner  

// reactive + subscribe in parallel + error handling

// comparator