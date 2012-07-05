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

import eu.jpereira.appointments.model.calendar.datetime.WeekDayException;
import eu.jpereira.appointments.model.calendar.datetime.WeekDayPeriod;

public class WorkingWeekDaysTest {

    private WorkingWeekDays testWorkignWeekDays;

    @Before
    public void setup() {

        List<WeekDayPeriod> initialWorkingWeekDays = new ArrayList<WeekDayPeriod>();
        initialWorkingWeekDays.addAll(Arrays.asList(WeekDayPeriod.allBusinessWeekDays()));
        Map<String, WeekDayException> initialWeekDayExceptions = new HashMap<String, WeekDayException>();
        initialWeekDayExceptions.put("weeend", new WeekDayException("weekend", WeekDayPeriod.valueOf("SATURDAY"), WeekDayPeriod.valueOf("SUNDAY")));

        this.testWorkignWeekDays = new WorkingWeekDays(initialWorkingWeekDays, initialWeekDayExceptions);
    }

    @Test
    public void canAddWeekDayExceptions() {

        this.testWorkignWeekDays.addException(new WeekDayException("DayOff", WeekDayPeriod.valueOf("FRIDAY"), WeekDayPeriod.valueOf("MONDAY")));

        assertFalse(this.testWorkignWeekDays.contains(WeekDayPeriod.valueOf("MONDAY")));
        assertTrue(this.testWorkignWeekDays.contains(WeekDayPeriod.valueOf("TUESDAY")));
        assertTrue(this.testWorkignWeekDays.contains(WeekDayPeriod.valueOf("WEDNESDAY")));
        assertTrue(this.testWorkignWeekDays.contains(WeekDayPeriod.valueOf("THURSDAY")));
        assertFalse(this.testWorkignWeekDays.contains(WeekDayPeriod.valueOf("FRIDAY")));
        assertFalse(this.testWorkignWeekDays.contains(WeekDayPeriod.valueOf("SATURDAY")));
        assertFalse(this.testWorkignWeekDays.contains(WeekDayPeriod.valueOf("SUNDAY")));

    }
    
    //TODO: Mudar a hierarquia dos inSowling tome. Ir ao CalendarModel e ver todos os que modelam periodos no calendadr

    @Test
    public void canRemoveWeekDayException() {

        this.testWorkignWeekDays.addException(new WeekDayException("DayOff", WeekDayPeriod.valueOf(FRIDAY, WeekDayEnum.MONDAY));
        assertFalse(this.testWorkignWeekDays.isWorkingWeekDay(WeekDayEnum.FRIDAY));
        assertFalse(this.testWorkignWeekDays.isWorkingWeekDay(WeekDayEnum.MONDAY));
        this.testWorkignWeekDays.removeException("DayOff");
        assertTrue(this.testWorkignWeekDays.isWorkingWeekDay(WeekDayEnum.FRIDAY));
        assertTrue(this.testWorkignWeekDays.isWorkingWeekDay(WeekDayEnum.MONDAY));

    }

    @Test
    public void canListWeekDayExceptions() {

        // Default calendar is a every month, day from 9:00 to 18:00 with a
        // lunch exception from 12:00 to 13:00

        int initialExceptionsCount = this.testWorkignWeekDays.getExceptions().size();
        this.testWorkignWeekDays.addException(new WeekDayException("DayOff", WeekDayEnum.FRIDAY, WeekDayEnum.MONDAY));
        this.testWorkignWeekDays.addException(new WeekDayException("DayOff2", WeekDayEnum.FRIDAY, WeekDayEnum.SATURDAY));
        assertEquals(initialExceptionsCount + 2, this.testWorkignWeekDays.getExceptions().size());

    }

}
