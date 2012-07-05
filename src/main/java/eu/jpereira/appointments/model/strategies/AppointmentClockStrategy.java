package eu.jpereira.appointments.model.strategies;

import eu.jpereira.appointments.model.data.AppointmentSpecification;

public interface AppointmentClockStrategy {

    boolean isHappening(AppointmentSpecification appointmentSpecification);

    public int getElapsedMinutesSinceStart(AppointmentSpecification appointmentSpecification);

    public int getElapsedMinutesSinceEnd(AppointmentSpecification appointmentSpecification);

}