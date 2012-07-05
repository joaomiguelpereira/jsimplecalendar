package eu.jpereira.appointments.model.calendar.datetime;

import eu.jpereira.appointments.model.calendar.exceptions.InvalidDayTimeExpressionException;

public class DayTimePeriod implements Comparable<DayTimePeriod>, AbstractPeriod {

    private static final int UNDEFINED = -1;
    private int hour = UNDEFINED;
    private int minute = UNDEFINED;

    private DayTimePeriod(String dayTimeExpression) {
        parseDayTimeExpression(dayTimeExpression);

    }

    public static DayTimePeriod valueOf(String dayTimeExpression) {
        DayTimePeriod dayTime = new DayTimePeriod(dayTimeExpression);
        return dayTime;
    }

    private void parseDayTimeExpression(String dayTimeExpression) {
        try {
            int colomIndex = dayTimeExpression.indexOf(":");
            this.hour = Integer.parseInt(dayTimeExpression.substring(0, colomIndex));
            this.minute = Integer.parseInt(dayTimeExpression.substring(colomIndex + 1, dayTimeExpression.length()));

        } catch (Exception e) {
            throw new InvalidDayTimeExpressionException("The Expression could not be parsed. Make sure the expression is in the format hh:mm", e);
        }
        checkConsistency();

    }

    private void checkConsistency() {
        if (this.hour < 0 || this.hour > 23 || this.minute < 0 || this.hour > 59) {
            throw new InvalidDayTimeExpressionException("Invalid values for hour or minute [0-23]:[0-58]");
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
        if (other instanceof DayTimePeriod) {
            DayTimePeriod otherDayTime = (DayTimePeriod) other;
            return (this.hour == otherDayTime.hour && this.minute == otherDayTime.minute);
        } else {
            return false;
        }
    }

    public int compareTo(DayTimePeriod o) {

        if (this.equals(o)) {
            return 0;
        }
        int hourDiff = this.hour - o.hour;
        int minuteDiff = this.minute - o.minute;
        return (hourDiff * 60) + minuteDiff;
    }

    public String toString() {
        return hour + ":" + minute;
    }
}
