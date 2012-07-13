package eu.jpereira.jsimplecalendar.datetime;


public class HourMinuteInDayRange implements DateTimeComponent{

    protected HourMinuteInDay startDayTime;
    protected HourMinuteInDay endDayTime;

    public HourMinuteInDayRange(String startDayTimeExpression, String endDayTimeExpression) {
        this.startDayTime = HourMinuteInDay.valueOf(startDayTimeExpression);
        this.endDayTime = HourMinuteInDay.valueOf(endDayTimeExpression);

    }

    public boolean includes(HourMinuteInDay dayTime) {

        return (dayTime.compareTo(startDayTime) >= 0 && dayTime.compareTo(endDayTime) < 0);

    }

}
