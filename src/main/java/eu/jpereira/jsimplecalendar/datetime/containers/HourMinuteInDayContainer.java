package eu.jpereira.jsimplecalendar.datetime.containers;

import eu.jpereira.jsimplecalendar.datetime.DateTimeComponent;
import eu.jpereira.jsimplecalendar.datetime.HourMinuteInDay;
import eu.jpereira.jsimplecalendar.datetime.HourMinuteInDayRange;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.HourMinuteInDayExclusion;

public class HourMinuteInDayContainer extends MapAndListBackedDateTimeComponentContainer<HourMinuteInDayExclusion> {

	
	//overloaded
	public boolean contains(HourMinuteInDay hourMinuteInDay) {
		if (isExcluded(hourMinuteInDay)) {
			return false;
		}
		
		for (DateTimeComponent component : dateTimeComponents) {
			//Huum!!!
			HourMinuteInDayRange convertedComponent = (HourMinuteInDayRange)component;
			if (convertedComponent.includes(hourMinuteInDay)) {
				return true;
			}
		}
		return false;
	}
	
}
