package eu.jpereira.appointments.model.calendar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import eu.jpereira.appointments.model.calendar.datetime.DayTimePeriod;
import eu.jpereira.appointments.model.calendar.datetime.DayTimeInterval;
import eu.jpereira.appointments.model.calendar.datetime.WorkingPeriod;
import eu.jpereira.appointments.model.calendar.datetime.WorkingTimeException;
import eu.jpereira.appointments.model.calendar.exceptions.WorkingTimeExceptionNotFound;

public class WorkingDayTime implements WorkingPeriod<DayTimePeriod> {

    private Map<String, WorkingTimeException> exceptions;
    private DayTimeInterval dayTimeSlot;

    WorkingDayTime(String startDayTimeExpression, String endDayTimeExpression, Map<String, WorkingTimeException> initialExceptions) {
        this.dayTimeSlot = new DayTimeInterval(startDayTimeExpression, endDayTimeExpression);
        this.exceptions = initialExceptions;
    }

    void addException(WorkingTimeException workingTimeException) {
        exceptions.put(workingTimeException.getName(), workingTimeException);
    }

    public boolean contains(DayTimePeriod dayTime) {

        return this.dayTimeSlot.includes(dayTime) && !isException(dayTime);

    }

    private boolean isException(DayTimePeriod dayTime) {
        for (WorkingTimeException exception : exceptions.values()) {
            if (exception.includes(dayTime)) {
                return true;
            }
        }
        return false;
    }

    List<WorkingTimeException> getExceptions() {
        List<WorkingTimeException> exceptions = new ArrayList<WorkingTimeException>();
        exceptions.addAll(this.exceptions.values());
        return exceptions;

    }

    void removeException(String exceptionName) {
        if (this.exceptions.containsKey(exceptionName)) {
            this.exceptions.remove(exceptionName);
        } else {
            throw new WorkingTimeExceptionNotFound("The exception " + exceptionName + " does not exists in this WorkingTime");
        }

    }

}
