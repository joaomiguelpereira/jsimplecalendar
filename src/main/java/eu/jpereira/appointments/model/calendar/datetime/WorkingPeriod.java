package eu.jpereira.appointments.model.calendar.datetime;

import eu.jpereira.jsimplecalendar.datetime.DateTimeComponent;

public interface WorkingPeriod<T extends DateTimeComponent> {

    public boolean contains(T abstractPeriod);
}
