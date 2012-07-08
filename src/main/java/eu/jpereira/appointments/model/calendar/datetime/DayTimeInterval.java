package eu.jpereira.appointments.model.calendar.datetime;

import eu.jpereira.jsimplecalendar.datetime.TimeInDay;

public class DayTimeInterval {

    protected TimeInDay startDayTime;
    protected TimeInDay endDayTime;

    public DayTimeInterval(String startDayTimeExpression, String endDayTimeExpression) {
        this.startDayTime = TimeInDay.valueOf(startDayTimeExpression);
        this.endDayTime = TimeInDay.valueOf(endDayTimeExpression);

    }

    public boolean includes(TimeInDay dayTime) {

        return (dayTime.compareTo(startDayTime) >= 0 && dayTime.compareTo(endDayTime) < 0);

    }

}
