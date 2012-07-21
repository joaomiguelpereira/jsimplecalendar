package eu.jpereira.jsimplecalendar.datetime.containers;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import eu.jpereira.jsimplecalendar.datetime.HourMinuteInDay;
import eu.jpereira.jsimplecalendar.datetime.HourMinuteInDayRange;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.HourMinuteInDayExclusion;
import static org.testng.Assert.*;

public class HourMinuteInDayContainerTest {

	private HourMinuteInDayContainer timeInDayContainerUT;

	@BeforeTest
	public void setupTestWorkingTime() {
		timeInDayContainerUT = HourMinuteInDayContainer.newEmptyContainer();

	}

	@Test
	public void containsOnePeriod() {
		timeInDayContainerUT = HourMinuteInDayContainer.newEmptyContainer();
		assertEquals(0, timeInDayContainerUT.getComponentCount());

	}

	@Test
	public void emptyContainerContainsNoComponents() {
		timeInDayContainerUT = HourMinuteInDayContainer.newEmptyContainer();
		assertFalse(timeInDayContainerUT.contains(HourMinuteInDay.valueOf("0:00")));
		assertFalse(timeInDayContainerUT.contains(HourMinuteInDay.valueOf("18:00")));
	}

	@Test
	public void emptyContainerContainsNoExclusiong() {
		timeInDayContainerUT = HourMinuteInDayContainer.newEmptyContainer();
		assertEquals(0, timeInDayContainerUT.getExclusions().size());
	}

	@Test
	public void canAddWorkingTimeException() {
		timeInDayContainerUT = HourMinuteInDayContainer.newContainerWithComponents(HourMinuteInDayRange.valueOf("8:0",
		        "17:0"));

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

		timeInDayContainerUT = HourMinuteInDayContainer.newContainerWithComponents(HourMinuteInDayRange.valueOf("8:0",
		        "17:0"));
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
