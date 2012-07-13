package eu.jpereira.jsimplecalendar.datetime.containers;

import org.junit.Test;

import eu.jpereira.jsimplecalendar.datetime.DayInWeek;

import static org.junit.Assert.*;

//TODO: Pull up most of the tests in all containers to a Base test
//TODO: COmplete
public class DayInWeekContainerTest {

	static String dayNames[] = { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" };

	private DayInWeekContainer containerUT = new DayInWeekContainer();

	/** Creational behavior **/

	@Test
	public void canCreateFullContainer() {

		assertEquals(DayInWeek.allDaysInWeek().length, this.containerUT.getComponentCount());
		assertEquals(0, this.containerUT.getExclusions().size());
	}

	@Test
	public void everyDayInWeekIsIncludedInConstruction() {
		for (DayInWeek dayInWeek : DayInWeek.allDaysInWeek()) {
			assertTrue(this.containerUT.contains(dayInWeek));
		}
	}

}
