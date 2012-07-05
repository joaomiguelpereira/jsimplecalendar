package eu.jpereira.appointments.model.calendar.datetime;

import java.util.Arrays;

public class WeekDayException {
    private String name;
    private WeekDayPeriod[] weekDays;

    public WeekDayException(String name, WeekDayPeriod... weekDays) {
        this.name = name;
        this.weekDays = weekDays;
    }

    public String getName() {
        return name;
    }

    public WeekDayPeriod[] getWeekDays() {
        return Arrays.copyOf(weekDays, weekDays.length);

    }
}
