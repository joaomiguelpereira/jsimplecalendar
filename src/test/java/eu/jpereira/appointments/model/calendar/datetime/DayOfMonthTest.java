package eu.jpereira.appointments.model.calendar.datetime;

import static org.junit.Assert.*;

import org.junit.Test;

import eu.jpereira.appointments.model.calendar.datetime.DayOfMonth;
import eu.jpereira.appointments.model.calendar.exceptions.InvalidDayOfMonthExpressionException;

public class DayOfMonthTest {

    @Test
    public void canGetValueOfValidDayOfMonth() {
        DayOfMonth dayOfMonth = DayOfMonth.valueOf("12/01");
        assertEquals(12, dayOfMonth.getDay());
        assertEquals(1, dayOfMonth.getMonth());
    }

    @Test
    public void canGetAllValues() {
        for (int m = 1; m <= 12; m++) {
            for (int d = 1; d <= 31; d++) {
                String expression = d + "/" + m;
                @SuppressWarnings("unused")
                DayOfMonth dayOfMonth = DayOfMonth.valueOf(expression);
                String expressionPadded = (d < 10 ? "0" + d : d ) + "/" + (m < 10 ? "0" + m : m );
                dayOfMonth = DayOfMonth.valueOf(expressionPadded);

            }
        }
    }

    @Test(expected = InvalidDayOfMonthExpressionException.class)
    public void throwExceptionIncosistentValuesLowerDayBoundary() {
        @SuppressWarnings("unused")
        DayOfMonth dayOfMonth = DayOfMonth.valueOf("0/1");
    }

    @Test(expected = InvalidDayOfMonthExpressionException.class)
    public void throwExceptionIncosistentValuesUpperDayBoundary() {
        @SuppressWarnings("unused")
        DayOfMonth dayOfMonth = DayOfMonth.valueOf("32/1");
    }

    @Test(expected = InvalidDayOfMonthExpressionException.class)
    public void throwExceptionIncosistentValuesLowerMonthBoundary() {
        @SuppressWarnings("unused")
        DayOfMonth dayOfMonth = DayOfMonth.valueOf("1/0");
    }

    @Test(expected = InvalidDayOfMonthExpressionException.class)
    public void throwExceptionIncosistentValuesUpperMonthBoundary() {
        @SuppressWarnings("unused")
        DayOfMonth dayOfMonth = DayOfMonth.valueOf("1/13");
    }

    @Test(expected = InvalidDayOfMonthExpressionException.class)
    public void throwExceptionInvalidValues() {
        @SuppressWarnings("unused")
        DayOfMonth dayOfMonth = DayOfMonth.valueOf("12-b");
    }

}
