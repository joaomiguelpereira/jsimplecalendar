package eu.jpereira.jsimplecalendar.datetime.containers.exclusions;

import java.util.Arrays;

import eu.jpereira.jsimplecalendar.datetime.DayInWeek;

public class DayInWeekExclusion  implements DateTimeComponentExclusion{
    private String name;
    private DayInWeek[] weekDays;

    public DayInWeekExclusion(String name, DayInWeek... weekDays) {
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
