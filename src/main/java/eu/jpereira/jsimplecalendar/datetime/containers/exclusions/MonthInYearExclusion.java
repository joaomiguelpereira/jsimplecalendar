package eu.jpereira.jsimplecalendar.datetime.containers.exclusions;

import eu.jpereira.jsimplecalendar.datetime.MonthInYear;


public class MonthInYearExclusion implements DateTimeComponentExclusion {

    private String name;
    private MonthInYear[] months;

    public MonthInYearExclusion(String name, MonthInYear... months) {
        this.name = name;
        this.months = months;
    }

    public String getName() {
        return name;
    }

    public MonthInYear[] getMonths() {
        return months;
    }

}
