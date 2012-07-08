package eu.jpereira.jsimplecalendar.datetime;

import eu.jpereira.jsimplecalendar.datetime.exceptions.IllegalDateTimeComponentValueException;

public class TimeInDay implements Comparable<TimeInDay>, DateTimeComponent {

    private static final int UNDEFINED = -1;
    private int hour = UNDEFINED;
    private int minute = UNDEFINED;

    private TimeInDay(String dayTimeExpression) {
        parseDayTimeExpression(dayTimeExpression);

    }

    public static TimeInDay valueOf(String dayTimeExpression) {
        TimeInDay dayTime = new TimeInDay(dayTimeExpression);
        return dayTime;
    }

    private void parseDayTimeExpression(String dayTimeExpression) {
        try {
            int colomIndex = dayTimeExpression.indexOf(":");
            this.hour = Integer.parseInt(dayTimeExpression.substring(0, colomIndex));
            this.minute = Integer.parseInt(dayTimeExpression.substring(colomIndex + 1, dayTimeExpression.length()));

        } catch (Exception e) {
        	throw new IllegalDateTimeComponentValueException("The Expression could not be parsed. Make sure the expression is in the format hh:mm", e);
        }
        checkConsistency();

    }

    private void checkConsistency() {
        if (this.hour < 0 || this.hour > 23 || this.minute < 0 || this.hour > 59) {
        	throw new IllegalDateTimeComponentValueException("Invalid values for hour or minute [0-23]:[0-58]");
        }

    }

    public int getHour() {

        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.getHour();
        result = prime * result + this.getMinute();
        return result;

    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other instanceof TimeInDay) {
            TimeInDay otherDayTime = (TimeInDay) other;
            return (this.hour == otherDayTime.hour && this.minute == otherDayTime.minute);
        } else {
            return false;
        }
    }

    public int compareTo(TimeInDay o) {

        
        int hourDiff = this.hour - o.hour;
        int minuteDiff = this.minute - o.minute;
        return (hourDiff * 60) + minuteDiff;
    }

    public String toString() {
        return hour + ":" + minute;
    }
}
