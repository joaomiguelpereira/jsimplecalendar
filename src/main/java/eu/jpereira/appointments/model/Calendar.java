package eu.jpereira.appointments.model;

import java.util.List;

import eu.jpereira.appointments.model.data.TimeSlot;
import eu.jpereira.appointments.model.filters.TimeSlotFilter;

/**
 * A Calendar represents an abstraction of a set o appointments distrubuted
 * according to a pre-defined time slots. A user of a Calendar can query free
 * time slots on the Calendar, query the shchedule appointments; schedule,
 * reschedule and cancel appointments.
 * 
 * @author jpereira
 * 
 */
public interface Calendar {

    /**
     * Find and return a list of TimeSlots according to the
     * {@link TimeSlotFilter} value
     * 
     * @param filter
     * @return
     */
    public List<TimeSlot> findTimeSlots(TimeSlotFilter filter);

    /**
     * Count the number of appointments scheduled in this calendar
     * 
     * @return
     */
    public int countAppointmentsScheduled();

    /**
     * Count the number of appointments scheduled according to a filter
     * 
     * @param filter
     * @return
     */
    public int countAppointmentsScheduled(TimeSlotFilter filter);

    /**
     * Find appointments according to the filter
     * @param filter
     * @return
     */
    public List<Appointment> findAppointments(TimeSlotFilter filter);

    /**
     * Schedule a new appointment into this calendar
     * @param appointment
     */
    public void schedule(Appointment appointment);

    /**
     * Re-Schedule a new appointment into this calendar
     * @param appointment
     */
    public void reSchedule(Appointment appointment);

    /**
     * Cancel an appointment from this calendar
     * @param appointment
     */
    public void cancel(Appointment appointment);

}
