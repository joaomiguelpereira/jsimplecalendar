package eu.jpereira.appointments.model.calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import eu.jpereira.jsimplecalendar.datetime.DayInWeek;
import eu.jpereira.jsimplecalendar.datetime.containers.DayInWeekContainer;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.DayInWeekExclusion;

public class WorkingWeekDaysTest {

	private DayInWeekContainer testWorkignWeekDays;

	@Before
	public void setup() {

		this.testWorkignWeekDays = new DayInWeekContainer();
	}

	@Test
	public void canAddWeekDayExceptions() {

		this.testWorkignWeekDays.addExclusion(DayInWeekExclusion.valueOf("DayOff", "FRIDAY"));
		this.testWorkignWeekDays.addExclusion(DayInWeekExclusion.valueOf("DayOff2", "MONDAY"));

		this.testWorkignWeekDays.addExclusion(DayInWeekExclusion.valueOf("DayOff3", "SATURDAY"));
		this.testWorkignWeekDays.addExclusion(DayInWeekExclusion.valueOf("DayOff4", "SUNDAY"));

		assertFalse(this.testWorkignWeekDays.contains(DayInWeek.valueOf("MONDAY")));
		assertTrue(this.testWorkignWeekDays.contains(DayInWeek.valueOf("TUESDAY")));
		assertTrue(this.testWorkignWeekDays.contains(DayInWeek.valueOf("WEDNESDAY")));
		assertTrue(this.testWorkignWeekDays.contains(DayInWeek.valueOf("THURSDAY")));
		assertFalse(this.testWorkignWeekDays.contains(DayInWeek.valueOf("FRIDAY")));

		assertFalse(this.testWorkignWeekDays.contains(DayInWeek.valueOf("SATURDAY")));
		assertFalse(this.testWorkignWeekDays.contains(DayInWeek.valueOf("SUNDAY")));

	}

	// TODO: Mudar a hierarquia dos inSowling tome. Ir ao CalendarModel e ver
	// todos os que modelam periodos no calendadr

	@Test
	public void canRemoveWeekDayException() {

		this.testWorkignWeekDays.addExclusion(DayInWeekExclusion.valueOf("DayOff", "FRIDAY"));
		this.testWorkignWeekDays.addExclusion(DayInWeekExclusion.valueOf("DayOff2", "MONDAY"));

		assertFalse(this.testWorkignWeekDays.contains(DayInWeek.valueOf("FRIDAY")));

		assertFalse(this.testWorkignWeekDays.contains(DayInWeek.valueOf("MONDAY")));
		this.testWorkignWeekDays.removeExclusion("DayOff");
		this.testWorkignWeekDays.removeExclusion("DayOff2");
		assertTrue(this.testWorkignWeekDays.contains(DayInWeek.valueOf("FRIDAY")));
		assertTrue(this.testWorkignWeekDays.contains(DayInWeek.valueOf("MONDAY")));

	}

	@Test
	public void canListWeekDayExceptions() {

		// Default calendar is a every month, day from 9:00 to 18:00 with a
		// lunch exception from 12:00 to 13:00

		int initialExceptionsCount = this.testWorkignWeekDays.getExclusions().size();
		this.testWorkignWeekDays.addExclusion(DayInWeekExclusion.valueOf("DayOff", "FRIDAY"));
		this.testWorkignWeekDays.addExclusion(DayInWeekExclusion.valueOf("DayOff2", "MONDAY"));
		assertEquals(initialExceptionsCount + 2, this.testWorkignWeekDays.getExclusions().size());

	}

}
