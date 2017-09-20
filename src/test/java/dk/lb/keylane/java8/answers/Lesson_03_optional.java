package dk.lb.keylane.java8.answers;


import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

import dk.lb.keylane.java8.exercises.Lesson_03_optional.Person;


public class Lesson_03_optional {

	public static class Person {

		String name;

		String interests;

		public Person(String name, Optional<String> interests) {
			this.name = name;
			this.interests = interests.orElse(null);
		}

		public String getName() {
			return name;
		}

		public Optional<String> getInterests() {
			return Optional.ofNullable(interests);
		}

	}

	
	@Test
	public void optionalsAreOptional() {
		Optional<String> optional = Optional.ofNullable(null); 

		String value = optional.orElse("UNDEFINED");

		assertEquals("UNDEFINED", value);
	}

	@Test
	public void optionalsGiveYouSemantic() {
		Person lars = new Person("Lars", Optional.of("Running"));
		boolean larsHasInteresets = lars.getInterests().isPresent();  // FIXME: how to check if Lars has any interests?
		assertTrue(larsHasInteresets);
		
		Person lene = new Person("Lene", Optional.ofNullable(null)); // FIXME: how to avoid a NullPointer exception - the API forbids a null value here
		boolean leneHasInterests = lene.getInterests().isPresent(); // FIXME: how to check if lene has any interests
		assertFalse(leneHasInterests);
	}

}