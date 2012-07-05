package eu.jpereira.appointments.model.calendar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.jpereira.appointments.model.calendar.datetime.DateTimePeriodException;
import eu.jpereira.appointments.model.calendar.datetime.SimpleDateTime;

public class WorkingDateTimePeriodExceptions {

    private Map<String, DateTimePeriodException> exceptions = new HashMap<String, DateTimePeriodException>();

    public void addException(DateTimePeriodException exception) {
        this.exceptions.put(exception.getName(), exception);

    }

    public boolean isWorkingDateTimePeriod(String startDateTimeExpression, String endDateTimeExpression) {
        boolean isWorkingTime = true;
        SimpleDateTime startDateTime = SimpleDateTime.valueOf(startDateTimeExpression);
        SimpleDateTime endDateTime = SimpleDateTime.valueOf(endDateTimeExpression);
        for (DateTimePeriodException exception : this.exceptions.values()) {
            if (exception.contains(startDateTime, endDateTime)) {
                isWorkingTime = false;
                break;
            }
        }
        return isWorkingTime;
    }

    public List<DateTimePeriodException> getExceptions() {
        List<DateTimePeriodException> exceptionValues = new ArrayList<DateTimePeriodException>();
        exceptionValues.addAll(this.exceptions.values());
        return exceptionValues;
    }

    public void removeException(String name) {
        this.exceptions.remove(name);
    }

}
