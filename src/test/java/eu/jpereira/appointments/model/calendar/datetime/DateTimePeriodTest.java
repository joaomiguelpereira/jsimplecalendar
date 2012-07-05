package eu.jpereira.appointments.model.calendar.datetime;

import static org.junit.Assert.*;

import org.junit.Test;

import eu.jpereira.appointments.model.calendar.datetime.DateTimePeriod;
import eu.jpereira.appointments.model.calendar.datetime.SimpleDateTime;

public class DateTimePeriodTest {

    @Test
    public void testContainsEqualPeriod() {
        DateTimePeriod dateTimeSource = new DateTimePeriod("12/12/2001 9:00", "12/12/2002 9:00");
        DateTimePeriod dateTimeTarget = new DateTimePeriod("12/12/2001 9:00", "12/12/2002 9:00");

        assertTrue(dateTimeSource.contains(SimpleDateTime.valueOf("12/12/2001 9:00"),
                SimpleDateTime.valueOf("12/12/2002 9:00")));
        assertTrue(dateTimeSource.contains(dateTimeTarget));

    }

    @Test
    public void testContainsSmallerPeriodUpperBoundary() {
        DateTimePeriod dateTimeSource = new DateTimePeriod("1/1/2001 9:00", "12/12/2001 9:00");
        DateTimePeriod dateTimeTarget = new DateTimePeriod("2/1/2001 9:00", "12/12/2001 9:00");

        
        assertTrue(dateTimeSource.contains(dateTimeTarget));

    }
    
    @Test
    public void testContainsSmallerPeriodLowerBoundary() {
        DateTimePeriod dateTimeSource = new DateTimePeriod("1/1/2001 9:00", "12/12/2001 9:00");
        DateTimePeriod dateTimeTarget = new DateTimePeriod("1/1/2001 9:00", "11/12/2001 9:00");
        assertTrue(dateTimeSource.contains(dateTimeTarget));

    }

    @Test
    public void testContainsSmallerPeriod() {
        DateTimePeriod dateTimeSource = new DateTimePeriod("1/1/2001 9:00", "12/12/2001 9:00");
        DateTimePeriod dateTimeTarget = new DateTimePeriod("1/1/2001 9:00", "2/11/2001 9:30");
        assertTrue(dateTimeSource.contains(dateTimeTarget));
       
    }

    @Test
    public void testNotContainsLowerBoundaryIn() {
        DateTimePeriod dateTimeSource = new DateTimePeriod("1/1/2001 9:00", "12/12/2001 9:00");
        DateTimePeriod dateTimeTarget = new DateTimePeriod("1/1/2001 9:00", "13/13/2001 9:30");
        assertFalse(dateTimeSource.contains(dateTimeTarget));
       
    }
    @Test
    public void testNotContainsUpperBoundarin() {
        DateTimePeriod dateTimeSource = new DateTimePeriod("1/1/2001 9:00", "12/12/2001 9:00");
        DateTimePeriod dateTimeTarget = new DateTimePeriod("11/12/2001 9:00", "13/12/2001 9:30");
        assertFalse(dateTimeSource.contains(dateTimeTarget));
       
    }
    @Test
    public void testNotContainsUpperBoundaryOutOneMinute() {
        DateTimePeriod dateTimeSource = new DateTimePeriod("1/1/2001 9:00", "12/12/2001 9:00");
        DateTimePeriod dateTimeTarget = new DateTimePeriod("1/12/2001 9:00", "12/12/2001 9:01");
        assertFalse(dateTimeSource.contains(dateTimeTarget));
       
    }

    @Test
    public void testDontContainsDifferentPeriod() {
        DateTimePeriod dateTimeSource = new DateTimePeriod("12/12/2001 9:00", "12/12/2002 9:00");
        DateTimePeriod dateTimeTarget = new DateTimePeriod("12/12/2003 9:00", "12/12/2004 9:00");
        assertFalse(dateTimeSource.contains(dateTimeTarget));

    }

}
