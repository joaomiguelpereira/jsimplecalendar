package eu.jpereira.appointments.model.filters;

import eu.jpereira.appointments.model.Appointment;

/**
 * Filter {@link Appointment} that are between two  filter ranges. 
 * @author jpereira
 *
 */
public class AppointmentRangeFilter {

    protected TimeSlotFilter startAppointmentDateFilter;
    protected TimeSlotFilter endAppointmentDateFilter;
    

    public AppointmentRangeFilter(TimeSlotFilter startFilter, TimeSlotFilter endFilter) {
        this.startAppointmentDateFilter = startFilter;
        this.endAppointmentDateFilter = endFilter;
    }
    

    

}
