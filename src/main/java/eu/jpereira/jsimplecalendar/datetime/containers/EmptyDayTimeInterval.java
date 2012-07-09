package eu.jpereira.jsimplecalendar.datetime.containers;

import eu.jpereira.appointments.model.calendar.datetime.DayTimeInterval;
import eu.jpereira.jsimplecalendar.datetime.TimeInDay;

public class EmptyDayTimeInterval extends DayTimeInterval {

	public EmptyDayTimeInterval() {
	    super("0:00", "0:00");
    }

	@Override
    public boolean includes(TimeInDay dayTime) {
	    return false; //Is empty
    }
	
	

}
