package eu.jpereira.appointments.model;

import eu.jpereira.appointments.model.data.AppointmentSpecification;
import eu.jpereira.appointments.model.strategies.AppointmentCalendarStrategy;
import eu.jpereira.appointments.model.strategies.AppointmentClockStrategy;

/**
 * An Appointment is an asbtraction over a an Appointment in a Schedule It works
 * with data from external sources and is not to be persisted
 * 
 * @author jpereira
 * 
 */
public class Appointment {

    private AppointmentCalendarStrategy calendarStrategy;
    private AppointmentClockStrategy clockStrategy;
    private AppointmentSpecification appointmentSpecification;;

    public AppointmentSpecification getAppointmentSpecification() {
        return appointmentSpecification;
    }

    public Appointment() {

    }

    public Appointment(AppointmentSpecification appointmentSpecification,
            AppointmentCalendarStrategy comparatorStrategy, AppointmentClockStrategy clockStrategy) {
        this.appointmentSpecification = appointmentSpecification;
        this.calendarStrategy = comparatorStrategy;
        this.clockStrategy = clockStrategy;
    }

    /**
     * If the appointment is in the future.
     * 
     * @return true if in the future
     */
    public boolean isInFuture() {
        return calendarStrategy.isFuture(this.appointmentSpecification);
    }

    /**
     * Determine if the appoinment is happening now
     * 
     * @return true is is now happening, false otherwise
     */
    public boolean isNow() {
        boolean isToday = calendarStrategy.isToday(this.appointmentSpecification);
        boolean isHappening = clockStrategy.isHappening(this.appointmentSpecification);
        return isToday && isHappening;
        
    }

    /**
     * Calculates the number of minutes elapsed since the start of the
     * appointmet or 0 if the appointment is in the future
     * 
     * @return the number of elapsed minutes since the start of the appointment
     *         or zero if the commitemnet is on the future
     */
    public int getElapsedMinutesSinceStart() {
        return clockStrategy.getElapsedMinutesSinceStart(this.appointmentSpecification);
    }

    /**
     * Calculate and return the elapsed minutes since the end of the appointemnt
     * of zero if the appointment is in the furture is is currently running in
     * time
     * 
     * @return the elapsed minutes since end of the appointment
     */
    public int getElapsedMinutesSinceEnd() {
        return this.clockStrategy.getElapsedMinutesSinceEnd(this.appointmentSpecification);
    }

    /**
     * Query if the appointmnet is in the past
     * 
     * @return true if in the past, false otherwise
     */
    public boolean isPast() {
        boolean isTodayButHappened = this.calendarStrategy.isToday(this.appointmentSpecification) && this.clockStrategy.getElapsedMinutesSinceEnd(appointmentSpecification) > 0;
        return this.calendarStrategy.isPast(this.appointmentSpecification) || isTodayButHappened;
        
    }

    @Override
    public String toString() {

        return super.toString();
    }

}
