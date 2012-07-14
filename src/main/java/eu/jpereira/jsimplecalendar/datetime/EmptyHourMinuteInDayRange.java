package eu.jpereira.jsimplecalendar.datetime;


public class EmptyHourMinuteInDayRange extends HourMinuteInDayRange {

	public EmptyHourMinuteInDayRange() {
	    super("0:0", "0:0");
    }

	@Override
    public boolean includes(HourMinuteInDay dayTime) {
	    return false; //Is empty
    }
	

	

}
