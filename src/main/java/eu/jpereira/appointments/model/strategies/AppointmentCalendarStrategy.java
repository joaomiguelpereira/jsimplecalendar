package eu.jpereira.appointments.model.strategies;

import eu.jpereira.appointments.model.data.AppointmentSpecification;

public interface AppointmentCalendarStrategy {

    boolean isFuture(AppointmentSpecification appointmentSpecification);

    boolean isToday(AppointmentSpecification appointmentSpecification);

    boolean isPast(AppointmentSpecification appointmentSpecification);

    int getRemainingDays();

    int getElapsedDays(AppointmentSpecification spec);
}
