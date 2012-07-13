package eu.jpereira.appointments.model.calendar.datetime;

import eu.jpereira.jsimplecalendar.datetime.DayMonthInYear;
import eu.jpereira.jsimplecalendar.datetime.HourMinuteInDay;
import eu.jpereira.jsimplecalendar.datetime.containers.HourMinuteInDayContainer;

public class WorkingPeriodFilter {

    private HourMinuteInDay dayTime;
    private DayMonthInYear dayOfMonth;

    public WorkingPeriodFilter setDayTime(HourMinuteInDay dayTimeToFilter) {
        this.dayTime = dayTimeToFilter;
        return this;
    }

    public boolean match(HourMinuteInDayContainer workingDayTime) {
        return workingDayTime.contains(this.dayTime);
    }

    public WorkingPeriodFilter setDayOfMonth(DayMonthInYear dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
        return this;
    }

}
