package eu.jpereira.appointments.model.calendar;

import org.junit.Before;
import org.junit.Test;

import eu.jpereira.appointments.model.calendar.datetime.DayOfMonthException;

import static org.junit.Assert.*;

public class WorkingDayOfMonthExceptionsTest {

    private WorkingDayOfMonthExceptions dayOfMonthExceptions;

    @Before
    public void setup() {
        this.dayOfMonthExceptions = new WorkingDayOfMonthExceptions();
    }

    @Test
    public void noExceptionsOnCreation() {

        assertTrue(dayOfMonthExceptions.isWorkingDayOfMonth("25/12"));

    }

    @Test
    public void canAddExceptions() {
        DayOfMonthException exception = new DayOfMonthException("christmas", "25/12");
        DayOfMonthException exceptionlaborsDay = new DayOfMonthException("Labors day", "1/5");
        assertTrue(dayOfMonthExceptions.isWorkingDayOfMonth("25/12"));
        assertTrue(dayOfMonthExceptions.isWorkingDayOfMonth("1/5"));
        dayOfMonthExceptions.addException(exception);
        dayOfMonthExceptions.addException(exceptionlaborsDay);
        assertFalse(dayOfMonthExceptions.isWorkingDayOfMonth("25/12"));
        assertFalse(dayOfMonthExceptions.isWorkingDayOfMonth("1/5"));

    }
    
    @Test
    public void canRemoveExceptions() {
        DayOfMonthException exception = new DayOfMonthException("christmas", "25/12");
        DayOfMonthException exceptionlaborsDay = new DayOfMonthException("Labors day", "1/5");
        dayOfMonthExceptions.addException(exception);
        dayOfMonthExceptions.addException(exceptionlaborsDay);
        
        assertFalse(dayOfMonthExceptions.isWorkingDayOfMonth("25/12"));
        assertFalse(dayOfMonthExceptions.isWorkingDayOfMonth("1/5"));

        dayOfMonthExceptions.removeException("christmas");
        dayOfMonthExceptions.removeException("Labors day");
        
        assertTrue(dayOfMonthExceptions.isWorkingDayOfMonth("25/12"));
        assertTrue(dayOfMonthExceptions.isWorkingDayOfMonth("1/5"));

    }

    @Test
    public void canListExceptions() {
        DayOfMonthException exception = new DayOfMonthException("christmas", "25/12");
        DayOfMonthException exceptionlaborsDay = new DayOfMonthException("Labors day", "1/5");
        dayOfMonthExceptions.addException(exception);
        dayOfMonthExceptions.addException(exceptionlaborsDay);
        assertEquals(2, dayOfMonthExceptions.getExceptions().size());
    }


}
