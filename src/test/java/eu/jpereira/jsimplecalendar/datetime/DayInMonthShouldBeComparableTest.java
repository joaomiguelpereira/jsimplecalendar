package eu.jpereira.jsimplecalendar.datetime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DayInMonthShouldBeComparableTest {

	@Test
	public void testEqualsReflexive() {
		DayMonthInYear dayOne = DayMonthInYear.valueOf("12/12");
		DayMonthInYear dayTwo = DayMonthInYear.valueOf("12/11");
		assertFalse(dayOne.equals(dayTwo));
		assertFalse(dayTwo.equals(dayOne));
	}

	@Test
	public void testEqualsSameRference() {
		DayMonthInYear dayOne = DayMonthInYear.valueOf("01/01");
		DayMonthInYear daywo = dayOne;
		assertTrue(dayOne.equals(daywo));
	}

	@Test
	public void testNotEqualsNull() {
		DayMonthInYear dayOne = DayMonthInYear.valueOf("12/12");
		assertFalse(dayOne.equals(null));
	}

	@Test
	public void testNotEqualsDifferentObject() {
		DayMonthInYear dayOne = DayMonthInYear.valueOf("12/12");
		assertFalse(dayOne.equals(new Object()));
	}

	@Test
	public void compareEqualDayOnMonth() {
		DayMonthInYear dayOne = DayMonthInYear.valueOf("12/12");
		DayMonthInYear dayTwo = DayMonthInYear.valueOf("12/12");
		assertEquals(0, dayOne.compareTo(dayTwo));
	}

	@Test
	public void compareOneDayGreaterDayMonthy() {
		DayMonthInYear dayOne = DayMonthInYear.valueOf("12/12");
		DayMonthInYear dayTwo = DayMonthInYear.valueOf("11/12");
		assertEquals(1, dayOne.compareTo(dayTwo));
		assertEquals(-1, dayTwo.compareTo(dayOne));
	}

	@Test
	public void compareTreeDaysGreaterDayMonthy() {
		DayMonthInYear dayOne = DayMonthInYear.valueOf("9/12");
		DayMonthInYear dayTwo = DayMonthInYear.valueOf("12/12");
		assertEquals(-3, dayOne.compareTo(dayTwo));
		assertEquals(3, dayTwo.compareTo(dayOne));
	}

	@Test
	public void compareOneMonthGreaterDayMonthy() {
		DayMonthInYear dayOne = DayMonthInYear.valueOf("12/11");
		DayMonthInYear dayTwo = DayMonthInYear.valueOf("12/12");
		assertEquals(-30, dayOne.compareTo(dayTwo));
		assertEquals(30, dayTwo.compareTo(dayOne));
	}

	@Test
	public void compareTwoMonthGreaterDayMonthy() {
		DayMonthInYear dayOne = DayMonthInYear.valueOf("11/10");
		DayMonthInYear dayTwo = DayMonthInYear.valueOf("12/12");
		assertEquals(-61, dayOne.compareTo(dayTwo));
		assertEquals(61, dayTwo.compareTo(dayOne));
	}

	@Test
	public void testHashCode() {
		DayMonthInYear dayInMonth = DayMonthInYear.valueOf("01/02");
		DayMonthInYear dayInMonth_equals = DayMonthInYear.valueOf("01/02");
		assertEquals(dayInMonth.hashCode(), dayInMonth_equals.hashCode());
	}

	@Test
	public void testHashCodeDifferent() {
		DayMonthInYear dayInMonth = DayMonthInYear.valueOf("01/02");
		DayMonthInYear dayInMonth_equals = DayMonthInYear.valueOf("01/03");
		assertFalse(dayInMonth.hashCode() == dayInMonth_equals.hashCode());
	}
}
