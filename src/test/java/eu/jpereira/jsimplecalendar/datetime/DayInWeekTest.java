package eu.jpereira.jsimplecalendar.datetime;

import static org.junit.Assert.*;
import org.junit.Test;

import eu.jpereira.jsimplecalendar.datetime.DayInWeek;
import eu.jpereira.jsimplecalendar.datetime.exceptions.IllegalDateTimeComponentValueException;

public class DayInWeekTest {

	private static final String[] allowedValues = { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" };

	@Test
	public void testValueOf() {

		for (String allowedValue : allowedValues) {
			DayInWeek.valueOf(allowedValue);
		}
	}
	@Test(expected=IllegalDateTimeComponentValueException.class)
	public void testInvalidValue() throws Throwable {
		DayInWeek.valueOf("Invalid");
	}

	@Test
	public void testEqualsSimetric() {
		DayInWeek d1 = DayInWeek.valueOf("SUNDAY");
		DayInWeek d2 = DayInWeek.valueOf("SUNDAY");
		assertTrue(d1.equals(d2));
		assertTrue(d2.equals(d1));

	}

	@Test
	public void testEqualsReflexive() {
		DayInWeek d1 = DayInWeek.valueOf("SUNDAY");
		assertTrue(d1.equals(d1));
	}

	@Test
	public void testEqualsTransitive() {

		DayInWeek d1 = DayInWeek.valueOf("SUNDAY");
		DayInWeek d2 = DayInWeek.valueOf("SUNDAY");
		DayInWeek d3 = DayInWeek.valueOf("SUNDAY");
		assertTrue(d1.equals(d2) && d2.equals(d3) && d1.equals(d3));

	}

	@Test
	public void testEqualsWithNull() {
		DayInWeek d1 = DayInWeek.valueOf("SUNDAY");
		assertFalse(d1.equals(null));
	}

	@Test
	public void testEqualsDifferent() {
		DayInWeek d1 = DayInWeek.valueOf("SUNDAY");
		assertFalse(d1.equals(DayInWeek.valueOf("MONDAY")));
	}

	@Test
	public void testEqualsDifferentTypes() {
		DayInWeek d1 = DayInWeek.valueOf("SUNDAY");
		assertFalse(d1.equals(new Object()));
	}

	@Test
	public void testHashCode() {
		DayInWeek d1 = DayInWeek.valueOf("SUNDAY");
		DayInWeek d2 = DayInWeek.valueOf("SUNDAY");

		assertTrue(d1.hashCode() == d2.hashCode());

	}

	@Test
	public void testHashCodeDifferent() {
		DayInWeek d1 = DayInWeek.valueOf("SUNDAY");
		DayInWeek d2 = DayInWeek.valueOf("WEDNESDAY");

		assertTrue(d1.hashCode() != d2.hashCode());

	}

}
