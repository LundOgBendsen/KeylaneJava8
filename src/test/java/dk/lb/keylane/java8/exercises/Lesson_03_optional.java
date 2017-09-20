package dk.lb.keylane.java8.exercises;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;


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
		Optional<String> optional = Optional.of(null); // FIXME: find out how to create an optional of null

		String value = optional.orElse("UNDEFINED");

		assertEquals("UNDEFINED", value);
	}

	@Test
	public void optionalsGiveYouSemantic() {
		Person lars = new Person("Lars", Optional.of("Running"));
		boolean larsHasInteresets = false;  // FIXME: how to check if Lars has any interests?
		assertTrue(larsHasInteresets);
		
		Person lene = new Person("Lene", null); // FIXME: Lene does not have any interests, but how do we express that, and avoid a NullPointer exception ?
		boolean leneHasInterests = true; // FIXME:  how to check if lene has any interests
		assertFalse(leneHasInterests);
	}

	

}
