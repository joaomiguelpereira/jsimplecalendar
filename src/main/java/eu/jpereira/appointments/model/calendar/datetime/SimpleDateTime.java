package eu.jpereira.appointments.model.calendar.datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;

import eu.jpereira.appointments.model.calendar.exceptions.InvalidSimpleDateExpressionException;

public class SimpleDateTime implements Comparable<SimpleDateTime> {

    private Calendar backCalendar = null;

    private SimpleDateTime() {
        // use factory method
    }

    public static SimpleDateTime valueOf(String startDateTimeExpression) {
        try {
            return parse(startDateTimeExpression);
        } catch (Exception e) {
            throw new InvalidSimpleDateExpressionException("Please provide a valid date/time in the format dd/mm/yyyy hh:mm", e);
        }

    }

    private static SimpleDateTime parse(String simpleDateExpression) throws Exception {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        Date date = df.parse(simpleDateExpression);
        SimpleDateTime simpleDate = new SimpleDateTime();
        simpleDate.backCalendar = Calendar.getInstance();
        simpleDate.backCalendar.setTime(date);
        return simpleDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.getYear();
        result = prime * result + this.getMonth();
        result = prime * result + this.getDay();
        result = prime * result + this.getHour();
        result = prime * result + this.getMinute();

        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (other instanceof SimpleDateTime) {
            SimpleDateTime otherDate = (SimpleDateTime) other;
            if (this.getYear() == otherDate.getYear() && this.getMonth() == otherDate.getMonth() && this.getDay() == otherDate.getDay()
                    && this.getHour() == otherDate.getHour()) {
                return true;
            }
        }
        return false;

    }

    public int compareTo(SimpleDateTime otherSimpleDateTime) {
        return this.backCalendar.compareTo(otherSimpleDateTime.backCalendar);
    }

    public int getDay() {

        return backCalendar.get(Calendar.DAY_OF_MONTH);
    }

    public int getMonth() {

        return backCalendar.get(Calendar.MONTH) + 1;
    }

    public int getYear() {

        return backCalendar.get(Calendar.YEAR);
    }

    public int getHour() {

        return this.backCalendar.get(Calendar.HOUR_OF_DAY);
    }

    public int getMinute() {

        return this.backCalendar.get(Calendar.MINUTE);
    }

    @Override
    public String toString() {
        Formatter fmt = new Formatter();
        fmt.format("%n%d/%d/%d %d:%d", getDay(), getMonth(), getYear(), getHour(), getMinute());
        return fmt.toString();
    }

}
