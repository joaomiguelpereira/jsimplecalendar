package eu.jpereira.appointments.model;

import java.util.List;

import eu.jpereira.appointments.model.data.TimeSlot;
import eu.jpereira.appointments.model.filters.TimeSlotFilter;
import eu.jpereira.appointments.model.stores.AppointmentsStore;

/**
 * A Schedule is an abstraction over a a set of appointments. It's not meant to
 * be persisted.
 * 
 * @author jpereira
 * 
 */
public class DefaultCalendar implements Calendar {

    private AppointmentsStore appointmentsStore;

    // TODO: Design the rule engine for the Calendar. A first approach may be
    // have a filter over the calendar to apply rules that are given in a rule
    // set. Extend the Calendar with an decorator to apply rules on selected
    // calendar operations
    // private CaalendarRuleSet calendarRuleSet;

    public DefaultCalendar(AppointmentsStore store) {
        this.appointmentsStore = store;
    }

    public List<TimeSlot> findTimeSlots(TimeSlotFilter filter) {
        // TODO Auto-generated method stub
        return null;
    }

    public int countAppointmentsScheduled() {
        return this.appointmentsStore.countAllAppointments();
    }

    public int countAppointmentsScheduled(TimeSlotFilter filter) {

        return this.appointmentsStore.countFilteredAppointments(filter);
    }

    public List<Appointment> findAppointments(TimeSlotFilter filter) {

        return this.appointmentsStore.getFilteredAppointments(filter);
    }

    public void schedule(Appointment appointment) {

        this.appointmentsStore.add(appointment);

    }

    public void reSchedule(Appointment appointment) {
        // TODO Auto-generated method stub

    }

    public void cancel(Appointment appointment) {
        // TODO Auto-generated method stub

    }

}