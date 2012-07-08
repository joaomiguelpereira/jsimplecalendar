package eu.jpereira.appointments.model.calendar.datetime;

import java.util.Arrays;

import eu.jpereira.jsimplecalendar.datetime.DayInWeek;

public class WeekDayException {
    private String name;
    private DayInWeek[] weekDays;

    public WeekDayException(String name, DayInWeek... weekDays) {
        this.name = name;
        this.weekDays = weekDays;
    }

    public String getName() {
        return name;
    }

    public DayInWeek[] getWeekDays() {
        return Arrays.copyOf(weekDays, weekDays.length);

    }
}
