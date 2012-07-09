package eu.jpereira.appointments.model.calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import eu.jpereira.jsimplecalendar.datetime.DayInWeek;
import eu.jpereira.jsimplecalendar.datetime.containers.DayInWeekContainer;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.DayInWeekExclusion;

public class WorkingWeekDaysTest {

    private DayInWeekContainer testWorkignWeekDays;

    @Before
    public void setup() {

        List<DayInWeek> initialWorkingWeekDays = new ArrayList<DayInWeek>();
        //All business days are working days
        initialWorkingWeekDays.addAll(Arrays.asList(DayInWeek.allBusinessWeekDays()));
        Map<String, DayInWeekExclusion> initialWeekDayExceptions = new HashMap<String, DayInWeekExclusion>();
        //initialWeekDayExceptions.put("weeend", new WeekDayException("weekend", WeekDayPeriod.valueOf("SATURDAY"), WeekDayPeriod.valueOf("SUNDAY")));
        this.testWorkignWeekDays = new DayInWeekContainer(initialWorkingWeekDays, initialWeekDayExceptions);
    }

    @Test
    public void canAddWeekDayExceptions() {
    	
        this.testWorkignWeekDays.addException(new DayInWeekExclusion("DayOff", DayInWeek.valueOf("FRIDAY"), DayInWeek.valueOf("MONDAY")));

        assertFalse(this.testWorkignWeekDays.contains(DayInWeek.valueOf("MONDAY")));
        assertTrue(this.testWorkignWeekDays.contains(DayInWeek.valueOf("TUESDAY")));
        assertTrue(this.testWorkignWeekDays.contains(DayInWeek.valueOf("WEDNESDAY")));
        assertTrue(this.testWorkignWeekDays.contains(DayInWeek.valueOf("THURSDAY")));
        assertFalse(this.testWorkignWeekDays.contains(DayInWeek.valueOf("FRIDAY")));
        assertFalse(this.testWorkignWeekDays.contains(DayInWeek.valueOf("SATURDAY")));
        assertFalse(this.testWorkignWeekDays.contains(DayInWeek.valueOf("SUNDAY")));

    }
    
    //TODO: Mudar a hierarquia dos inSowling tome. Ir ao CalendarModel e ver todos os que modelam periodos no calendadr

    @Test
    public void canRemoveWeekDayException() {

        this.testWorkignWeekDays.addException(new DayInWeekExclusion("DayOff", DayInWeek.valueOf("FRIDAY"), DayInWeek.valueOf("MONDAY")));
        assertFalse(this.testWorkignWeekDays.contains(DayInWeek.valueOf("FRIDAY")));
        assertFalse(this.testWorkignWeekDays.contains(DayInWeek.valueOf("MONDAY")));
        this.testWorkignWeekDays.removeException("DayOff");
        assertTrue(this.testWorkignWeekDays.contains(DayInWeek.valueOf("FRIDAY")));
        assertTrue(this.testWorkignWeekDays.contains(DayInWeek.valueOf("MONDAY")));

    }

    @Test
    public void canListWeekDayExceptions() {

        // Default calendar is a every month, day from 9:00 to 18:00 with a
        // lunch exception from 12:00 to 13:00

        int initialExceptionsCount = this.testWorkignWeekDays.getExclusions().size();
        this.testWorkignWeekDays.addException(new DayInWeekExclusion("DayOff", DayInWeek.valueOf("FRIDAY"), DayInWeek.valueOf("MONDAY")));
        this.testWorkignWeekDays.addException(new DayInWeekExclusion("DayOff2", DayInWeek.valueOf("FRIDAY"), DayInWeek.valueOf("SATURDAY")));
        assertEquals(initialExceptionsCount + 2, this.testWorkignWeekDays.getExclusions().size());

    }

}
