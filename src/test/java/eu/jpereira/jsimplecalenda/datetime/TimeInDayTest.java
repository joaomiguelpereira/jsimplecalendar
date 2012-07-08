package eu.jpereira.jsimplecalenda.datetime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eu.jpereira.appointments.model.calendar.exceptions.InvalidDayTimeExpressionException;
import eu.jpereira.jsimplecalendar.datetime.TimeInDay;

public class TimeInDayTest {

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
        TimeInDay.valueOf("1:");
    }

    @Test(expected=InvalidDayTimeExpressionException.class)
    public void cantConstructIncompleteDayTimeNoHour() {
        TimeInDay.valueOf(":30");
    }


    @Test(expected=InvalidDayTimeExpressionException.class)
    public void cantConstructInvalidDayTimeUpperBoundary() {
        TimeInDay.valueOf("24:00");
        
    }
    @Test(expected=InvalidDayTimeExpressionException.class)
    public void cantConstructInvalidDayTimeLowerBoundary() {
        TimeInDay.valueOf("-1:00");
        
    }
    
    @Test
    public void testEquals() {
        TimeInDay d1 = TimeInDay.valueOf("9:00");
        TimeInDay d2 = TimeInDay.valueOf("09:00");
        assertTrue(d1.equals(d2));
        assertTrue(d2.equals(d1));
        
        assertFalse(d2.equals(TimeInDay.valueOf("09:01")));
        assertFalse(d2.equals(null));
        
    }
    
    @Test
    public void testGreater() {
        TimeInDay d1 = TimeInDay.valueOf("9:00");
        TimeInDay d2 = TimeInDay.valueOf("9:01");
        
        assertTrue(d1.compareTo(d2) < 0);
        assertTrue(d2.compareTo(d1) > 0);
        
        assertEquals(d1.compareTo(d2), d2.compareTo(d1)*-1);
        
        assertTrue(d1.compareTo(TimeInDay.valueOf("09:00"))==0);
        
    }

    
    
    private void testAllDayHoursWithPrefixes() {
        int hours = 24;
        int minutes = 60;

        for (int h = 0; h < hours; h++) {
            for (int m = 0; m < minutes; m++) {
                String testHour = prefixZero(h);
                String testMinute = prefixZero(m);

                String testData = testHour + ":" + testMinute;
                TimeInDay dayTime = TimeInDay.valueOf(testData);
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
                TimeInDay dayTime = TimeInDay.valueOf(testData);
                assertEquals(h, dayTime.getHour());
                assertEquals(m, dayTime.getMinute());
            }
        }
    }


}
