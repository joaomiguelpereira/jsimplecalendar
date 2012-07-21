package eu.jpereira.jsimplecalendar.datetime;
 
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
public class DayInWeekShouldRespondToToStringWithValidValueStringsTest {

	@Test
	public void shouldRespondWithValidValueString() {
		for (DayInWeek dayInWeekUT : DayInWeek.allDaysInWeek()) {
			DayInWeek newValue = DayInWeek.valueOf(dayInWeekUT.toString());
			assertEquals(dayInWeekUT, newValue);
		}
	}

}
