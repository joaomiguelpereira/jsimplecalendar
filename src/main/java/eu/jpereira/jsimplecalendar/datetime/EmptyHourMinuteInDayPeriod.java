package eu.jpereira.jsimplecalendar.datetime;


public class EmptyHourMinuteInDayPeriod extends HourMinuteInDayRange {

	public EmptyHourMinuteInDayPeriod() {
	    super("0:00", "0:00");
    }

	@Override
    public boolean includes(HourMinuteInDay dayTime) {
	    return false; //Is empty
    }
	
	

}
