package eu.jpereira.jsimplecalendar.datetime.containers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import eu.jpereira.jsimplecalendar.datetime.HourMinuteInDayRange;
import eu.jpereira.jsimplecalendar.datetime.HourMinuteInDay;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.HourMinuteInDayExclusion;

public class HourMinuteInDayContainerTest {

	private HourMinuteInDayContainer timeInDayContainerUT;

	@Before
	public void setupTestWorkingTime() {
		timeInDayContainerUT = new HourMinuteInDayContainer();
		
	}

	@Test
	public void containsOnePeriod() {
		timeInDayContainerUT = new HourMinuteInDayContainer();
		assertEquals(0, timeInDayContainerUT.getComponentCount());

	}

	@Test
	public void emptyContainerContainsNoComponents() {
		timeInDayContainerUT = new HourMinuteInDayContainer();
		assertFalse(timeInDayContainerUT.contains(HourMinuteInDay.valueOf("0:00")));
		assertFalse(timeInDayContainerUT.contains(HourMinuteInDay.valueOf("18:00")));
	}

	@Test
	public void emptyContainerContainsNoExclusiong() {
		timeInDayContainerUT = new HourMinuteInDayContainer();
		assertEquals(0,timeInDayContainerUT.getExclusions().size());
	}

	@Test
	public void canAddWorkingTimeException() {

		timeInDayContainerUT.addDateTimeComponent(new HourMinuteInDayRange("8:0", "17:0"));
		
		HourMinuteInDayExclusion exception = new HourMinuteInDayExclusion("siesta", "14:30", "15:00");
		timeInDayContainerUT.addExclusion(exception);

		assertTrue(timeInDayContainerUT.contains(HourMinuteInDay.valueOf("14:29")));
		assertFalse(timeInDayContainerUT.contains(HourMinuteInDay.valueOf("14:30")));
		assertFalse(timeInDayContainerUT.contains(HourMinuteInDay.valueOf("14:31")));
		assertFalse(timeInDayContainerUT.contains(HourMinuteInDay.valueOf("14:59")));
		assertTrue(timeInDayContainerUT.contains(HourMinuteInDay.valueOf("15:00")));

	}

	@Test
	public void canRemoveWorkingTimeExceptions() {

		timeInDayContainerUT.addDateTimeComponent(new HourMinuteInDayRange("8:0", "17:0"));
		timeInDayContainerUT.addExclusion(new HourMinuteInDayExclusion("other", "3:00", "15:00"));
		assertEquals(1, timeInDayContainerUT.getExclusions().size());

		assertFalse(timeInDayContainerUT.contains(HourMinuteInDay.valueOf("14:00")));

		timeInDayContainerUT.removeExclusion("other");

		assertEquals(0, timeInDayContainerUT.getExclusions().size());
		assertTrue(timeInDayContainerUT.contains(HourMinuteInDay.valueOf("14:00")));

	}

	@Test
	public void canListAllWorkingTimeExceptions() {

		timeInDayContainerUT.addExclusion(new HourMinuteInDayExclusion("other", "3:00", "15:00"));
		assertEquals(1, timeInDayContainerUT.getExclusions().size());

	}

}
