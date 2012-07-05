package eu.jpereira.appointments.model.stores;

import java.util.List;

import eu.jpereira.appointments.model.Appointment;
import eu.jpereira.appointments.model.filters.TimeSlotFilter;
import eu.jpereira.appointments.model.filters.AppointmentRangeFilter;

public interface AppointmentsStore {

    /**
     * Add an appointment to the sore
     * 
     * @param appointment
     */
    void add(Appointment appointment);

    /**
     * Count all appoitmnets in the store
     * 
     * @return
     */
    int countAllAppointments();

    /**
     * Count all appointments that match the filter. If the filter only
     * specifies a year, then all appointments occuring in the specified year
     * will be filtered
     * 
     * @param filter
     * @return
     */
    int countFilteredAppointments(TimeSlotFilter filter);

    /**
     * Get a list of appointments that macth a give filter
     * @param filter
     * @return
     */
    List<Appointment> getFilteredAppointments(TimeSlotFilter filter);


    int countFilteredRangeAppointments(AppointmentRangeFilter filter);

    List<Appointment> getFilteredRangeAppointments(AppointmentRangeFilter filter);
}
