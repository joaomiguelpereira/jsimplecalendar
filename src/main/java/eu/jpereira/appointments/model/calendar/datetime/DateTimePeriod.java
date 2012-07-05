package eu.jpereira.appointments.model.calendar.datetime;

public class DateTimePeriod {

    private SimpleDateTime startDateTime;
    private SimpleDateTime endDateTime;

    public DateTimePeriod(String startDateTimeExpression, String endDateTimeException) {
        this.startDateTime = SimpleDateTime.valueOf(startDateTimeExpression);
        this.endDateTime = SimpleDateTime.valueOf(endDateTimeException);
    }

    public boolean contains(SimpleDateTime targetStartDateTime, SimpleDateTime targetEndDateTime) {
        return (targetStartDateTime.compareTo(this.startDateTime) >= 0) && (targetEndDateTime.compareTo(this.endDateTime) <= 0);

    }

    public boolean contains(DateTimePeriod dateTimeTarget) {
        return this.contains(dateTimeTarget.startDateTime, dateTimeTarget.endDateTime);
    }
}
