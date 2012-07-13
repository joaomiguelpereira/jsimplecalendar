package eu.jpereira.appointments.model.calendar;

import java.util.List;

import eu.jpereira.appointments.model.calendar.datetime.DateTimePeriodException;
import eu.jpereira.appointments.model.calendar.datetime.DayOfMonthException;
import eu.jpereira.appointments.model.calendar.datetime.WorkingPeriodFilter;
import eu.jpereira.jsimplecalendar.datetime.DayInWeek;
import eu.jpereira.jsimplecalendar.datetime.MonthInYear;
import eu.jpereira.jsimplecalendar.datetime.HourMinuteInDay;
import eu.jpereira.jsimplecalendar.datetime.containers.DayInWeekContainer;
import eu.jpereira.jsimplecalendar.datetime.containers.MonthsInYearContainer;
import eu.jpereira.jsimplecalendar.datetime.containers.HourMinuteInDayContainer;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.DayInWeekExclusion;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.MonthInYearExclusion;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.HourMinuteInDayExclusion;

/**
 * A calendar model models a calendar that have working months, working days,
 * working times and specific periods on time of "non working time"
 * 
 * @author jpereira
 * 
 */
public abstract class CalendarModel {

    protected MonthsInYearContainer workingMonths;

    protected HourMinuteInDayContainer workingTime;

    protected DayInWeekContainer workingWeekDays;

    protected WorkingDateTimePeriodExceptions workingDateTimePeriod;

    protected WorkingDayOfMonthExceptions workingDayMonthExceptions;

    public CalendarModel(MonthsInYearContainer initialWorkingMonths, DayInWeekContainer initialWorkingWeekDays, HourMinuteInDayContainer initialWorkingTime,
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
     *            A time expression. See {@link HourMinuteInDay}
     * @return
     */
    public boolean isWorkingTime(String dayTimeExpression) {
        return this.workingTime.contains(HourMinuteInDay.valueOf(dayTimeExpression));
    }

    /**
     * Add a new {@link HourMinuteInDayExclusion} to the model If you pass an
     * exception with the same name of any already in the model, the old one
     * will be replaced
     * 
     * @param workingTimeException
     */
    public void addWorkingTimeException(HourMinuteInDayExclusion workingTimeException) {
        this.workingTime.addExclusion(workingTimeException);
    }

    /**
     * Get a new {@link List} containing all {@link HourMinuteInDayExclusion}
     * considered by this calendar
     * 
     * @return
     */
    public List<HourMinuteInDayExclusion> getWorkingTimeExceptions() {
        return this.workingTime.getExclusions();
    }

    /**
     * Removes a {@link HourMinuteInDayExclusion} from the model. If no such name is
     * found, then this method has no effect on the model or behavior
     * 
     * @param exceptionName
     */
    public void removeWorkingTimeException(String exceptionName) {
        this.workingTime.removeExclusion(exceptionName);

    }

    /**
     * Queries the model if a day, independent of the week, is a working day
     * 
     * @param dayOfTheweek
     *            See {@link WeekDayEnum}
     * @return true if is a working week day, false otherwise
     */
    public boolean isWorkingWeekDay(DayInWeek dayOfTheweek) {
        return this.workingWeekDays.contains(dayOfTheweek);
    }

    public void addWeekDayException(DayInWeekExclusion weekDayException) {
        this.workingWeekDays.addExclusion(weekDayException);
    }

    public void removeWeekDayException(String exceptionName) {
        this.workingWeekDays.removeExclusion(exceptionName);
    }

    public List<DayInWeekExclusion> getWeekDayExceptions() {
        return this.workingWeekDays.getExclusions();
    }

    public boolean isWorkingMonth(MonthInYear month) {
        return this.workingMonths.contains(month);

    }

    public void addMonthException(MonthInYearExclusion exception) {
        this.workingMonths.addExclusion(exception);

    }

    public void removeMonthException(String name) {
        this.workingMonths.removeExclusion(name);

    }

    public List<MonthInYearExclusion> getMonthExceptions() {
        return this.workingMonths.getExclusions();
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
