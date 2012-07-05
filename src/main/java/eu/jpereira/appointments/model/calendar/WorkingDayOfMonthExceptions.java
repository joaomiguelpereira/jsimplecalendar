package eu.jpereira.appointments.model.calendar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.jpereira.appointments.model.calendar.datetime.DayOfMonth;
import eu.jpereira.appointments.model.calendar.datetime.DayOfMonthException;

public class WorkingDayOfMonthExceptions {

    private Map<String, DayOfMonthException> exceptions = new HashMap<String, DayOfMonthException>();

    void addException(DayOfMonthException exception) {
        this.exceptions.put(exception.getName(), exception);

    }

    boolean isWorkingDayOfMonth(String dayOfMonthExpression) {
        DayOfMonth dayOfMonth = DayOfMonth.valueOf(dayOfMonthExpression);
        for ( DayOfMonthException exception : exceptions.values() ) {
            if ( exception.includes(dayOfMonth)) {
                return false;
            }
        }
        return true;
    }

    void removeException(String exceptionName) {
        this.exceptions.remove(exceptionName);
        
    }

    List<DayOfMonthException> getExceptions() {
        List<DayOfMonthException> resultExceptions = new ArrayList<DayOfMonthException>();
        resultExceptions.addAll(this.exceptions.values());
        return resultExceptions;
    }

}
