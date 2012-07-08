package eu.jpereira.jsimplecalenda.datetime;

import org.junit.Test;

import eu.jpereira.jsimplecalendar.datetime.DayInWeek;

public class DayInWeekTest {

	private static final String[] allowedValues = { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" };

	@Test
	public void testValueOf() {

		for ( String allowedValue : allowedValues ) {
			DayInWeek.valueOf(allowedValue);
		}
	}
}
