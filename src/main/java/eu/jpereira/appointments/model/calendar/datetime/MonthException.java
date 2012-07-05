package eu.jpereira.appointments.model.calendar.datetime;


public class MonthException {

    private String name;
    private MonthPeriod[] months;

    public MonthException(String name, MonthPeriod... months) {
        this.name = name;
        this.months = months;
    }

    public String getName() {
        return name;
    }

    public MonthPeriod[] getMonths() {
        return months;
    }

}
