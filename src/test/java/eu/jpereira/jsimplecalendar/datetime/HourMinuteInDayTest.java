package eu.jpereira.jsimplecalendar.datetime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eu.jpereira.jsimplecalendar.datetime.exceptions.IllegalDateTimeComponentValueException;

public class HourMinuteInDayTest {

    @Test
    public void canConstructDayTimeWithoutPrefixes() {
        testAllDayHoursWithoutPrefixes();
    }

    @Test
    public void canConstructDayTimeWithPrefixes() {
        testAllDayHoursWithPrefixes();
    }

    @Test(expected=IllegalDateTimeComponentValueException.class)
    public void cantConstructIncompleteDayTimeNoMinutes() {
        HourMinuteInDay.valueOf("1:");
    }

    @Test(expected=IllegalDateTimeComponentValueException.class)
    public void cantConstructIncompleteDayTimeNoHour() {
        HourMinuteInDay.valueOf(":30");
    }


    @Test(expected=IllegalDateTimeComponentValueException.class)
    public void cantConstructInvalidDayTimeUpperBoundary() {
        HourMinuteInDay.valueOf("24:00");
        
    }
    @Test(expected=IllegalDateTimeComponentValueException.class)
    public void cantConstructInvalidDayTimeLowerBoundary() {
        HourMinuteInDay.valueOf("-1:00");
        
    }
    
    @Test
    public void testEquals() {
        HourMinuteInDay d1 = HourMinuteInDay.valueOf("9:00");
        HourMinuteInDay d2 = HourMinuteInDay.valueOf("09:00");
        assertTrue(d1.equals(d2));
        assertTrue(d2.equals(d1));
        
        assertFalse(d2.equals(HourMinuteInDay.valueOf("09:01")));
        assertFalse(d2.equals(null));
        
    }
    
    @Test
    public void testGreater() {
        HourMinuteInDay d1 = HourMinuteInDay.valueOf("9:00");
        HourMinuteInDay d2 = HourMinuteInDay.valueOf("9:01");
        
        assertTrue(d1.compareTo(d2) < 0);
        assertTrue(d2.compareTo(d1) > 0);
        
        assertEquals(d1.compareTo(d2), d2.compareTo(d1)*-1);
        
        assertTrue(d1.compareTo(HourMinuteInDay.valueOf("09:00"))==0);
        
    }

    
    
    private void testAllDayHoursWithPrefixes() {
        int hours = 24;
        int minutes = 60;

        for (int h = 0; h < hours; h++) {
            for (int m = 0; m < minutes; m++) {
                String testHour = prefixZero(h);
                String testMinute = prefixZero(m);

                String testData = testHour + ":" + testMinute;
                HourMinuteInDay dayTime = HourMinuteInDay.valueOf(testData);
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
                HourMinuteInDay dayTime = HourMinuteInDay.valueOf(testData);
                assertEquals(h, dayTime.getHour());
                assertEquals(m, dayTime.getMinute());
            }
        }
    }


}
