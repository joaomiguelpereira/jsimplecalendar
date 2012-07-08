package eu.jpereira.appointments.model.calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import eu.jpereira.appointments.model.calendar.datetime.WorkingTimeException;
import eu.jpereira.jsimplecalendar.datetime.TimeInDay;

public class WorkingDayTimeTest {

    private WorkingDayTime testWorkingTime;

    @Before
    public void setupTestWorkingTime() {
        testWorkingTime = new WorkingDayTime("09:00", "18:00", new HashMap<String, WorkingTimeException>());
    }

    @Test
    public void canAddWorkingTimeException() {

        WorkingTimeException exception = new WorkingTimeException("siesta", "14:30", "15:00");
        testWorkingTime.addException(exception);

        assertTrue(testWorkingTime.contains(TimeInDay.valueOf("14:29")));
        assertFalse(testWorkingTime.contains(TimeInDay.valueOf("14:30")));
        assertFalse(testWorkingTime.contains(TimeInDay.valueOf("14:31")));
        assertFalse(testWorkingTime.contains(TimeInDay.valueOf("14:59")));
        assertTrue(testWorkingTime.contains(TimeInDay.valueOf("15:00")));

    }

    @Test
    public void canRemoveWorkingTimeExceptions() {

        testWorkingTime.addException(new WorkingTimeException("other", "3:00", "15:00"));
        assertEquals(1, testWorkingTime.getExceptions().size());

        assertFalse(testWorkingTime.contains(TimeInDay.valueOf("14:00")));

        testWorkingTime.removeException("other");

        assertEquals(0, testWorkingTime.getExceptions().size());
        assertTrue(testWorkingTime.contains(TimeInDay.valueOf("14:00")));

    }

    @Test
    public void canListAllWorkingTimeExceptions() {

        testWorkingTime.addException(new WorkingTimeException("other", "3:00", "15:00"));
        assertEquals(1, testWorkingTime.getExceptions().size());

       
    }

}
