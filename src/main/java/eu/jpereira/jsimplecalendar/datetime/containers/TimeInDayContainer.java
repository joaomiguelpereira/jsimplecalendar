package eu.jpereira.jsimplecalendar.datetime.containers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import eu.jpereira.appointments.model.calendar.datetime.DayTimeInterval;
import eu.jpereira.appointments.model.calendar.datetime.WorkingTimeException;
import eu.jpereira.appointments.model.calendar.exceptions.WorkingTimeExceptionNotFound;
import eu.jpereira.jsimplecalendar.datetime.TimeInDay;

public class TimeInDayContainer implements DateTimeComponentContainer<TimeInDay> {

    private Map<String, WorkingTimeException> exceptions;
    private DayTimeInterval dayTimeSlot;

    public TimeInDayContainer(String startDayTimeExpression, String endDayTimeExpression, Map<String, WorkingTimeException> initialExceptions) {
        this.dayTimeSlot = new DayTimeInterval(startDayTimeExpression, endDayTimeExpression);
        this.exceptions = initialExceptions;
    }

    public void addException(WorkingTimeException workingTimeException) {
        exceptions.put(workingTimeException.getName(), workingTimeException);
    }

    public boolean contains(TimeInDay dayTime) {

        return this.dayTimeSlot.includes(dayTime) && !isException(dayTime);

    }

    private boolean isException(TimeInDay dayTime) {
        for (WorkingTimeException exception : exceptions.values()) {
            if (exception.includes(dayTime)) {
                return true;
            }
        }
        return false;
    }

    public List<WorkingTimeException> getExceptions() {
        List<WorkingTimeException> exceptions = new ArrayList<WorkingTimeException>();
        exceptions.addAll(this.exceptions.values());
        return exceptions;

    }

    public void removeException(String exceptionName) {
        if (this.exceptions.containsKey(exceptionName)) {
            this.exceptions.remove(exceptionName);
        } else {
            throw new WorkingTimeExceptionNotFound("The exception " + exceptionName + " does not exists in this WorkingTime");
        }

    }

	@Override
    public int getComponentCount() {
	    // TODO Auto-generated method stub
	    return 0;
    }

}
