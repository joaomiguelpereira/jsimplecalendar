package eu.jpereira.appointments.model.calendar.datetime;

import eu.jpereira.jsimplecalendar.datetime.DayInMonth;
import eu.jpereira.jsimplecalendar.datetime.TimeInDay;
import eu.jpereira.jsimplecalendar.datetime.containers.TimeInDayContainer;

public class WorkingPeriodFilter {

    private TimeInDay dayTime;
    private DayInMonth dayOfMonth;

    public WorkingPeriodFilter setDayTime(TimeInDay dayTimeToFilter) {
        this.dayTime = dayTimeToFilter;
        return this;
    }

    public boolean match(TimeInDayContainer workingDayTime) {
        return workingDayTime.contains(this.dayTime);
    }

    public WorkingPeriodFilter setDayOfMonth(DayInMonth dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
        return this;
    }

}
