package eu.jpereira.jsimplecalendar.datetime;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import eu.jpereira.appointments.model.calendar.exceptions.InvalidDayOfMonthExpressionException;

public class DayInMonthShouldBeCreatedWithExpressionsTest {

	@Test
	public void shoudCreateDayOfMonthFromValidExpression() {
		DayMonthInYear dayOfMonth = DayMonthInYear.valueOf("12/01");
		assertEquals(12, dayOfMonth.getDay());
		assertEquals(1, dayOfMonth.getMonth());
	}

	@Test
	public void shouldReturnValueOfAllValidDayMonthExpressions() {
		for (int m = 1; m <= 12; m++) {
			for (int d = 1; d <= 31; d++) {
				String expression = d + "/" + m;
				@SuppressWarnings("unused")
				DayMonthInYear dayOfMonth = DayMonthInYear.valueOf(expression);
				String expressionPadded = (d < 10 ? "0" + d : d) + "/" + (m < 10 ? "0" + m : m);
				dayOfMonth = DayMonthInYear.valueOf(expressionPadded);

			}
		}
	}

	@Test(expected = InvalidDayOfMonthExpressionException.class)
	public void shouldThrowExceptionWhenDayIsZeroInExpression() {
		@SuppressWarnings("unused")
		DayMonthInYear dayOfMonth = DayMonthInYear.valueOf("0/1");
	}

	@Test(expected = InvalidDayOfMonthExpressionException.class)
	public void shouldThrowExceptionIfDayIsGreaterThanAnyPossibleDay() {
		@SuppressWarnings("unused")
		DayMonthInYear dayOfMonth = DayMonthInYear.valueOf("32/1");
	}

	@Test(expected = InvalidDayOfMonthExpressionException.class)
	public void shoulThrowExceptionWhenMonthIsZero() {
		@SuppressWarnings("unused")
		DayMonthInYear dayOfMonth = DayMonthInYear.valueOf("1/0");
	}

	@Test(expected = InvalidDayOfMonthExpressionException.class)
	public void throwExceptionIncosistentValuesUpperMonthBoundary() {
		@SuppressWarnings("unused")
		DayMonthInYear dayOfMonth = DayMonthInYear.valueOf("1/13");
	}

	@Test(expected = InvalidDayOfMonthExpressionException.class)
	public void throwExceptionInvalidValues() {
		@SuppressWarnings("unused")
		DayMonthInYear dayOfMonth = DayMonthInYear.valueOf("12-b");
	}

	@Test(expected = InvalidDayOfMonthExpressionException.class)
	public void throwExceptionInvalidIntegerValues() {
		@SuppressWarnings("unused")
		DayMonthInYear dayOfMonth = DayMonthInYear.valueOf("12/b");
	}

}
