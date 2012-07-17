package eu.jpereira.jsimplecalendar.datetime;

import org.junit.Test;

import eu.jpereira.jsimplecalendar.datetime.exceptions.IllegalDateTimeComponentValueException;

public class DayInWeekShouldBeCreatedWithStringConstantsTest {

	private static final String[] allValidValues = { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" };

	@Test
	public void shouldCreateNewDayInWeekForAllValidValues() {

		for (String allowedValue : allValidValues) {
			DayInWeek.valueOf(allowedValue);
		}
	}
	@Test(expected=IllegalDateTimeComponentValueException.class)
	public void shouldThrowExceptionWithProvidedInvalidExpression() throws Throwable {
		DayInWeek.valueOf("Invalid");
	}

}
