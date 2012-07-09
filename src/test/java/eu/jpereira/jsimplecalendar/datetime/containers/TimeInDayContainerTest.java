package eu.jpereira.jsimplecalendar.datetime.containers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import eu.jpereira.jsimplecalendar.datetime.TimeInDay;
import eu.jpereira.jsimplecalendar.datetime.containers.TimeInDayContainer;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.TimeInDayExclusion;

public class TimeInDayContainerTest {

	private TimeInDayContainer timeInDayContainerUT;

	@Before
	public void setupTestWorkingTime() {
		timeInDayContainerUT = new TimeInDayContainer("09:00", "18:00", new HashMap<String, TimeInDayExclusion>());
	}

	@Test
	public void canCreateEmptyContainer() {
		timeInDayContainerUT = new TimeInDayContainer();
		assertEquals(0, timeInDayContainerUT.getComponentCount());

	}

	@Test
	public void emptyContainerContainsNoComponents() {
		timeInDayContainerUT = new TimeInDayContainer();
		assertFalse(timeInDayContainerUT.contains(TimeInDay.valueOf("0:00")));
		assertFalse(timeInDayContainerUT.contains(TimeInDay.valueOf("18:00")));
	}

	@Test
	public void emptyContainerContainsNoExclusiong() {
		timeInDayContainerUT = new TimeInDayContainer();
		assertEquals(0,timeInDayContainerUT.getExclusions().size());
	}

	@Test
	public void canAddWorkingTimeException() {

		TimeInDayExclusion exception = new TimeInDayExclusion("siesta", "14:30", "15:00");
		timeInDayContainerUT.addException(exception);

		assertTrue(timeInDayContainerUT.contains(TimeInDay.valueOf("14:29")));
		assertFalse(timeInDayContainerUT.contains(TimeInDay.valueOf("14:30")));
		assertFalse(timeInDayContainerUT.contains(TimeInDay.valueOf("14:31")));
		assertFalse(timeInDayContainerUT.contains(TimeInDay.valueOf("14:59")));
		assertTrue(timeInDayContainerUT.contains(TimeInDay.valueOf("15:00")));

	}

	@Test
	public void canRemoveWorkingTimeExceptions() {

		timeInDayContainerUT.addException(new TimeInDayExclusion("other", "3:00", "15:00"));
		assertEquals(1, timeInDayContainerUT.getExclusions().size());

		assertFalse(timeInDayContainerUT.contains(TimeInDay.valueOf("14:00")));

		timeInDayContainerUT.removeException("other");

		assertEquals(0, timeInDayContainerUT.getExclusions().size());
		assertTrue(timeInDayContainerUT.contains(TimeInDay.valueOf("14:00")));

	}

	@Test
	public void canListAllWorkingTimeExceptions() {

		timeInDayContainerUT.addException(new TimeInDayExclusion("other", "3:00", "15:00"));
		assertEquals(1, timeInDayContainerUT.getExclusions().size());

	}

}
