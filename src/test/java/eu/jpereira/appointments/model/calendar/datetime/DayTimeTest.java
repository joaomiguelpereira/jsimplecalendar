package eu.jpereira.appointments.model.calendar.datetime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eu.jpereira.appointments.model.calendar.datetime.DayTimePeriod;
import eu.jpereira.appointments.model.calendar.exceptions.InvalidDayTimeExpressionException;

public class DayTimeTest {

    @Test
    public void canConstructDayTimeWithoutPrefixes() {
        testAllDayHoursWithoutPrefixes();
    }

    @Test
    public void canConstructDayTimeWithPrefixes() {
        testAllDayHoursWithPrefixes();
    }

    @Test(expected=InvalidDayTimeExpressionException.class)
    public void cantConstructIncompleteDayTimeNoMinutes() {
        DayTimePeriod.valueOf("1:");
    }

    @Test(expected=InvalidDayTimeExpressionException.class)
    public void cantConstructIncompleteDayTimeNoHour() {
        DayTimePeriod.valueOf(":30");
    }


    @Test(expected=InvalidDayTimeExpressionException.class)
    public void cantConstructInvalidDayTimeUpperBoundary() {
        DayTimePeriod.valueOf("24:00");
        
    }
    @Test(expected=InvalidDayTimeExpressionException.class)
    public void cantConstructInvalidDayTimeLowerBoundary() {
        DayTimePeriod.valueOf("-1:00");
        
    }
    
    @Test
    public void testEquals() {
        DayTimePeriod d1 = DayTimePeriod.valueOf("9:00");
        DayTimePeriod d2 = DayTimePeriod.valueOf("09:00");
        assertTrue(d1.equals(d2));
        assertTrue(d2.equals(d1));
        
        assertFalse(d2.equals(DayTimePeriod.valueOf("09:01")));
        assertFalse(d2.equals(null));
        
    }
    
    @Test
    public void testGreater() {
        DayTimePeriod d1 = DayTimePeriod.valueOf("9:00");
        DayTimePeriod d2 = DayTimePeriod.valueOf("9:01");
        
        assertTrue(d1.compareTo(d2) < 0);
        assertTrue(d2.compareTo(d1) > 0);
        
        assertEquals(d1.compareTo(d2), d2.compareTo(d1)*-1);
        
        assertTrue(d1.compareTo(DayTimePeriod.valueOf("09:00"))==0);
        
    }

    
    
    private void testAllDayHoursWithPrefixes() {
        int hours = 24;
        int minutes = 60;

        for (int h = 0; h < hours; h++) {
            for (int m = 0; m < minutes; m++) {
                String testHour = prefixZero(h);
                String testMinute = prefixZero(m);

                String testData = testHour + ":" + testMinute;
                DayTimePeriod dayTime = DayTimePeriod.valueOf(testData);
                assertEquals(h, dayTime.getHour());
                assertEquals(m, dayTime.getMinute());
            }
        }
    }

    private String prefixZero(int h) {
        return (h < 10) ? ("0" + h) : "" + h;

    }

    private void testAllDayHoursWithoutPrefixes() {
        int hours = 24;
        int minutes = 60;

        for (int h = 0; h < hours; h++) {
            for (int m = 0; m < minutes; m++) {
                String testData = h + ":" + m;
                DayTimePeriod dayTime = DayTimePeriod.valueOf(testData);
                assertEquals(h, dayTime.getHour());
                assertEquals(m, dayTime.getMinute());
            }
        }
    }


}
