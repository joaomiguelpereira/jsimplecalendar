package eu.jpereira.appointments.model.calendar.datetime;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


import eu.jpereira.appointments.model.calendar.WorkingDateTimePeriodExceptions;
import eu.jpereira.appointments.model.calendar.datetime.DateTimePeriodException;

public class WorkingDateTimePeriodTest {
   
    private WorkingDateTimePeriodExceptions testWorkingDateTimePeriod;
    
    
    @BeforeTest
    public void setup() {
        this.testWorkingDateTimePeriod = new WorkingDateTimePeriodExceptions();
    }
    @Test
    public void canAddNonWorkingDateTimePeriod() {
        
        assertTrue(testWorkingDateTimePeriod.isWorkingDateTimePeriod("12/12/2008 09:00","14/12/2008 09:00"));
        DateTimePeriodException exception = new DateTimePeriodException("dummy", "12/12/2008 09:00","14/12/2008 09:00");
        testWorkingDateTimePeriod.addException(exception);
        assertFalse(testWorkingDateTimePeriod.isWorkingDateTimePeriod("12/12/2008 09:00","14/12/2008 09:00"));
        assertEquals(1, testWorkingDateTimePeriod.getExceptions().size());
    }
    
    @Test
    public void canRemoveDateTimePeriodExceptio() {
        assertTrue(testWorkingDateTimePeriod.isWorkingDateTimePeriod("12/12/2008 09:00","14/12/2008 09:00"));
        DateTimePeriodException exception = new DateTimePeriodException("dummy", "12/12/2008 09:00","14/12/2008 09:00");
        assertEquals(0, testWorkingDateTimePeriod.getExceptions().size());
        testWorkingDateTimePeriod.addException(exception);
        assertEquals(1, testWorkingDateTimePeriod.getExceptions().size());
        testWorkingDateTimePeriod.removeException("dummy");
        assertEquals(0, testWorkingDateTimePeriod.getExceptions().size());
        
        
    }

}
