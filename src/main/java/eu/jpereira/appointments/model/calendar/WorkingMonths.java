package eu.jpereira.appointments.model.calendar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import eu.jpereira.appointments.model.calendar.datetime.MonthException;
import eu.jpereira.appointments.model.calendar.datetime.MonthPeriod;
import eu.jpereira.appointments.model.calendar.datetime.WorkingPeriod;

/**
 * This class models the Working Months in a calendar model.
 * 
 * @author jpereira
 * 
 */
public class WorkingMonths implements WorkingPeriod<MonthPeriod> {

    private List<MonthPeriod> workingMonths;
    private Map<String, MonthException> excetionWorkingMonths;

    /**
     * Construct a new {@link WorkingMonths}
     * 
     * @param initialWorkingMonths
     * @param initialExceptionWorkingMonths
     */
    public WorkingMonths(List<MonthPeriod> initialWorkingMonths, Map<String, MonthException> initialExceptionWorkingMonths) {
        this.workingMonths = initialWorkingMonths;
        this.excetionWorkingMonths = initialExceptionWorkingMonths;
    }

    public boolean contains(MonthPeriod month) {

        if (isException(month)) {
            return false;
        }

        for (MonthPeriod workingMonth : this.workingMonths) {
            if (workingMonth.equals(month)) {
                return true;
            }
        }
        return false;
    }

    private boolean isException(MonthPeriod month) {
        for (MonthException exception : this.excetionWorkingMonths.values()) {

            for (MonthPeriod exceptionMonthPeriod : exception.getMonths()) {
                if (exceptionMonthPeriod.equals(month)) {
                    return true;
                }
            }
        }
        return false;

    }

    public void addException(MonthException exception) {
        this.excetionWorkingMonths.put(exception.getName(), exception);

    }

    public void removeException(String name) {
        this.excetionWorkingMonths.remove(name);

    }

    public List<MonthException> getExceptions() {
        List<MonthException> exceptions = new ArrayList<MonthException>();
        exceptions.addAll(this.excetionWorkingMonths.values());
        return exceptions;
    }

}
