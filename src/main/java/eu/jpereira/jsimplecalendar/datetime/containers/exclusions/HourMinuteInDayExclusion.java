package eu.jpereira.jsimplecalendar.datetime.containers.exclusions;

import eu.jpereira.jsimplecalendar.datetime.DateTimeComponent;
import eu.jpereira.jsimplecalendar.datetime.HourMinuteInDay;
import eu.jpereira.jsimplecalendar.datetime.HourMinuteInDayRange;

public class HourMinuteInDayExclusion implements DateTimeComponentExclusion {

	private String name;
	private HourMinuteInDayRange excludedHourMinuteInDayRange;

	public HourMinuteInDayExclusion(String name, String startDayTimeExpression, String endDayTimeExpression) {
		this.excludedHourMinuteInDayRange = HourMinuteInDayRange.valueOf(startDayTimeExpression, endDayTimeExpression);
		this.name = name;

	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return String.format("Exclusion: %s -> %d", this.name, this.excludedHourMinuteInDayRange);

	}

	@Override
	public boolean isExcluded(DateTimeComponent dateTimeComponent) {
		// TODO: Review
		return this.excludedHourMinuteInDayRange.includes((HourMinuteInDay) dateTimeComponent);
	}

}
