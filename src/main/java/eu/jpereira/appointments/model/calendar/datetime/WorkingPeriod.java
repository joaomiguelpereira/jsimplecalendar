package eu.jpereira.appointments.model.calendar.datetime;

public interface WorkingPeriod<T extends AbstractPeriod> {

    public boolean contains(T abstractPeriod);
}
