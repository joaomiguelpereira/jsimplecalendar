package eu.jpereira.appointments.model.calendar.datetime;

import java.util.Arrays;

import eu.jpereira.jsimplecalendar.datetime.DayInWeek;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.DateTimeComponentExclusion;

public class WeekDayException  implements DateTimeComponentExclusion{
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
