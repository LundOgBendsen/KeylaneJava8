package dk.lb.keylane.java8.exercises;

import static org.junit.Assert.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

import org.junit.Test;

/**
 * Credit for idea: https://github.com/Tasktop/java-8-koans/blob/master/src/test/java/com/tasktop/koans/java8/test/AboutDateTimeAPI.java

 * @author agatanoair
 *
 */
public class Lesson_03_date_time {

	@Test
	public void java8_datesAreImmutable() {
		LocalDateTime date = LocalDateTime.now();
		Duration durationtoAdd = Duration.of(1, ChronoUnit.HOURS);
		LocalDateTime date2 = date; // FIXME: See if you can find a way to add the durationToAdd to the date
		assertNotSame(date2, date);
	}


	
	@Test
	public void waitingForSaturdayAndAdjustingDatesBySemantic() {
		LocalDate now = null; // FIXME: use the of method to create a date that represents 2017-09-22

		assertEquals(2017, now.getYear());
		assertEquals(9, now.getMonthValue()); 
		assertEquals(22, now.getDayOfMonth()); // it's a Friday

		LocalDate saturday = now.with(TemporalAdjusters.next(null)); // FIXME: find out how to get the next Saturday.

		assertEquals(2017, saturday.getYear());
		assertEquals(9, saturday.getMonthValue());
		assertEquals(23, saturday.getDayOfMonth());
	}
	
	@Test
	public void weWakeUpInCopenhagenBeforeCalifornia() {
		ZonedDateTime copenhagen = ZonedDateTime.now(ZoneId.of("")); // FIXME: How do we find out the Zone of Copenhagen?
		ZonedDateTime california = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

		assertTrue(copenhagen.isBefore(california));
	}
	
	
}
