package eu.jpereira.jsimplecalendar.datetime;

public class HourMinuteInDayRange implements DateTimeComponent {

	protected HourMinuteInDay startHourMinuteInDay;
	protected HourMinuteInDay endHourMinuteInDay;

	protected HourMinuteInDayRange(String startDayTimeExpression, String endDayTimeExpression) {
		this.startHourMinuteInDay = HourMinuteInDay.valueOf(startDayTimeExpression);
		this.endHourMinuteInDay = HourMinuteInDay.valueOf(endDayTimeExpression);

	}

	public boolean includes(HourMinuteInDay dayTime) {

		return (dayTime.compareTo(startHourMinuteInDay) >= 0 && dayTime.compareTo(endHourMinuteInDay) < 0);

	}

	public static HourMinuteInDayRange valueOf(String startHourMinuteExpression, String endHourMinuteExpression) {
		return new HourMinuteInDayRange(startHourMinuteExpression, endHourMinuteExpression);
	}
	
	
}
