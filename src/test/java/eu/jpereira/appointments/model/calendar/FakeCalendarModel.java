package eu.jpereira.appointments.model.calendar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.jpereira.appointments.model.calendar.datetime.WeekDayException;
import eu.jpereira.jsimplecalendar.datetime.DayInWeek;
import eu.jpereira.jsimplecalendar.datetime.MonthInYear;
import eu.jpereira.jsimplecalendar.datetime.containers.MonthsInYearContainer;
import eu.jpereira.jsimplecalendar.datetime.containers.TimeInDayContainer;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.MonthInYearExclusion;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.TimeInDayExclusion;

public class FakeCalendarModel extends CalendarModel {

    private static final String LUNCH_EXCEPTION_NAME = "lunch";
    private static final String END_LUNCH_TIME = "13:30";
    private static final String START_LUNCH_TIME = "12:00";
    private static final String DEFAULT_START_DAYTIME = "9:00";
    private static final String DEFAULT_END_DAYTIME = "18:00";

    public FakeCalendarModel() {
        super(getTestingtWorkingMonths(), getTestingWorkingWeekDays(), getTestingWorkingDayTime(), getTestingWorkingDateTimePeriod(),
                getWorkingDayOfMonthExceptions());

    }

    private static WorkingDayOfMonthExceptions getWorkingDayOfMonthExceptions() {

        return new WorkingDayOfMonthExceptions();
    }

    private static WorkingDateTimePeriodExceptions getTestingWorkingDateTimePeriod() {
        WorkingDateTimePeriodExceptions initialWorkingDayTimePeriod = new WorkingDateTimePeriodExceptions();
        return initialWorkingDayTimePeriod;
    }

    /**
     * Working from MONDAY to FRIDAY
     * 
     * @return
     */
    protected static WorkingWeekDays getTestingWorkingWeekDays() {
        List<DayInWeek> initialWorkingWeekDays = new ArrayList<DayInWeek>();
        initialWorkingWeekDays.addAll(Arrays.asList(DayInWeek.allBusinessWeekDays()));
        Map<String, WeekDayException> initialWeekDayExceptions = new HashMap<String, WeekDayException>();

        return new WorkingWeekDays(initialWorkingWeekDays, initialWeekDayExceptions);
    }

    protected static MonthsInYearContainer getTestingtWorkingMonths() {
        List<MonthInYear> initialWorkingMonths = new ArrayList<MonthInYear>(12);
        initialWorkingMonths.addAll(Arrays.asList(MonthInYear.allMonths()));
        Map<String, MonthInYearExclusion> initialExceptionWorkingMonths = new HashMap<String, MonthInYearExclusion>();
        return new MonthsInYearContainer(initialWorkingMonths, initialExceptionWorkingMonths);
    }

    /**
     * Working from 9:00 to 18:00 with exception for lunch from 12:00 to 13:30
     * 
     * @return
     */
    protected static TimeInDayContainer getTestingWorkingDayTime() {

        Map<String, TimeInDayExclusion> initialWorkingTimeExceptions = new HashMap<String, TimeInDayExclusion>();
        initialWorkingTimeExceptions.put(LUNCH_EXCEPTION_NAME, new TimeInDayExclusion(LUNCH_EXCEPTION_NAME, START_LUNCH_TIME, END_LUNCH_TIME));

        return new TimeInDayContainer(DEFAULT_START_DAYTIME, DEFAULT_END_DAYTIME, initialWorkingTimeExceptions);
    }

}
