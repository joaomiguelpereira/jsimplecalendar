package eu.jpereira.appointments.model.calendar.datetime;

import eu.jpereira.appointments.model.calendar.WorkingDayTime;

public class WorkingPeriodFilter {

    private DayTimePeriod dayTime;
    private DayOfMonth dayOfMonth;

    public WorkingPeriodFilter setDayTime(DayTimePeriod dayTimeToFilter) {
        this.dayTime = dayTimeToFilter;
        return this;
    }

    public boolean match(WorkingDayTime workingDayTime) {
        return workingDayTime.contains(this.dayTime);
    }

    public WorkingPeriodFilter setDayOfMonth(DayOfMonth dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
        return this;
    }

}
