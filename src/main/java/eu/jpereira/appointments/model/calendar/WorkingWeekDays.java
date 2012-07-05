package eu.jpereira.appointments.model.calendar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import eu.jpereira.appointments.model.calendar.datetime.WeekDayException;
import eu.jpereira.appointments.model.calendar.datetime.WeekDayPeriod;
import eu.jpereira.appointments.model.calendar.datetime.WorkingPeriod;

public class WorkingWeekDays implements WorkingPeriod<WeekDayPeriod> {

    private Map<String, WeekDayException> exceptionWeekDay;
    private List<WeekDayPeriod> workingWeekDays;

    public WorkingWeekDays(List<WeekDayPeriod> initialWeekDays, Map<String, WeekDayException> initialExceptionWeekDay) {
        this.workingWeekDays = initialWeekDays;
        this.exceptionWeekDay = initialExceptionWeekDay;
    }

    public boolean contains(WeekDayPeriod dayOfTheWeek) {

        for (WeekDayException exceptionWorkingDays : exceptionWeekDay.values()) {
            for (WeekDayPeriod weekDay : exceptionWorkingDays.getWeekDays()) {
                if (weekDay.equals(dayOfTheWeek)) {
                    return false;
                }
            }
        }
        for (WeekDayPeriod weekDay : workingWeekDays) {
            if (weekDay.equals(dayOfTheWeek)) {
                return true;
            }
        }
        return false;

    }

    public void addException(WeekDayException weekDayException) {
        this.exceptionWeekDay.put(weekDayException.getName(), weekDayException);
    }

    public void removeException(String exceptionName) {
        this.exceptionWeekDay.remove(exceptionName);

    }

    public List<WeekDayException> getExceptions() {
        List<WeekDayException> exceptions = new ArrayList<WeekDayException>();
        exceptions.addAll(this.exceptionWeekDay.values());
        return exceptions;
    }

}
