package eu.jpereira.appointments.model.calendar;

import java.util.List;

import eu.jpereira.appointments.model.calendar.datetime.DateTimePeriodException;
import eu.jpereira.appointments.model.calendar.datetime.DayOfMonthException;
import eu.jpereira.appointments.model.calendar.datetime.DayTimePeriod;
import eu.jpereira.appointments.model.calendar.datetime.MonthException;
import eu.jpereira.appointments.model.calendar.datetime.MonthPeriod;
import eu.jpereira.appointments.model.calendar.datetime.WeekDayException;
import eu.jpereira.appointments.model.calendar.datetime.WeekDayPeriod;
import eu.jpereira.appointments.model.calendar.datetime.WorkingPeriodFilter;
import eu.jpereira.appointments.model.calendar.datetime.WorkingTimeException;

/**
 * A calendar model models a calendar that have working months, working days,
 * working times and specific periods on time of "non working time"
 * 
 * @author jpereira
 * 
 */
public abstract class CalendarModel {

    protected WorkingMonths workingMonths;

    protected WorkingDayTime workingTime;

    protected WorkingWeekDays workingWeekDays;

    protected WorkingDateTimePeriodExceptions workingDateTimePeriod;

    protected WorkingDayOfMonthExceptions workingDayMonthExceptions;

    public CalendarModel(WorkingMonths initialWorkingMonths, WorkingWeekDays initialWorkingWeekDays, WorkingDayTime initialWorkingTime,
            WorkingDateTimePeriodExceptions initialWorkingDateTimePeriodExceptions, WorkingDayOfMonthExceptions workingDayMonthExceptions) {
        this.workingTime = initialWorkingTime;

        this.workingMonths = initialWorkingMonths;
        this.workingWeekDays = initialWorkingWeekDays;
        this.workingDateTimePeriod = initialWorkingDateTimePeriodExceptions;
        this.workingDayMonthExceptions = workingDayMonthExceptions;
    }

    /**
     * Queries the model about if is the argument a working time, independently
     * of the day
     * 
     * @param dayTimeExpression
     *            A time expression. See {@link DayTimePeriod}
     * @return
     */
    public boolean isWorkingTime(String dayTimeExpression) {
        return this.workingTime.contains(DayTimePeriod.valueOf(dayTimeExpression));
    }

    /**
     * Add a new {@link WorkingTimeException} to the model If you pass an
     * exception with the same name of any already in the model, the old one
     * will be replaced
     * 
     * @param workingTimeException
     */
    public void addWorkingTimeException(WorkingTimeException workingTimeException) {
        this.workingTime.addException(workingTimeException);
    }

    /**
     * Get a new {@link List} containing all {@link WorkingTimeException}
     * considered by this calendar
     * 
     * @return
     */
    public List<WorkingTimeException> getWorkingTimeExceptions() {
        return this.workingTime.getExceptions();
    }

    /**
     * Removes a {@link WorkingTimeException} from the model. If no such name is
     * found, then this method has no effect on the model or behavior
     * 
     * @param exceptionName
     */
    public void removeWorkingTimeException(String exceptionName) {
        this.workingTime.removeException(exceptionName);

    }

    /**
     * Queries the model if a day, independent of the week, is a working day
     * 
     * @param dayOfTheweek
     *            See {@link WeekDayEnum}
     * @return true if is a working week day, false otherwise
     */
    public boolean isWorkingWeekDay(WeekDayPeriod dayOfTheweek) {
        return this.workingWeekDays.contains(dayOfTheweek);
    }

    public void addWeekDayException(WeekDayException weekDayException) {
        this.workingWeekDays.addException(weekDayException);
    }

    public void removeWeekDayException(String exceptionName) {
        this.workingWeekDays.removeException(exceptionName);
    }

    public List<WeekDayException> getWeekDayExceptions() {
        return this.workingWeekDays.getExceptions();
    }

    public boolean isWorkingMonth(MonthPeriod month) {
        return this.workingMonths.contains(month);

    }

    public void addMonthException(MonthException exception) {
        this.workingMonths.addException(exception);

    }

    public void removeMonthException(String name) {
        this.workingMonths.removeException(name);

    }

    public List<MonthException> getMonthExceptions() {
        return this.workingMonths.getExceptions();
    }

    public boolean isWorkingDateTimePeriod(String startDateTimeExpression, String endDateTimeExpression) {
        return this.workingDateTimePeriod.isWorkingDateTimePeriod(startDateTimeExpression, endDateTimeExpression);
    }

    public void addDateTimePeriodException(DateTimePeriodException exception) {
        this.workingDateTimePeriod.addException(exception);
    }

    public void removeDateTimePeriodException(String exceptionName) {
        this.workingDateTimePeriod.removeException(exceptionName);
    }

    public List<DateTimePeriodException> getDateTimePeriodExceptions() {
        return this.workingDateTimePeriod.getExceptions();
    }

    public boolean isWorkingDayOfMonth(String dayOfMonthExpression) {
        return this.workingDayMonthExceptions.isWorkingDayOfMonth(dayOfMonthExpression);

    }

    public void addDayOfMonthException(DayOfMonthException exception) {
        this.workingDayMonthExceptions.addException(exception);

    }

    public void removeDayOfMonthException(String exceptionName) {
        this.workingDayMonthExceptions.removeException(exceptionName);

    }

    public List<DayOfMonthException> getDayOfMonthExceptions() {
        return this.workingDayMonthExceptions.getExceptions();

    }

    public boolean isWorkingPeriod(WorkingPeriodFilter workingPeriodFilter) {
        // return workingPeriodFilter.match(this.workingTime,
        // this.workingDateTimePeriod, this.workingDayMonthExceptions,
        // this.workingWeekDays,this.workingMonths);
        return false;
    }

}
