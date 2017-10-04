package dk.lb.keylane.java8.lessons;

import java.util.function.Function;

public class Lesson_01_lambdas {

	// instead of an anonymous inner class
	public static void main(String[] args) {
		
//		// Creating a lambda
//		
//		Runnable task = () -> System.out.println("Hello " + Thread.currentThread().getName()) ;
//
//		task.run();
//
//		Thread thread = new Thread(task);
//		thread.start();
//		
//		System.out.println("Done!");
		
	//	Lets look at the function interface
		Function<Integer, Double> milesToKms =   (input) -> 1.6 * input; //override the S-A-M
		
        int miles = 3;
        double kms = milesToKms.apply(miles); 
        System.out.printf("%d miles = %3.2f kilometers\n",  miles, kms);
		
	}



}
