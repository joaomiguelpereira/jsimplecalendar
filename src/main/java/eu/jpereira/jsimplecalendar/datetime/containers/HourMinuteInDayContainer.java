package eu.jpereira.jsimplecalendar.datetime.containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import eu.jpereira.jsimplecalendar.datetime.DateTimeComponent;
import eu.jpereira.jsimplecalendar.datetime.HourMinuteInDay;
import eu.jpereira.jsimplecalendar.datetime.HourMinuteInDayRange;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.DateTimeComponentExclusion;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.HourMinuteInDayExclusion;

public class HourMinuteInDayContainer extends MapAndListBackedDateTimeComponentContainer<HourMinuteInDayExclusion> {

	private HourMinuteInDayContainer() {
		this.dateTimeComponentExclusions = new HashMap<String, DateTimeComponentExclusion>(1); //Most likely, lunch time for a break? 
	    this.dateTimeComponents = new ArrayList<DateTimeComponent>();

	}

	private HourMinuteInDayContainer(HourMinuteInDayRange[] hourMinuteInDayRanges) {
	    this.dateTimeComponentExclusions = new HashMap<String, DateTimeComponentExclusion>(1); //Most likely, lunch time for a break? 
	    this.dateTimeComponents = Arrays.asList((DateTimeComponent[])hourMinuteInDayRanges);
	}

	// overloaded
	public boolean contains(HourMinuteInDay hourMinuteInDay) {
		if (isExcluded(hourMinuteInDay)) {
			return false;
		}

		for (DateTimeComponent component : dateTimeComponents) {
			// Huum!!!
			HourMinuteInDayRange convertedComponent = (HourMinuteInDayRange) component;
			if (convertedComponent.includes(hourMinuteInDay)) {
				return true;
			}
		}
		return false;
	}

	public static HourMinuteInDayContainer newContainerWithComponents(HourMinuteInDayRange...hourMinuteInDayRanges) {
		
		return new HourMinuteInDayContainer(hourMinuteInDayRanges);
	}

	public static HourMinuteInDayContainer newEmptyContainer() {
		return new HourMinuteInDayContainer();
	}

}
