package eu.jpereira.appointments.model.calendar.datetime;

public class DateTimePeriodException extends DateTimePeriod {

    private String name;

    public DateTimePeriodException(String name, String startDateTimeExpression, String endDateTimeException) {
        super(startDateTimeExpression, endDateTimeException);
        this.name = name;

    }

    public String getName() {

        return this.name;
    }

}
