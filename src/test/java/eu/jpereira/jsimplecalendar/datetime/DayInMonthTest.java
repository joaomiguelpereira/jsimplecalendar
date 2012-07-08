package eu.jpereira.jsimplecalendar.datetime;

import static org.junit.Assert.*;

import org.junit.Test;

import eu.jpereira.appointments.model.calendar.exceptions.InvalidDayOfMonthExpressionException;
import eu.jpereira.jsimplecalendar.datetime.DayInMonth;

public class DayInMonthTest {

	@Test
	public void canGetValueOfValidDayOfMonth() {
		DayInMonth dayOfMonth = DayInMonth.valueOf("12/01");
		assertEquals(12, dayOfMonth.getDay());
		assertEquals(1, dayOfMonth.getMonth());
	}

	@Test
	public void canGetAllValues() {
		for (int m = 1; m <= 12; m++) {
			for (int d = 1; d <= 31; d++) {
				String expression = d + "/" + m;
				@SuppressWarnings("unused")
				DayInMonth dayOfMonth = DayInMonth.valueOf(expression);
				String expressionPadded = (d < 10 ? "0" + d : d) + "/" + (m < 10 ? "0" + m : m);
				dayOfMonth = DayInMonth.valueOf(expressionPadded);

			}
		}
	}

	@Test(expected = InvalidDayOfMonthExpressionException.class)
	public void throwExceptionIncosistentValuesLowerDayBoundary() {
		@SuppressWarnings("unused")
		DayInMonth dayOfMonth = DayInMonth.valueOf("0/1");
	}

	@Test(expected = InvalidDayOfMonthExpressionException.class)
	public void throwExceptionIncosistentValuesUpperDayBoundary() {
		@SuppressWarnings("unused")
		DayInMonth dayOfMonth = DayInMonth.valueOf("32/1");
	}

	@Test(expected = InvalidDayOfMonthExpressionException.class)
	public void throwExceptionIncosistentValuesLowerMonthBoundary() {
		@SuppressWarnings("unused")
		DayInMonth dayOfMonth = DayInMonth.valueOf("1/0");
	}

	@Test(expected = InvalidDayOfMonthExpressionException.class)
	public void throwExceptionIncosistentValuesUpperMonthBoundary() {
		@SuppressWarnings("unused")
		DayInMonth dayOfMonth = DayInMonth.valueOf("1/13");
	}

	@Test(expected = InvalidDayOfMonthExpressionException.class)
	public void throwExceptionInvalidValues() {
		@SuppressWarnings("unused")
		DayInMonth dayOfMonth = DayInMonth.valueOf("12-b");
	}

	@Test(expected = InvalidDayOfMonthExpressionException.class)
	public void throwExceptionInvalidIntegerValues() {
		@SuppressWarnings("unused")
		DayInMonth dayOfMonth = DayInMonth.valueOf("12/b");
	}

	@Test
	public void testEqualsReflexive() {
		DayInMonth dayOne = DayInMonth.valueOf("12/12");
		DayInMonth dayTwo = DayInMonth.valueOf("12/11");
		assertFalse(dayOne.equals(dayTwo));
		assertFalse(dayTwo.equals(dayOne));
	}

	@Test
	public void testEqualsSameRference() {
		DayInMonth dayOne = DayInMonth.valueOf("01/01");
		DayInMonth daywo = dayOne;
		assertTrue(dayOne.equals(daywo));
	}

	@Test
	public void testNotEqualsNull() {
		DayInMonth dayOne = DayInMonth.valueOf("12/12");
		assertFalse(dayOne.equals(null));
	}

	@Test
	public void testNotEqualsDifferentObject() {
		DayInMonth dayOne = DayInMonth.valueOf("12/12");
		assertFalse(dayOne.equals(new Object()));
	}

	@Test
	public void compareEqualDayOnMonth() {
		DayInMonth dayOne = DayInMonth.valueOf("12/12");
		DayInMonth dayTwo = DayInMonth.valueOf("12/12");
		assertEquals(0, dayOne.compareTo(dayTwo));
	}

	@Test
	public void compareOneDayGreaterDayMonthy() {
		DayInMonth dayOne = DayInMonth.valueOf("12/12");
		DayInMonth dayTwo = DayInMonth.valueOf("11/12");
		assertEquals(1, dayOne.compareTo(dayTwo));
		assertEquals(-1, dayTwo.compareTo(dayOne));
	}

	@Test
	public void compareTreeDaysGreaterDayMonthy() {
		DayInMonth dayOne = DayInMonth.valueOf("9/12");
		DayInMonth dayTwo = DayInMonth.valueOf("12/12");
		assertEquals(-3, dayOne.compareTo(dayTwo));
		assertEquals(3, dayTwo.compareTo(dayOne));
	}

	@Test
	public void compareOneMonthGreaterDayMonthy() {
		DayInMonth dayOne = DayInMonth.valueOf("12/11");
		DayInMonth dayTwo = DayInMonth.valueOf("12/12");
		assertEquals(-30, dayOne.compareTo(dayTwo));
		assertEquals(30, dayTwo.compareTo(dayOne));
	}

	@Test
	public void compareTwoMonthGreaterDayMonthy() {
		DayInMonth dayOne = DayInMonth.valueOf("11/10");
		DayInMonth dayTwo = DayInMonth.valueOf("12/12");
		assertEquals(-61, dayOne.compareTo(dayTwo));
		assertEquals(61, dayTwo.compareTo(dayOne));
	}

	@Test
	public void testHashCode() {
		DayInMonth dayInMonth = DayInMonth.valueOf("01/02");
		DayInMonth dayInMonth_equals = DayInMonth.valueOf("01/02");
		assertEquals(dayInMonth.hashCode(), dayInMonth_equals.hashCode());
	}

	@Test
	public void testHashCodeDifferent() {
		DayInMonth dayInMonth = DayInMonth.valueOf("01/02");
		DayInMonth dayInMonth_equals = DayInMonth.valueOf("01/03");
		assertFalse(dayInMonth.hashCode() == dayInMonth_equals.hashCode());
	}
}
