package dk.lb.keylane.java8.answers;

import static org.junit.Assert.*;

import java.time.DayOfWeek;
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
		LocalDateTime date2 = date.plus(durationtoAdd); 
		assertNotSame(date2, date);
	}


	
	@Test
	public void waitingForSaturdayAndAdjustingDatesBySemantic() {
		LocalDate now = LocalDate.of(2017,  9,  22); // FIXME: use the of method to create a date that represents 2017-09-22

		assertEquals(2017, now.getYear());
		assertEquals(9, now.getMonthValue()); 
		assertEquals(22, now.getDayOfMonth()); // it's a Friday

		LocalDate saturday = now.with(TemporalAdjusters.next( DayOfWeek.SATURDAY)); // FIXME: find out how to get the next Saturday.

		assertEquals(2017, saturday.getYear());
		assertEquals(9, saturday.getMonthValue());
		assertEquals(23, saturday.getDayOfMonth());
	}
	
	@Test
	public void weWakeUpInCopenhagenBeforeCalifornia() {
		LocalDateTime copenhagen = ZonedDateTime.now(ZoneId.of("Europe/Copenhagen")).toLocalDateTime(); // FIXME: How do we find out the Zone of Copenhagen?
		LocalDateTime california = ZonedDateTime.now(ZoneId.of("America/Los_Angeles")).toLocalDateTime();

		assertTrue(copenhagen.isAfter(california));
	}
	
	
}
