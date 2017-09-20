package dk.lb.keylane.java8.lessons;

import java.util.Arrays;
import java.util.stream.Stream;

public class Lesson_04_streams_and_collections {
	
	public static void main(String[] args) {
		// can create a stream using the of method
		Stream<Integer> stream = Stream.of(100, 200, 300);
		
		//another way of obatining a stream
		String[] names = {"Bart", "Lisa", "Maggie"};
		Stream<String> stream2 = Stream.of(names);
		
		Stream<String> stream3 = Arrays.stream(names);
		
		
		System.out.println(stream);
	}

}


/*
	Let’s imagine that we need to print all authors in a books collection who wrote a book after 2005. 
	And how would we do it in Java 8?


	books.stream()
	       .filter(book -> book.year > 2005)  // filter out books published in or before 2005
	       .map(Book::getAuthor)              // get the list of authors for the remaining books
	       .filter(Objects::nonNull)          // remove null authors from the list
	       .map(Author::getName)              // get the list of names for the remaining authors
	       .forEach(System.out::println);     // print the value of each remaining element*/