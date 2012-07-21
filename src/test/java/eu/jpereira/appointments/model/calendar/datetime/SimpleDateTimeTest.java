package eu.jpereira.appointments.model.calendar.datetime;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

import eu.jpereira.appointments.model.calendar.datetime.SimpleDateTime;

public class SimpleDateTimeTest {

	@Test
	public void testValueOf() {

		SimpleDateTime dateTime = SimpleDateTime.valueOf("12/12/2001 9:00");

		assertEquals(9, dateTime.getHour());
		assertEquals(0, dateTime.getMinute());

		assertEquals(12, dateTime.getDay());
		assertEquals(12, dateTime.getMonth());
		assertEquals(2001, dateTime.getYear());

	}

	@Test
	public void testEqualsNull() {
		SimpleDateTime dateTime = SimpleDateTime.valueOf("12/12/2001 9:00");

		assertFalse(dateTime.equals(null));

	}

	@Test
	public void testEqualsSameRef() {
		SimpleDateTime dateTime = SimpleDateTime.valueOf("12/12/2001 9:00");
		SimpleDateTime dateTime2 = dateTime;

		assertTrue(dateTime.equals(dateTime2));

	}

	@Test
	public void testDifferent() {
		SimpleDateTime dateTime = SimpleDateTime.valueOf("12/12/2001 9:00");
		SimpleDateTime dateTime2 = SimpleDateTime.valueOf("12/12/2002 9:00");

		assertFalse(dateTime.equals(dateTime2));

	}

	@Test
	public void testEquals() {
		SimpleDateTime dateTime = SimpleDateTime.valueOf("12/12/2001 9:00");
		SimpleDateTime dateTime2 = SimpleDateTime.valueOf("12/12/2001 9:00");

		assertTrue(dateTime.equals(dateTime2));
		assertEquals(dateTime.hashCode(), dateTime2.hashCode());

	}

	@Test
	public void testComparableEquals() {
		SimpleDateTime dateTime = SimpleDateTime.valueOf("12/12/2001 9:00");
		SimpleDateTime dateTime2 = SimpleDateTime.valueOf("12/12/2001 9:00");

		assertEquals(0, dateTime.compareTo(dateTime2));
	}

	@Test
	public void testComparableLessThan() {
		SimpleDateTime dateTime = SimpleDateTime.valueOf("12/12/2001 9:00");
		SimpleDateTime dateTime2 = SimpleDateTime.valueOf("12/12/2001 9:59");

		assertTrue(dateTime.compareTo(dateTime2) < 0);
	}

	@Test
	public void testComparableLessThan2() {
		SimpleDateTime dateTime = SimpleDateTime.valueOf("1/1/2001 9:30");
		SimpleDateTime dateTime2 = SimpleDateTime.valueOf("12/12/2001 9:00");

		assertTrue(dateTime.compareTo(dateTime2) < 0);
	}

	@Test
	public void testComparableGreaterThan() {
		SimpleDateTime dateTime = SimpleDateTime.valueOf("12/12/2001 9:01");
		SimpleDateTime dateTime2 = SimpleDateTime.valueOf("12/12/2001 9:00");
		assertTrue(dateTime.compareTo(dateTime2) > 0);
	}

}
