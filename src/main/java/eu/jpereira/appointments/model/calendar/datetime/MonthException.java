package eu.jpereira.appointments.model.calendar.datetime;

import eu.jpereira.jsimplecalendar.datetime.MonthInYear;


public class MonthException {

    private String name;
    private MonthInYear[] months;

    public MonthException(String name, MonthInYear... months) {
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
