package eu.jpereira.jsimplecalendar.datetime;


public class EmptyTimeInDayPeriod extends TimeInDayPeriod {

	public EmptyTimeInDayPeriod() {
	    super("0:00", "0:00");
    }

	@Override
    public boolean includes(TimeInDay dayTime) {
	    return false; //Is empty
    }
	
	

}
