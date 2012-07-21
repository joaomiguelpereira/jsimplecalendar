package eu.jpereira.jsimplecalendar.datetime;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

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

	
	@Test(expectedExceptions = InvalidDayOfMonthExpressionException.class)
	public void shouldThrowExceptionWhenDayIsZeroInExpression() {
		@SuppressWarnings("unused")
		DayMonthInYear dayOfMonth = DayMonthInYear.valueOf("0/1");
	}

	@Test(expectedExceptions = InvalidDayOfMonthExpressionException.class)
	public void shouldThrowExceptionIfDayIsGreaterThanAnyPossibleDay() {
		@SuppressWarnings("unused")
		DayMonthInYear dayOfMonth = DayMonthInYear.valueOf("32/1");
	}

	@Test(expectedExceptions = InvalidDayOfMonthExpressionException.class)
	public void shoulThrowExceptionWhenMonthIsLessThanOne() {
		@SuppressWarnings("unused")
		DayMonthInYear dayOfMonth = DayMonthInYear.valueOf("1/0");
	}

	@Test(expectedExceptions = InvalidDayOfMonthExpressionException.class)
	public void shouldThrowExceptionWhenMonthIsGreaterThan12() {
		@SuppressWarnings("unused")
		DayMonthInYear dayOfMonth = DayMonthInYear.valueOf("1/13");
	}

	@Test(expectedExceptions = InvalidDayOfMonthExpressionException.class)
	public void shouldThrowExceptionIfExpressionIsMalformed() {
		@SuppressWarnings("unused")
		DayMonthInYear dayOfMonth = DayMonthInYear.valueOf("12-b");
	}

	@Test(expectedExceptions = InvalidDayOfMonthExpressionException.class)
	public void shouldThrowExceptionIfMonthValueIsNotAnInteger() {
		@SuppressWarnings("unused")
		DayMonthInYear dayOfMonth = DayMonthInYear.valueOf("12/b");
	}

	@Test(expectedExceptions = InvalidDayOfMonthExpressionException.class)
	public void shouldThrowExceptionIfDayValueIsNotAnInteger() {
		@SuppressWarnings("unused")
		DayMonthInYear dayOfMonth = DayMonthInYear.valueOf("12/b");
	}

}
