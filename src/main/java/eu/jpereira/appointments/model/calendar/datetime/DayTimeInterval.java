package eu.jpereira.appointments.model.calendar.datetime;

public class DayTimeInterval {

    protected DayTimePeriod startDayTime;
    protected DayTimePeriod endDayTime;

    public DayTimeInterval(String startDayTimeExpression, String endDayTimeExpression) {
        this.startDayTime = DayTimePeriod.valueOf(startDayTimeExpression);
        this.endDayTime = DayTimePeriod.valueOf(endDayTimeExpression);

    }

    public boolean includes(DayTimePeriod dayTime) {

        return (dayTime.compareTo(startDayTime) >= 0 && dayTime.compareTo(endDayTime) < 0);

    }

}
