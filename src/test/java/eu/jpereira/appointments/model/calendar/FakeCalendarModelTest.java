package eu.jpereira.appointments.model.calendar;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import eu.jpereira.appointments.model.calendar.datetime.DateTimePeriodException;
import eu.jpereira.appointments.model.calendar.datetime.DayOfMonthException;
import eu.jpereira.appointments.model.calendar.datetime.WorkingPeriodFilter;
import eu.jpereira.jsimplecalendar.datetime.DayInMonth;
import eu.jpereira.jsimplecalendar.datetime.TimeInDay;

import static org.junit.Assert.*;

@Ignore
public class FakeCalendarModelTest {

    private CalendarModel testCalendarModel;

    @Before
    public void setup() {
        // The fake calendar model models all business days as working days
        // (MONDAY, TUESDAY, WEDNESDAY, THURSDAY and FRIDAY)
        // The fake calendar model models the period of 9:00 to 18:00 as working
        // day time
        // The fake calendar model models a exception to the working day time
        // for lunch, from 12:00 to 13:30
        // the fake calendar model models the christmas day as non working day
        // the fake calendar models a non working period from 1 August 2012 to
        // 21 August 2012
        this.testCalendarModel = new FakeCalendarModel();
        DayOfMonthException christmas = new DayOfMonthException("Christmas", "25/12");
        DateTimePeriodException holidays = new DateTimePeriodException("Holidays", "1/08/2012 0:9", "21/08/2012 18:00");
        this.testCalendarModel.addDayOfMonthException(christmas);
        this.testCalendarModel.addDateTimePeriodException(holidays);

    }

    @Test
    public void testFilterForDayTime() {
        WorkingPeriodFilter workingPeriodFilter = new WorkingPeriodFilter().setDayTime(TimeInDay.valueOf("9:00"));
        assertTrue(testCalendarModel.isWorkingPeriod(workingPeriodFilter));
    }

    @Test
    public void testFilterForDayOfMonth() {
        WorkingPeriodFilter workingPeriodFilter = new WorkingPeriodFilter().setDayOfMonth(DayInMonth.valueOf("25/12"));
        assertTrue(testCalendarModel.isWorkingPeriod(workingPeriodFilter));
    }


}
