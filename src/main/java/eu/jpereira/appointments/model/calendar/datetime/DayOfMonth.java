package eu.jpereira.appointments.model.calendar.datetime;

import java.util.Formatter;

import eu.jpereira.appointments.model.calendar.exceptions.InvalidDayOfMonthExpressionException;

public class DayOfMonth {

    private static final int MAX_DAY = 31;
    private static final int MAX_MONTH = 12;
    private static final int MIN_DAY = 1;
    private static final int MIN_MONTH = 1;

    private int day;
    private int month;

    private DayOfMonth(int day, int month) {
        this.day = day;
        this.month = month;

    }

    /**
     * This method uses one underlying Date and Calendar to calculate the day
     * and time in the expression.
     * 
     * @param dayOfMonthExpression
     *            format dd/MM
     * @return
     */
    public static DayOfMonth valueOf(String dayOfMonthExpression) {

        return parse(dayOfMonthExpression);

    }

    private static DayOfMonth parse(String dayOfMonthExpression) {
        String[] components = dayOfMonthExpression.trim().split("/");
        if (components.length != 2) {
            throw new InvalidDayOfMonthExpressionException("The provided expression is not in the correct format: dd/MM");
        }

        try {

            int day = Integer.valueOf(components[0]);
            int month = Integer.valueOf(components[1]);
            checkConsistency(day, month);
            return new DayOfMonth(day, month);

        } catch (NumberFormatException e) {
            Formatter fmt = new Formatter();
            throw new InvalidDayOfMonthExpressionException(fmt.format("The values are not valid. you provided: %s", dayOfMonthExpression).toString(),
                    e);
        }

    }

    private static void checkConsistency(int targetDay, int targetMonth) {
        if (targetDay > MAX_DAY || targetDay < MIN_DAY) {
            throw new InvalidDayOfMonthExpressionException("You provided a value not allowed for day. Values allowed for day are 1-31");
        }
        if (targetMonth > MAX_MONTH || targetMonth < MIN_MONTH) {
            throw new InvalidDayOfMonthExpressionException("You provided a value not allowed for Month. Values allowed for month are 1-12");
        }

    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.day;
        result = prime * result + this.month;
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
        if (other instanceof DayOfMonth) {
            DayOfMonth otherDayOfMonth = (DayOfMonth) other;
            return this.day == otherDayOfMonth.day && this.month == otherDayOfMonth.month;
        }
        return false;
    }

}