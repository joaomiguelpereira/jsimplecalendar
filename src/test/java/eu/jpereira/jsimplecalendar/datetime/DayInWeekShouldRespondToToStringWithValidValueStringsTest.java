package eu.jpereira.jsimplecalendar.datetime;

import static org.junit.Assert.*;

import org.junit.Test;

public class DayInWeekShouldRespondToToStringWithValidValueStringsTest {

	@Test
	public void shouldRespondWithValidValueString() {
		for (DayInWeek dayInWeekUT : DayInWeek.allDaysInWeek()) {
			DayInWeek newValue = DayInWeek.valueOf(dayInWeekUT.toString());
			assertEquals(dayInWeekUT, newValue);
		}
	}

}
