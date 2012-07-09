package eu.jpereira.jsimplecalendar.datetime;


public class TimeInDayPeriod {

    protected TimeInDay startDayTime;
    protected TimeInDay endDayTime;

    public TimeInDayPeriod(String startDayTimeExpression, String endDayTimeExpression) {
        this.startDayTime = TimeInDay.valueOf(startDayTimeExpression);
        this.endDayTime = TimeInDay.valueOf(endDayTimeExpression);

    }

    public boolean includes(TimeInDay dayTime) {

        return (dayTime.compareTo(startDayTime) >= 0 && dayTime.compareTo(endDayTime) < 0);

    }

}
